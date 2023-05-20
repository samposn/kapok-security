package com.kapokframework.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kapokframework.security.config.RbacGrantedAuthority;
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
            "   r.rolename, " +
            "   p.pattern as authority " +
            "from " +
            "   permission p, " +
            "   role r, " +
            "   role_permission rp, " +
            "   user_role ur " +
            "where " +
            "   p.id = rp.permission_id " +
            "   and r.id = rp.role_id " +
            "   and rp.role_id = ur.role_id " +
            "   and ur.user_id = #{userId}")
    List<RbacGrantedAuthority> selectRbacGrantedAuthorityListByUserId(Long userId);

}
