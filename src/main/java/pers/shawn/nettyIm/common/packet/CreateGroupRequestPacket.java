package pers.shawn.nettyIm.common.packet;

import pers.shawn.nettyIm.common.Interface.Command;
import pers.shawn.nettyIm.common.Interface.Packet;
import lombok.Data;

import java.util.List;

/**
 * @author jimmy
 * @create 2019-01-18 14:30
 * @desc 创建群聊请求包
 **/
@Data
public class CreateGroupRequestPacket extends Packet {
    private List<Long> userIdList;

    @Override
    public Byte getCommand() {
        return Command.CREATE_GROUP_REQUEST;
    }
}
