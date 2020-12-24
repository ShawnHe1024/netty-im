package pers.shawn.nettyIm.server.handle;

import pers.shawn.nettyIm.common.packet.QuitGroupRequestPacket;
import pers.shawn.nettyIm.common.packet.QuitGroupResponsePacket;
import pers.shawn.nettyIm.utils.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @author jimmy
 * @create 2019-02-18 17:01
 * @desc 退出群组请求包处理器
 **/
@ChannelHandler.Sharable
public class QuitGroupRequestHandler extends SimpleChannelInboundHandler<QuitGroupRequestPacket> {

    public static final QuitGroupRequestHandler INSTANCE = new QuitGroupRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, QuitGroupRequestPacket quitGroupRequestPacket) throws Exception {

        String groupId = quitGroupRequestPacket.getGroupId();
        ChannelGroup group = SessionUtil.getChannelGroup(groupId);
        Boolean success = group.remove(channelHandlerContext.channel());

        QuitGroupResponsePacket packet = new QuitGroupResponsePacket();
        packet.setGroupId(groupId);
        packet.setSuccess(success);

        channelHandlerContext.channel().writeAndFlush(packet);

    }
}
