package pers.shawn.nettyIm.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author shawn
 * @since 2020-11-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserRelationship implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 邀请人
     */
    private Long inviter;

    /**
     * 被邀请人
     */
    private Long invitee;

    /**
     * 邀请时间
     */
    private LocalDateTime createTime;

    /**
     * 删除关系标识
     */
    @TableLogic
    private Boolean delFlag;


}
