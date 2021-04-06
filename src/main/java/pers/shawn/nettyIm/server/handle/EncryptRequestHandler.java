package pers.shawn.nettyIm.server.handle;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.ibatis.session.SqlSession;
import pers.shawn.nettyIm.common.packet.EncryptRequestPacket;
import pers.shawn.nettyIm.common.packet.ForwardResponsePacket;
import pers.shawn.nettyIm.common.packet.GetFriendsRequestPacket;
import pers.shawn.nettyIm.common.packet.GetFriendsResponsePacket;
import pers.shawn.nettyIm.entity.SysMessage;
import pers.shawn.nettyIm.entity.SysUser;
import pers.shawn.nettyIm.mapper.SysMessageMapper;
import pers.shawn.nettyIm.mapper.SysUserMapper;
import pers.shawn.nettyIm.utils.SessionUtil;
import pers.shawn.nettyIm.vo.UserInfo;

import java.util.List;

import static pers.shawn.nettyIm.config.MybatisPlusConfig.getSqlSessionFactory;

/**
 * @author jimmy
 * @create 2019-01-14 17:29
 * @desc 消息请求处理器
 **/
@ChannelHandler.Sharable
public class EncryptRequestHandler extends SimpleChannelInboundHandler<EncryptRequestPacket> {

    public static final EncryptRequestHandler INSTANCE = new EncryptRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, EncryptRequestPacket encryptRequestPacket) throws Exception {
        ForwardResponsePacket packet = new ForwardResponsePacket();
        Channel toUserChannel = SessionUtil.getChannel(encryptRequestPacket.getUserId());
        if (toUserChannel != null && SessionUtil.hasLogin(toUserChannel)) {
            Long userId = SessionUtil.getSession(channelHandlerContext.channel()).getUserId();
            encryptRequestPacket.setUserId(userId);
            toUserChannel.writeAndFlush(encryptRequestPacket);
            packet.setSuccess(true);
            packet.setReason("已请求，等待对方同意！");
        } else {
            packet.setSuccess(false);
            packet.setReason("对方暂时不在线！");
        }
        channelHandlerContext.writeAndFlush(packet);
    }

}
