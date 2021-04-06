package pers.shawn.nettyIm.common.packet;

import lombok.Data;
import pers.shawn.nettyIm.common.Interface.Command;
import pers.shawn.nettyIm.common.Interface.Packet;

/**
 * @author jimmy
 * @create 2019-01-14 10:16
 * @desc 请求加密通信请求包处理
 **/
@Data
public class EncryptRequestPacket extends Packet {

    private Long userId;

    @Override
    public Byte getCommand() {
        return Command.ENCRYPT_REQUEST;
    }
}
