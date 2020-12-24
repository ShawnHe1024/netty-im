package pers.shawn.nettyIm.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author shawn
 * @since 2020-11-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 发送人
     */
    private Long sender;

    /**
     * 接收人
     */
    private Long receiver;

    /**
     * 内容
     */
    private String content;

    /**
     * 消息类型
     */
    private Integer type;

    /**
     * 发送时间
     */
    private Timestamp sendTime;

    /**
     * 删除标识
     */
    @TableLogic
    private Boolean delFlag;


}
