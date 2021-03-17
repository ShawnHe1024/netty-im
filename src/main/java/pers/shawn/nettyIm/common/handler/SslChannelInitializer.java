package pers.shawn.nettyIm.common.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;
import pers.shawn.nettyIm.server.handle.*;
import pers.shawn.nettyIm.utils.Spliter;

import javax.net.ssl.SSLEngine;


public class SslChannelInitializer extends ChannelInitializer<NioSocketChannel> {
    private final SslContext context;

    public SslChannelInitializer(SslContext context, boolean startTls) {
        this.context = context;
    }

    @Override
    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
        SSLEngine engine = context.newEngine(nioSocketChannel.alloc());
        engine.setUseClientMode(false);
        nioSocketChannel.pipeline().addFirst("ssl", new SslHandler(engine));
        nioSocketChannel.pipeline().addLast(new IMIdleStateHandler());//心跳检测
        //拆包
        nioSocketChannel.pipeline().addLast(new Spliter());//内部实现关联 channel, 无法使用单例
        nioSocketChannel.pipeline().addLast(PacketCodecHandler.INSTANCE);
        nioSocketChannel.pipeline().addLast(HeartBeatRequestHandler.INSTANCE);
        nioSocketChannel.pipeline().addLast(LoginRequestHandler.INSTANCE);
        nioSocketChannel.pipeline().addLast(AuthHandler.INSTANCE);
        nioSocketChannel.pipeline().addLast(IMHandler.INSTANCE);
    }
}
