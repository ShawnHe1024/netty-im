package pers.shawn.nettyIm.client.handle;

import pers.shawn.nettyIm.common.packet.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author jimmy
 * @create 2019-01-14 17:28
 * @desc 信息响应处理类
 **/
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageResponsePacket messageResponsePacket) throws Exception {
        System.out.println("用户:"+messageResponsePacket.getMessage().getFromUserId()+"发送消息给你:"+messageResponsePacket.getMessage().getContent());
    }
}
