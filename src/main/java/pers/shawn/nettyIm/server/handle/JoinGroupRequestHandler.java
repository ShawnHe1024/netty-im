package pers.shawn.nettyIm.server.handle;

import pers.shawn.nettyIm.common.packet.JoinGroupRequestPacket;
import pers.shawn.nettyIm.common.packet.JoinGroupResponsePacket;
import pers.shawn.nettyIm.common.packet.Session;
import pers.shawn.nettyIm.utils.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author jimmy
 * @create 2019-02-18 16:42
 * @desc 加入群组请求包处理器
 **/
@ChannelHandler.Sharable
public class JoinGroupRequestHandler extends SimpleChannelInboundHandler<JoinGroupRequestPacket> {

    public static final JoinGroupRequestHandler INSTANCE = new JoinGroupRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, JoinGroupRequestPacket joinGroupRequestPacket) throws Exception {

        String groupId = joinGroupRequestPacket.getGroupId();
        Session session = SessionUtil.getSession(channelHandlerContext.channel());
        SessionUtil.getChannelGroup(groupId).add(channelHandlerContext.channel());

        JoinGroupResponsePacket packet = new JoinGroupResponsePacket();
        packet.setSuccess(true);
        packet.setGroupId(groupId);
        channelHandlerContext.channel().writeAndFlush(packet);

    }
}
