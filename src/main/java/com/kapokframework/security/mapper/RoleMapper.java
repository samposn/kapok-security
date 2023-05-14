package com.kapokframework.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kapokframework.security.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * RoleMapper
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * @since 1.0
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    @Select("select " +
            "   r.* " +
            "from "+
            "   role r, user_role ur " +
            "where " +
            "   r.id = ur.role_id " +
            "   and ur.user_id = #{userId} ")
    List<Role> selectRoleListByUserId(Long userId);

}
