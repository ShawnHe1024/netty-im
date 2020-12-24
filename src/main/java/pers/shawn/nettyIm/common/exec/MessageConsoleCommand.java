package pers.shawn.nettyIm.common.exec;

import pers.shawn.nettyIm.common.Interface.ConsoleCommand;
import pers.shawn.nettyIm.vo.MessageInfo;
import pers.shawn.nettyIm.common.packet.MessageRequestPacket;
import io.netty.channel.Channel;
import pers.shawn.nettyIm.utils.SessionUtil;

import java.time.LocalDateTime;
import java.time.temporal.TemporalField;
import java.util.Scanner;

/**
 * @author jimmy
 * @create 2019-01-18 14:49
 * @desc 发送消息指令
 **/
public class MessageConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("输入对方用户id: ");
        Long toUserId = scanner.nextLong();
        System.out.println("输入信息: ");
        String content = scanner.next();
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setId(System.currentTimeMillis());
        messageInfo.setFromUserId(SessionUtil.getSession(channel).getUserId());
        messageInfo.setToUserId(toUserId);
        messageInfo.setContent(content);
        messageInfo.setType(1);
        messageInfo.setSendTime(System.currentTimeMillis());
        MessageRequestPacket packet = new MessageRequestPacket();
        packet.setMessageInfo(messageInfo);
        channel.writeAndFlush(packet);
    }
}
