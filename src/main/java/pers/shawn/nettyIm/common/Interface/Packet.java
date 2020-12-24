package pers.shawn.nettyIm.common.Interface;

import lombok.Data;

/**
 * @author jimmy
 * @create 2019-01-14 10:12
 * @desc 自定义通信协议包
 **/
@Data
public abstract class Packet {

    //协议版本
    private Byte version = 1;

    private Byte command;

    //获取指令方法
    public abstract Byte getCommand();

}
