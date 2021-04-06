package pers.shawn.nettyIm.common.packet;

import lombok.Data;
import pers.shawn.nettyIm.common.Interface.Command;
import pers.shawn.nettyIm.common.Interface.Packet;
import pers.shawn.nettyIm.vo.UserInfo;

/**
 * @author jimmy
 * @create 2019-01-14 10:16
 * @desc 查询好友请求包处理
 **/
@Data
public class AddFriendResponsePacket extends Packet {

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {
        return Command.ADD_FRIEND_RESPONSE;
    }
}
