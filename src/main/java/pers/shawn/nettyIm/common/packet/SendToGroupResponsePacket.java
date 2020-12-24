package pers.shawn.nettyIm.common.packet;

import pers.shawn.nettyIm.common.Interface.Command;
import pers.shawn.nettyIm.common.Interface.Packet;
import lombok.Data;

/**
 * @author jimmy
 * @create 2019-02-21 19:25
 * @desc 发送群消息响应包
 **/
@Data
public class SendToGroupResponsePacket extends Packet {

    private String groupId;

    private Session user;

    private String message;


    @Override
    public Byte getCommand() {
        return Command.MESSAGE_GROUP_RESPONSE;
    }
}
