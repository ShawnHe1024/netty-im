package pers.shawn.nettyIm.server.handle;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.ibatis.session.SqlSession;
import pers.shawn.nettyIm.common.packet.LoginResponsePacket;
import pers.shawn.nettyIm.common.packet.LogoutRequestPacket;
import pers.shawn.nettyIm.common.packet.RegisterRequestPacket;
import pers.shawn.nettyIm.common.packet.Session;
import pers.shawn.nettyIm.entity.SysUser;
import pers.shawn.nettyIm.mapper.SysUserMapper;
import pers.shawn.nettyIm.utils.SessionUtil;
import pers.shawn.nettyIm.vo.UserInfo;

import static pers.shawn.nettyIm.config.MybatisPlusConfig.getSqlSessionFactory;

/**
 * @author jimmy
 * @create 2019-01-14 17:28
 * @desc 登录请求处理器
 **/
@ChannelHandler.Sharable
public class LogoutRequestHandler extends SimpleChannelInboundHandler<LogoutRequestPacket> {

    public static final LogoutRequestHandler INSTANCE = new LogoutRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LogoutRequestPacket loginRequestPacket) throws Exception {
        SessionUtil.unbindSession(channelHandlerContext.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        SessionUtil.unbindSession(ctx.channel());
    }
}
