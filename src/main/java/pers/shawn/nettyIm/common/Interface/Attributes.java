package pers.shawn.nettyIm.common.Interface;

import pers.shawn.nettyIm.common.packet.Session;
import io.netty.util.AttributeKey;

/**
 * @author jimmy
 * @create 2019-01-14 15:06
 * @desc 属性
 **/
public interface Attributes {

    AttributeKey<Session> SESSION =AttributeKey.newInstance("session");

}
