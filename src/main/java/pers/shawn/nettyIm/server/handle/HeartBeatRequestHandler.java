package pers.shawn.nettyIm.server.handle;

import pers.shawn.nettyIm.common.packet.HeartBeatRequestPacket;
import pers.shawn.nettyIm.common.packet.HeartBeatResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author jimmy
 * @create 2019-02-26 10:26
 * @desc 心跳包请求处理器
 **/
@ChannelHandler.Sharable
public class HeartBeatRequestHandler extends SimpleChannelInboundHandler<HeartBeatRequestPacket> {

    public static final HeartBeatRequestHandler INSTANCE = new HeartBeatRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HeartBeatRequestPacket heartBeatRequestPacket) throws Exception {
        System.out.println("心跳包");
        channelHandlerContext.writeAndFlush(new HeartBeatResponsePacket());
    }
}
