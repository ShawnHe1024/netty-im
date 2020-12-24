package pers.shawn.nettyIm.common.packet;

import pers.shawn.nettyIm.common.Interface.Command;
import pers.shawn.nettyIm.common.Interface.Packet;
import lombok.Data;

import java.util.Map;

/**
 * @author jimmy
 * @create 2019-02-18 10:33
 * @desc 展示群组成员响应包
 **/
@Data
public class ListGroupMembersResponsePacket extends Packet {

    private String groupId;

    private Map<String, String> users;

    @Override
    public Byte getCommand() {
        return Command.LIST_GROUP_MEMBERS_RESPONSE;
    }
}
