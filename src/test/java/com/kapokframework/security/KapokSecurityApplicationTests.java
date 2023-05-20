package com.kapokframework.security;

import com.kapokframework.security.entity.User;
import com.kapokframework.security.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * KapokSecurityApplicationTests
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * @since 1.0
 */
@Slf4j
@SpringBootTest
public class KapokSecurityApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        User user = userMapper.selectUserByUsername("admin");
        log.info("{}", user);
    }

}
