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
public class SearchFriendRequestPacket extends Packet {

    private String username;

    @Override
    public Byte getCommand() {
        return Command.SEARCH_FRIEND_REQUEST;
    }
}
