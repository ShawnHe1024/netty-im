package pers.shawn.nettyIm.common.exec;

import pers.shawn.nettyIm.common.Interface.ConsoleCommand;
import pers.shawn.nettyIm.common.packet.LoginRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author jimmy
 * @create 2019-01-18 14:44
 * @desc 登录控制台指令
 **/
public class LoginConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        System.out.println("输入用户名进行登录: ");
        String username = scanner.nextLine();
        System.out.println("输入密码进行登录: ");
        String password = scanner.nextLine();
        loginRequestPacket.setUsername(username);
        loginRequestPacket.setPassword(password);

        channel.writeAndFlush(loginRequestPacket);

        waitForLoginResponse();
    }

    private static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
    }
}
