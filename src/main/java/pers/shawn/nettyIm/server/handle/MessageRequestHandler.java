package pers.shawn.nettyIm.server.handle;

import io.netty.channel.*;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedFile;
import org.apache.ibatis.session.SqlSession;
import pers.shawn.nettyIm.entity.SysMessage;
import pers.shawn.nettyIm.mapper.SysMessageMapper;
import pers.shawn.nettyIm.vo.MessageInfo;
import pers.shawn.nettyIm.common.packet.MessageRequestPacket;
import pers.shawn.nettyIm.common.packet.MessageResponsePacket;
import pers.shawn.nettyIm.utils.SessionUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static pers.shawn.nettyIm.config.MybatisPlusConfig.getSqlSessionFactory;

/**
 * @author jimmy
 * @create 2019-01-14 17:29
 * @desc 消息请求处理器
 **/
@ChannelHandler.Sharable
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

    public static final MessageRequestHandler INSTANCE = new MessageRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageRequestPacket messageRequestPacket) throws Exception {
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        MessageInfo messageInfo = messageRequestPacket.getMessageInfo();
        String content;
        if (messageInfo.getType() == 3) {
            File file = new File(System.currentTimeMillis()+".wav");
            FileOutputStream fis = new FileOutputStream(file);
            fis.write(String.valueOf(messageInfo.getContent()).getBytes());
            content = file.getAbsolutePath();
        } else {
            content = String.valueOf(messageInfo.getContent());
        }
        try (SqlSession session = getSqlSessionFactory().openSession()){
            SysMessageMapper mapper = session.getMapper(SysMessageMapper.class);
            SysMessage message = new SysMessage()
                    .setSender(messageInfo.getFromUserId())
                    .setReceiver(messageInfo.getToUserId())
                    .setContent(content)
                    .setType(messageInfo.getType())
                    .setSendTime(Timestamp.from(Instant.ofEpochMilli(messageInfo.getSendTime())));
            mapper.insert(message);
        }
        messageResponsePacket.setMessage(messageInfo);

        Channel toUserChannel = SessionUtil.getChannel(messageInfo.getToUserId());

        if (toUserChannel != null && SessionUtil.hasLogin(toUserChannel)) {
            toUserChannel.writeAndFlush(messageResponsePacket);
            channelHandlerContext.writeAndFlush(messageResponsePacket);
        } else {
//            messageResponsePacket.setMessage("["+messageInfo.getToUserId().toString()+"] 不在线, 发送失败!");
            channelHandlerContext.channel().writeAndFlush(messageResponsePacket);
            System.err.println("["+messageInfo.getToUserId()+"] 不在线, 发送失败!");
        }

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.channel().flush();
        super.channelReadComplete(ctx);
    }
}
