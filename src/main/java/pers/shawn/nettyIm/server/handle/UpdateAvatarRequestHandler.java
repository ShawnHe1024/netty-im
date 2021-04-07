package pers.shawn.nettyIm.server.handle;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.ibatis.session.SqlSession;
import pers.shawn.nettyIm.common.packet.*;
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
public class UpdateAvatarRequestHandler extends SimpleChannelInboundHandler<UpdateAvatarRequestPacket> {

    public static final UpdateAvatarRequestHandler INSTANCE = new UpdateAvatarRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, UpdateAvatarRequestPacket updateAvatarRequestPacket) throws Exception {
        ForwardResponsePacket packet = new ForwardResponsePacket();
        try (SqlSession session = getSqlSessionFactory().openSession()) {
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            Long userId = SessionUtil.getSession(channelHandlerContext.channel()).getUserId();
            SysUser sysUser = new SysUser().setId(userId).setAvatar(updateAvatarRequestPacket.getAvatar());
            int i = mapper.updateById(sysUser);
            if (i > 0) {
                channelHandlerContext.channel().writeAndFlush(updateAvatarRequestPacket);
                return;
            } else {
                packet.setSuccess(false);
                packet.setReason("数据库错误！");
            }
        } catch (Exception e) {
            packet.setSuccess(false);
            packet.setReason("服务器异常！");
        }
        channelHandlerContext.channel().writeAndFlush(packet);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        SessionUtil.unbindSession(ctx.channel());
    }
}
