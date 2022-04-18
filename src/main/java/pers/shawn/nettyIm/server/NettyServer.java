package pers.shawn.nettyIm.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.ssl.ApplicationProtocolNegotiator;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import pers.shawn.nettyIm.common.handler.IMIdleStateHandler;
import pers.shawn.nettyIm.common.handler.SslChannelInitializer;
import pers.shawn.nettyIm.server.handle.*;
import pers.shawn.nettyIm.utils.Spliter;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSessionContext;
import java.io.File;
import java.security.cert.CertificateException;
import java.util.List;

/**
 * @author jimmy
 * @create 2019-01-09 17:06
 * @desc 服务端
 **/
public class NettyServer {

    public static void main(String[] args) throws SSLException, CertificateException {
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        //接收连接
        NioEventLoopGroup boss = new NioEventLoopGroup();
        //读取数据
        NioEventLoopGroup worker = new NioEventLoopGroup();
        serverBootstrap
            .group(boss, worker)
            //指定IO模型
            .channel(NioServerSocketChannel.class)
            .childHandler(new SslChannelInitializer(getSSLContext(), false));
        serverBootstrap.handler(new ChannelInitializer<NioServerSocketChannel>() {
            @Override
            protected void initChannel(NioServerSocketChannel nioServerSocketChannel) throws Exception {
                System.out.println("服务端启动中");
            }
        });
        //添加自定义属性, key-value
        serverBootstrap.attr(AttributeKey.newInstance("serverName"), "nettyServer");

        serverBootstrap.childAttr(AttributeKey.newInstance("clientKey"), "clientValue");

        //TCP心跳机制
        serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
        //高实时性时使用的Nagle算法
        serverBootstrap.childOption(ChannelOption.TCP_NODELAY, true);

        //系统临时存放已完成三次握手的请求队列的最大长度, 连接频繁而服务器处理创建较慢时, 可适当调大
        serverBootstrap.option(ChannelOption.SO_BACKLOG, 1024);
        //绑定端口, 失败时端口号自动加1并重新绑定
        bind(serverBootstrap, 51257);

    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("端口["+port+"]绑定成功!");
                } else {
                    System.out.println("端口["+port+"]绑定失败!");
                    bind(serverBootstrap, port+1);
                }
            }
        });
    }

    private static SslContext getSSLContext() throws SSLException {
        return SslContextBuilder.forServer(
                new File("/home/shawn/code/netty-im/ssl/server.pem"),
                new File("/home/shawn/code/netty-im/ssl/server.key")).build();
    }
//"A87A293E44400FFB26E3F56423B13A9F7DC10E6C45AF184142A6DAD40C6EF549"
}
