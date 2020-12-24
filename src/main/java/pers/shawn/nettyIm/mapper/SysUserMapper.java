package pers.shawn.nettyIm.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pers.shawn.nettyIm.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import pers.shawn.nettyIm.vo.UserInfo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shawn
 * @since 2020-11-16
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    @Select("SELECT\n" +
            "\t${ew.sqlSelect}\n" +
            "FROM\n" +
            "\tsys_user \n" +
            "WHERE\n" +
            "\"id\" IN (SELECT\n" +
            "\tinvitee AS userId \n" +
            "FROM\n" +
            "\tuser_relationship \n" +
            "WHERE\n" +
            "\tinviter = #{userId} UNION ALL\n" +
            "SELECT\n" +
            "\tinviter AS userId \n" +
            "FROM\n" +
            "\tuser_relationship \n" +
            "WHERE\n" +
            "\tinvitee = #{userId})\n")
    public List<UserInfo> getMyFriends(@Param(Constants.WRAPPER)Wrapper<SysUser> wrapper, @Param("userId") Long userId);

}
