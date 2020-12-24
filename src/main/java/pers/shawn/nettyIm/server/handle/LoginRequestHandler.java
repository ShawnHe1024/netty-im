package pers.shawn.nettyIm.server.handle;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.ibatis.session.SqlSession;
import pers.shawn.nettyIm.entity.SysUser;
import pers.shawn.nettyIm.mapper.SysUserMapper;
import pers.shawn.nettyIm.vo.UserInfo;
import pers.shawn.nettyIm.common.packet.LoginRequestPacket;
import pers.shawn.nettyIm.common.packet.LoginResponsePacket;
import pers.shawn.nettyIm.common.packet.Session;
import pers.shawn.nettyIm.utils.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import static pers.shawn.nettyIm.config.MybatisPlusConfig.getSqlSessionFactory;

/**
 * @author jimmy
 * @create 2019-01-14 17:28
 * @desc 登录请求处理器
 **/
@ChannelHandler.Sharable
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    public static final LoginRequestHandler INSTANCE = new LoginRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoginRequestPacket loginRequestPacket) throws Exception {
        LoginResponsePacket packet = new LoginResponsePacket();
        try (SqlSession session = getSqlSessionFactory().openSession()) {
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            SysUser sysUser = mapper.selectOne(new LambdaQueryWrapper<SysUser>()
                    .eq(SysUser::getUsername, loginRequestPacket.getUsername())
            );
            if (sysUser == null || !(sysUser.getPassword().equals(loginRequestPacket.getPassword()))) {
                packet.setSuccess(false);
                packet.setReason("账号/密码错误");
            } else {
                UserInfo userInfo = new UserInfo();
                userInfo.setId(sysUser.getId());
                userInfo.setNickname(sysUser.getNickname());
                userInfo.setAvatar(sysUser.getAvatar());
                packet.setUserInfo(userInfo);
                SessionUtil.bindSession(new Session(sysUser.getId()), channelHandlerContext.channel());
                packet.setSuccess(true);
                System.out.println("用户" + sysUser.getUsername() + "登录，id为" + userInfo.getId());
            }
            channelHandlerContext.channel().writeAndFlush(packet);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        SessionUtil.unbindSession(ctx.channel());
    }
}
