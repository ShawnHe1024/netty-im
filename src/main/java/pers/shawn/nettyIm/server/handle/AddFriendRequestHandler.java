package pers.shawn.nettyIm.server.handle;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.ibatis.session.SqlSession;
import pers.shawn.nettyIm.common.packet.AddFriendRequestPacket;
import pers.shawn.nettyIm.common.packet.AddFriendResponsePacket;
import pers.shawn.nettyIm.common.packet.GetFriendsRequestPacket;
import pers.shawn.nettyIm.common.packet.GetFriendsResponsePacket;
import pers.shawn.nettyIm.entity.SysMessage;
import pers.shawn.nettyIm.entity.SysUser;
import pers.shawn.nettyIm.entity.UserRelationship;
import pers.shawn.nettyIm.mapper.SysMessageMapper;
import pers.shawn.nettyIm.mapper.SysUserMapper;
import pers.shawn.nettyIm.mapper.UserRelationshipMapper;
import pers.shawn.nettyIm.utils.SessionUtil;
import pers.shawn.nettyIm.vo.UserInfo;

import java.time.LocalDateTime;
import java.util.List;

import static pers.shawn.nettyIm.config.MybatisPlusConfig.getSqlSessionFactory;

/**
 * @author jimmy
 * @create 2019-01-14 17:29
 * @desc 消息请求处理器
 **/
@ChannelHandler.Sharable
public class AddFriendRequestHandler extends SimpleChannelInboundHandler<AddFriendRequestPacket> {

    public static final AddFriendRequestHandler INSTANCE = new AddFriendRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, AddFriendRequestPacket addFriendRequestPacket) throws Exception {
        AddFriendResponsePacket packet = new AddFriendResponsePacket();
        Long userId = SessionUtil.getSession(channelHandlerContext.channel()).getUserId();
        try (SqlSession session = getSqlSessionFactory().openSession()){
            UserRelationshipMapper mapper = session.getMapper(UserRelationshipMapper.class);
            UserRelationship relationship = new UserRelationship();
            relationship.setInviter(userId);
            relationship.setInvitee(addFriendRequestPacket.getUserId());
            relationship.setCreateTime(LocalDateTime.now());
            relationship.setDelFlag(false);
            int i = mapper.insert(relationship);
            if (i > 0) {
                packet.setSuccess(true);
            } else {
                packet.setSuccess(false);
                packet.setReason("服务器异常");
            }
        }
        channelHandlerContext.writeAndFlush(packet);
    }

}
