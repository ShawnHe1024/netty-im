package pers.shawn.nettyIm.common.packet;

import lombok.Data;
import pers.shawn.nettyIm.common.Interface.Command;
import pers.shawn.nettyIm.common.Interface.Packet;

/**
 * @author jimmy
 * @create 2019-01-14 10:16
 * @desc 登录请求包处理
 **/
@Data
public class UpdateAvatarRequestPacket extends Packet {

    /**
     * 头像
     */
    private String avatar;

    @Override
    public Byte getCommand() {
        return Command.UPDATE_AVATAR_REQUEST;
    }
}
