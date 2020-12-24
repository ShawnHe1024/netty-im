package pers.shawn.nettyIm.common.packet;

import pers.shawn.nettyIm.common.Interface.Command;
import pers.shawn.nettyIm.common.Interface.Packet;

/**
 * @author jimmy
 * @create 2019-02-26 10:23
 * @desc 心跳请求包
 **/
public class HeartBeatRequestPacket extends Packet {

    @Override
    public Byte getCommand() {
        return Command.HEARTBEAT_REQUEST;
    }
}
