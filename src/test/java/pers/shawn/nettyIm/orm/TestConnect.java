package pers.shawn.nettyIm.orm;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pers.shawn.nettyIm.common.packet.Session;
import pers.shawn.nettyIm.entity.SysUser;
import pers.shawn.nettyIm.mapper.SysUserMapper;
import pers.shawn.nettyIm.vo.UserInfo;

import java.time.LocalDateTime;
import java.util.List;

import static pers.shawn.nettyIm.config.MybatisPlusConfig.getSqlSessionFactory;

/**
 * @author shawn
 * @create 2020/11/12 16:25
 * @desc
 **/
public class TestConnect {

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()){
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
//            mapper.insert(user);

            SysUser sysUser = mapper.selectOne(new LambdaQueryWrapper<SysUser>()
                    .eq(SysUser::getUsername, "hx")
            );
            System.out.println(sysUser);
//            List<UserInfo> list = mapper.getMyFriends(Wrappers.<SysUser>lambdaQuery()
//                            .select(SysUser::getId, SysUser::getNickname, SysUser::getAvatar),
//                    1328273287825465346L);
//            System.out.println(list);
        }
    }

}
