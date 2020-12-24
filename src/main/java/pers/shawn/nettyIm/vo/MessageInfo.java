package pers.shawn.nettyIm.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author shawn
 * @create 2020/11/11 15:46
 * @desc
 **/
@Data
public class MessageInfo {

    private Long id;

    private Long fromUserId;

    private Long toUserId;

    private Object content;

    private Integer type;

    private Long sendTime;

}
