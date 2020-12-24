package pers.shawn.nettyIm.server.handle;

import pers.shawn.nettyIm.common.packet.SendToGroupRequestPacket;
import pers.shawn.nettyIm.common.packet.SendToGroupResponsePacket;
import pers.shawn.nettyIm.utils.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @author jimmy
 * @create 2019-02-21 19:38
 * @desc 群聊消息响应处理器
 **/
@ChannelHandler.Sharable
public class GroupMessageRequestHandler extends SimpleChannelInboundHandler<SendToGroupRequestPacket> {

    public static final GroupMessageRequestHandler INSTANCE = new GroupMessageRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, SendToGroupRequestPacket sendToGroupRequestPacket) throws Exception {

        String groupId = sendToGroupRequestPacket.getGroupId();
        SendToGroupResponsePacket packet = new SendToGroupResponsePacket();
        packet.setGroupId(groupId);
        packet.setUser(SessionUtil.getSession(channelHandlerContext.channel()));
        packet.setMessage(sendToGroupRequestPacket.getMessage());

        ChannelGroup group = SessionUtil.getChannelGroup(groupId);
        group.writeAndFlush(packet);

    }
}
