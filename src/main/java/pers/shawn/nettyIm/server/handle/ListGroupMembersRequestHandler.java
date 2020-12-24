package pers.shawn.nettyIm.server.handle;

import pers.shawn.nettyIm.common.packet.ListGroupMembersRequestPacket;
import pers.shawn.nettyIm.common.packet.ListGroupMembersResponsePacket;
import pers.shawn.nettyIm.common.packet.Session;
import pers.shawn.nettyIm.utils.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jimmy
 * @create 2019-02-18 10:48
 * @desc 列表展示群组用户请求包处理器
 **/
@ChannelHandler.Sharable
public class ListGroupMembersRequestHandler extends SimpleChannelInboundHandler<ListGroupMembersRequestPacket> {

    public static final ListGroupMembersRequestHandler INSTANCE = new ListGroupMembersRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ListGroupMembersRequestPacket listGroupMembersRequestPacket) throws Exception {

        String groupId = listGroupMembersRequestPacket.getGroupId();
        ChannelGroup group = SessionUtil.getChannelGroup(groupId);

        Map<String, String> users = new HashMap<>();
        for (Channel channel : group) {
            Session session = SessionUtil.getSession(channel);
//            users.put(session.getUserId(), session.getUsername());
        }

        ListGroupMembersResponsePacket packet = new ListGroupMembersResponsePacket();
        packet.setUsers(users);
        packet.setGroupId(groupId);

        channelHandlerContext.channel().writeAndFlush(packet);

    }

}
