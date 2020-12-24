package pers.shawn.nettyIm.common.packet;

import lombok.Data;
import pers.shawn.nettyIm.common.Interface.Command;
import pers.shawn.nettyIm.common.Interface.Packet;
import pers.shawn.nettyIm.vo.UserInfo;

import java.util.List;

/**
 * @author jimmy
 * @create 2019-01-14 10:16
 * @desc 登录请求包处理
 **/
@Data
public class GetFriendsResponsePacket extends Packet {

    private List<UserInfo> userList;

    @Override
    public Byte getCommand() {
        return Command.GET_FRIENDS_RESPONSE;
    }
}
