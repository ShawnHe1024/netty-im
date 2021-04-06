package pers.shawn.nettyIm.server.handle;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.ibatis.session.SqlSession;
import pers.shawn.nettyIm.common.packet.SearchFriendRequestPacket;
import pers.shawn.nettyIm.common.packet.SearchFriendResponsePacket;
import pers.shawn.nettyIm.entity.SysUser;
import pers.shawn.nettyIm.mapper.SysUserMapper;
import pers.shawn.nettyIm.vo.UserInfo;

import static pers.shawn.nettyIm.config.MybatisPlusConfig.getSqlSessionFactory;

/**
 * @author jimmy
 * @create 2019-01-14 17:29
 * @desc 消息请求处理器
 **/
@ChannelHandler.Sharable
public class SearchFriendRequestHandler extends SimpleChannelInboundHandler<SearchFriendRequestPacket> {

    public static final SearchFriendRequestHandler INSTANCE = new SearchFriendRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, SearchFriendRequestPacket searchFriendRequestPacket) throws Exception {
        SearchFriendResponsePacket packet = new SearchFriendResponsePacket();
        try (SqlSession session = getSqlSessionFactory().openSession()){
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            SysUser sysUser = mapper.selectOne(new LambdaQueryWrapper<SysUser>()
                    .eq(SysUser::getUsername, searchFriendRequestPacket.getUsername())
            );
            UserInfo userInfo = new UserInfo();
            userInfo.setId(sysUser.getId());
            userInfo.setNickname(sysUser.getNickname());
            userInfo.setAvatar(sysUser.getAvatar());
            packet.setUserInfo(userInfo);
        }
        channelHandlerContext.writeAndFlush(packet);
    }

}
