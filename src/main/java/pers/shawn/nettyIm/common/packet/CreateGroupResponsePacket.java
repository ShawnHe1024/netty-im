package pers.shawn.nettyIm.common.packet;

import pers.shawn.nettyIm.common.Interface.Command;
import pers.shawn.nettyIm.common.Interface.Packet;
import lombok.Data;

import java.util.List;

/**
 * @author jimmy
 * @create 2019-01-18 14:55
 * @desc 创建群聊响应包
 **/
@Data
public class CreateGroupResponsePacket extends Packet {

    private String groupId;

    private boolean success;

    private List<String> usernameList;

    @Override
    public Byte getCommand() {
        return Command.CREATE_GROUP_RESPONSE;
    }
}
