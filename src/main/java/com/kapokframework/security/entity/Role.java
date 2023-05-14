package com.kapokframework.security.entity;

import lombok.Data;

/**
 * Role
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * @since 1.0
 */
@Data
public class Role {
    private Long id;
    private String rolename;
    private String description;
}
