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

    public static final Byte REGISTER_REQUEST = 19;

    public static final Byte LOGOUT_REQUEST = 20;

    public static final Byte SEARCH_FRIEND_REQUEST = 21;

    public static final Byte SEARCH_FRIEND_RESPONSE = 22;

    public static final Byte ADD_FRIEND_REQUEST = 23;

    public static final Byte ADD_FRIEND_RESPONSE = 24;

    public static final Byte ENCRYPT_REQUEST = 25;

    public static final Byte ENCRYPT_RESPONSE = 26;

    public static final Byte FORWARD_RESPONSE = 27;

    public static final Byte UPDATE_AVATAR_REQUEST = 28;

}
