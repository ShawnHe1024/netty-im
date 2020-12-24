package pers.shawn.nettyIm.common.packet;

import pers.shawn.nettyIm.common.Interface.Command;
import pers.shawn.nettyIm.common.Interface.Packet;
import lombok.Data;

/**
 * @author jimmy
 * @create 2019-01-14 10:16
 * @desc 登录请求包处理
 **/
@Data
public class LoginRequestPacket extends Packet {

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
