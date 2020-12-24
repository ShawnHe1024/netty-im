package pers.shawn.nettyIm.common.packet;

import pers.shawn.nettyIm.common.Interface.Command;
import pers.shawn.nettyIm.common.Interface.Packet;
import lombok.Data;

/**
 * @author jimmy
 * @create 2019-02-18 10:40
 * @desc 加入群组响应包
 **/
@Data
public class JoinGroupResponsePacket extends Packet {

    private Boolean success;

    private String groupId;

    @Override
    public Byte getCommand() {
        return Command.JOIN_GROUP_RESPONSE;
    }
}
