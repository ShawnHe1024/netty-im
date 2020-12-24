package pers.shawn.nettyIm.common.packet;

import pers.shawn.nettyIm.common.Interface.Command;
import pers.shawn.nettyIm.common.Interface.Packet;
import lombok.Data;
import pers.shawn.nettyIm.vo.UserInfo;

/**
 * @author jimmy
 * @create 2019-01-14 11:31
 * @desc 登录相应类
 **/
@Data
public class LoginResponsePacket extends Packet {

    private boolean success;

    private UserInfo userInfo;

    private String reason;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
