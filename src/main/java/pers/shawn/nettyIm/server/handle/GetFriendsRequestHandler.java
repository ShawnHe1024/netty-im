package pers.shawn.nettyIm.server.handle;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.ibatis.session.SqlSession;
import pers.shawn.nettyIm.common.packet.GetFriendsRequestPacket;
import pers.shawn.nettyIm.common.packet.GetFriendsResponsePacket;
import pers.shawn.nettyIm.entity.SysMessage;
import pers.shawn.nettyIm.entity.SysUser;
import pers.shawn.nettyIm.mapper.SysMessageMapper;
import pers.shawn.nettyIm.mapper.SysUserMapper;
import pers.shawn.nettyIm.utils.SessionUtil;
import pers.shawn.nettyIm.vo.UserInfo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.LinkedList;
import java.util.List;

import static pers.shawn.nettyIm.config.MybatisPlusConfig.getSqlSessionFactory;

/**
 * @author jimmy
 * @create 2019-01-14 17:29
 * @desc 消息请求处理器
 **/
@ChannelHandler.Sharable
public class GetFriendsRequestHandler extends SimpleChannelInboundHandler<GetFriendsRequestPacket> {

    public static final GetFriendsRequestHandler INSTANCE = new GetFriendsRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, GetFriendsRequestPacket getFriendsRequestPacket) throws Exception {
        GetFriendsResponsePacket packet = new GetFriendsResponsePacket();
        Long userId = SessionUtil.getSession(channelHandlerContext.channel()).getUserId();
        try (SqlSession session = getSqlSessionFactory().openSession()){
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            SysMessageMapper messageMapper = session.getMapper(SysMessageMapper.class);
            List<UserInfo> userList = mapper.getMyFriends(Wrappers.<SysUser>lambdaQuery()
                    .select(SysUser::getId, SysUser::getNickname, SysUser::getAvatar),
                    userId
            );
            userList.forEach(userInfo -> {
                SysMessage sysMessage = messageMapper.getLastChat(userInfo.getId(), userId);
                if (sysMessage != null) {
                    userInfo.setLastMessage(sysMessage);
                }
            });
            packet.setUserList(userList);
        }
        channelHandlerContext.writeAndFlush(packet);
    }

}
