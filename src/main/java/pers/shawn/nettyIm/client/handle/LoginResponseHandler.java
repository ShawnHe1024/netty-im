package pers.shawn.nettyIm.client.handle;

import pers.shawn.nettyIm.common.packet.LoginResponsePacket;
import pers.shawn.nettyIm.common.packet.Session;
import pers.shawn.nettyIm.utils.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * @author jimmy
 * @create 2019-01-14 17:28
 * @desc 登录响应处理器
 **/
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoginResponsePacket loginResponsePacket) throws Exception {
        if (loginResponsePacket.isSuccess()) {
            SessionUtil.bindSession(new Session(loginResponsePacket.getUserInfo().getId()), channelHandlerContext.channel());
            System.out.println(new Date() + ": 客户端登录成功!id为: "+loginResponsePacket.getUserInfo().getId());
        } else {
            System.out.println(new Date() + ": 客户端登录失败!原因为: " + loginResponsePacket.getReason());
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端连接被关闭!");
    }
}
