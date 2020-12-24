package pers.shawn.nettyIm.common.exec;

import pers.shawn.nettyIm.common.Interface.ConsoleCommand;
import pers.shawn.nettyIm.common.packet.QuitGroupRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author jimmy
 * @create 2019-02-18 17:00
 * @desc 退出群组指令
 **/
public class QuitGroupRequestConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {

        QuitGroupRequestPacket packet = new QuitGroupRequestPacket();
        System.out.println("请输入您想要退出的群组id:");
        String groupId = scanner.next();
        packet.setGroupId(groupId);

        channel.writeAndFlush(packet);

    }
}
