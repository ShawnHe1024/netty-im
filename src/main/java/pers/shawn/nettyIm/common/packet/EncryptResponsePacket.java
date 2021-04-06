package pers.shawn.nettyIm.common.packet;

import lombok.Data;
import pers.shawn.nettyIm.common.Interface.Command;
import pers.shawn.nettyIm.common.Interface.Packet;

/**
 * @author jimmy
 * @create 2019-01-14 10:16
 * @desc 查询好友请求包处理
 **/
@Data
public class EncryptResponsePacket extends Packet {

    /**
     * 需要加密通信的对象
     */
    private Long userId;

    /**
     * 是否同意进行加密通信
     */
    private boolean agree;

    /**
     * 发送给对方使用的加密key
     */
    private String key;

    @Override
    public Byte getCommand() {
        return Command.ENCRYPT_RESPONSE;
    }
}
