package pers.shawn.nettyIm.common.Interface;

/**
 * @author jimmy
 * @create 2019-01-14 10:14
 * @desc 指令
 **/
public interface Command {

    public static final Byte LOGIN_REQUEST = 1;

    public static final Byte LOGIN_RESPONSE = 2;

    public static final Byte MESSAGE_REQUEST = 3;

    public static final Byte MESSAGE_RESPONSE = 4;

    public static final Byte CREATE_GROUP_REQUEST = 5;

    public static final Byte CREATE_GROUP_RESPONSE = 6;

    public static final Byte LIST_GROUP_MEMBERS_REQUEST = 7;

    public static final Byte LIST_GROUP_MEMBERS_RESPONSE = 8;

    public static final Byte JOIN_GROUP_REQUEST = 9;

    public static final Byte JOIN_GROUP_RESPONSE = 10;

    public static final Byte QUIT_GROUP_REQUEST = 11;

    public static final Byte QUIT_GROUP_RESPONSE = 12;

    public static final Byte MESSAGE_GROUP_REQUEST = 13;

    public static final Byte MESSAGE_GROUP_RESPONSE = 14;

    public static final Byte HEARTBEAT_REQUEST = 15;

    public static final Byte HEARTBEAT_RESPONSE = 16;

    public static final Byte GET_FRIENDS_REQUEST = 17;

    public static final Byte GET_FRIENDS_RESPONSE = 18;

}
