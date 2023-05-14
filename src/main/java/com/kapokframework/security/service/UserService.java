package com.kapokframework.security.service;

import com.kapokframework.security.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserService
 * 实现了 {@link UserDetailsService} 的 loadUserByUsername 方法，用于从数据库加用户。
 * 这里只关心怎么加载用户信息，并不在乎用户是如何创建并维护的。在设计用户服务时需要考虑创建维护用户的功能
 * 与安全认证的加载功能是否应该设计在一起。
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.selectUserByUsername(username);
    }
}
