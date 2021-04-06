package pers.shawn.nettyIm.common.packet;

import lombok.Data;
import pers.shawn.nettyIm.common.Interface.Command;
import pers.shawn.nettyIm.common.Interface.Packet;
import pers.shawn.nettyIm.vo.UserInfo;

import java.util.List;

/**
 * @author jimmy
 * @create 2019-01-14 10:16
 * @desc 查询好友响应包处理
 **/
@Data
public class SearchFriendResponsePacket extends Packet {

    private boolean success;

    private UserInfo userInfo;

    private String reason;

    @Override
    public Byte getCommand() {
        return Command.SEARCH_FRIEND_RESPONSE;
    }
}
