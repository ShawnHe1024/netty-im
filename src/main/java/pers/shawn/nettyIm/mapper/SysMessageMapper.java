package pers.shawn.nettyIm.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pers.shawn.nettyIm.entity.SysMessage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shawn
 * @since 2020-11-16
 */
public interface SysMessageMapper extends BaseMapper<SysMessage> {

    @Select("SELECT\n" +
            "\t* \n" +
            "FROM\n" +
            "\tsys_message \n" +
            "WHERE\n" +
            "\t( sender = #{userId} AND receiver = #{loginUserId} ) \n" +
            "\tOR ( sender = #{loginUserId} AND receiver = #{userId} ) \n" +
            "ORDER BY\n" +
            "\tsend_time DESC \n" +
            "\tLIMIT 1")
    SysMessage getLastChat(@Param("userId") Long userId, @Param("loginUserId") Long loginUserId);

}
