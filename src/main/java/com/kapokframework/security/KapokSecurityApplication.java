package com.kapokframework.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * KapokSecurityApplication
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * @since 1.0
 */
@Slf4j
@SpringBootApplication
public class KapokSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(KapokSecurityApplication.class, args);
        log.info("hello");
    }

}
