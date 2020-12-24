package pers.shawn.nettyIm.common.packet;

import pers.shawn.nettyIm.common.Interface.Command;
import pers.shawn.nettyIm.common.Interface.Packet;
import lombok.Data;

/**
 * @author jimmy
 * @create 2019-02-21 19:23
 * @desc 发送群消息请求包
 **/
@Data
public class SendToGroupRequestPacket extends Packet {

    private String groupId;

    private String message;


    @Override
    public Byte getCommand() {
        return Command.MESSAGE_GROUP_REQUEST;
    }
}
