package com.kapokframework.security.config;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * RbacGrantedAuthority
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * @since 1.0
 */
@Data
public class RbacGrantedAuthority implements GrantedAuthority {

    private String rolename;
    private String authority;

    @Override
    public String getAuthority() {
        return this.authority;
    }

}
