package com.kapokframework.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kapokframework.security.entity.Role;
import com.kapokframework.security.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * UserMapper
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * @since 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select " +
            "   id, username, password " +
            "from " +
            "   user " +
            "where " +
            "   username = #{username}")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "username", column = "username"),
        @Result(
            property = "roles",
            javaType = List.class,
            column = "id",
            many = @Many(select = "com.kapokframework.security.mapper.RoleMapper.selectRoleListByUserId")
        )
    })
    User selectUserByUsername(String username);

}
