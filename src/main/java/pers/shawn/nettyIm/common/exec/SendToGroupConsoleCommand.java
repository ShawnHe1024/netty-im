package pers.shawn.nettyIm.common.exec;

import pers.shawn.nettyIm.common.Interface.ConsoleCommand;
import pers.shawn.nettyIm.common.packet.SendToGroupRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author jimmy
 * @create 2019-02-21 19:27
 * @desc 发送群消息指令
 **/
public class SendToGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {

        SendToGroupRequestPacket packet = new SendToGroupRequestPacket();
        System.out.println("请输入接收消息的群id");
        packet.setGroupId(scanner.next());
        System.out.println("请输入您想发送的群消息:");
        packet.setMessage(scanner.next());
        channel.writeAndFlush(packet);

    }
}
