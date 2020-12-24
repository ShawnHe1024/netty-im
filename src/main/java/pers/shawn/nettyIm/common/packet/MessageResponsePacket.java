package pers.shawn.nettyIm.common.packet;

import pers.shawn.nettyIm.common.Interface.Command;
import pers.shawn.nettyIm.common.Interface.Packet;
import lombok.Data;
import pers.shawn.nettyIm.vo.MessageInfo;

/**
 * @author jimmy
 * @create 2019-01-14 15:04
 * @desc 客户端发送至服务端的信息对象
 **/
@Data
public class MessageResponsePacket extends Packet {

    private MessageInfo message;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }

}
