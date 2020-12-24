package pers.shawn.nettyIm.vo;

import lombok.Data;
import pers.shawn.nettyIm.entity.SysMessage;

/**
 * @author shawn
 * @create 2020/11/11 15:19
 * @desc
 **/
@Data
public class UserInfo {

    private Long id;

    private String nickname;

    private String avatar;

    private SysMessage lastMessage;

}
