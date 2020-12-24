package pers.shawn.nettyIm.common.packet;

import lombok.Data;

/**
 * @author jimmy
 * @create 2019-01-17 14:37
 * @desc 用户标识
 **/
@Data
public class Session {

    private Long userId;

    public Session(Long userId) {
        this.userId = userId;
    }
}
