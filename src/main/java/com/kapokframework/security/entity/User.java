package com.kapokframework.security.entity;

import com.kapokframework.security.config.RbacGrantedAuthority;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * User
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * @since 1.0
 */
@Data
public class User implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private List<RbacGrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 尚未用到此属性，直接返回 true，表示：是否账户未过期
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 尚未用到此属性，直接返回 true，表示：账户是否未被锁定
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 尚未用到此属性，直接返回 true，表示：账户密码是否未过期
    }

    @Override
    public boolean isEnabled() {
        return true; // 尚未用到些属性，直接返回 true，表示：账户是否启用
    }

}
