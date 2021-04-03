package pers.shawn.nettyIm.server.handle;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.ibatis.session.SqlSession;
import pers.shawn.nettyIm.common.packet.LoginRequestPacket;
import pers.shawn.nettyIm.common.packet.LoginResponsePacket;
import pers.shawn.nettyIm.common.packet.RegisterRequestPacket;
import pers.shawn.nettyIm.common.packet.Session;
import pers.shawn.nettyIm.entity.SysUser;
import pers.shawn.nettyIm.mapper.SysUserMapper;
import pers.shawn.nettyIm.utils.SessionUtil;
import pers.shawn.nettyIm.vo.UserInfo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static pers.shawn.nettyIm.config.MybatisPlusConfig.getSqlSessionFactory;

/**
 * @author jimmy
 * @create 2019-01-14 17:28
 * @desc 登录请求处理器
 **/
@ChannelHandler.Sharable
public class RegisterRequestHandler extends SimpleChannelInboundHandler<RegisterRequestPacket> {

    public static final RegisterRequestHandler INSTANCE = new RegisterRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RegisterRequestPacket registerRequestPacket) throws Exception {
        LoginResponsePacket packet = new LoginResponsePacket();
        try (SqlSession session = getSqlSessionFactory().openSession()) {
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            SysUser sysUser = mapper.selectOne(new LambdaQueryWrapper<SysUser>()
                    .eq(SysUser::getUsername, registerRequestPacket.getUsername())
            );
            if (sysUser != null) {
                packet.setSuccess(false);
                packet.setReason("用户已存在！");
            } else {
                sysUser = new SysUser().setUsername(registerRequestPacket.getUsername())
                        .setPassword(registerRequestPacket.getPassword()).setNickname(registerRequestPacket.getNickname())
                        .setAvatar(registerRequestPacket.getAvatar())
                        .setCreateTime(Timestamp.valueOf(LocalDateTime.now())).setDelFlag(false);
                int i = mapper.insert(sysUser);
                if (i > 0) {
                    UserInfo userInfo = new UserInfo();
                    userInfo.setId(sysUser.getId());
                    userInfo.setNickname(sysUser.getNickname());
                    userInfo.setAvatar(sysUser.getAvatar());
                    packet.setUserInfo(userInfo);
                    SessionUtil.bindSession(new Session(sysUser.getId()), channelHandlerContext.channel());
                    packet.setSuccess(true);
                    System.out.println("用户" + sysUser.getUsername() + "登录，id为" + userInfo.getId());
                } else {
                    packet.setSuccess(false);
                    packet.setReason("注册失败，请稍后重试！");
                }
            }
            channelHandlerContext.channel().writeAndFlush(packet);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        SessionUtil.unbindSession(ctx.channel());
    }
}
