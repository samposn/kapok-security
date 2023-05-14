package com.kapokframework.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoController
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * @since 1.0
 */
@RestController
public class DemoController {

    /**
     * /admin/**   ROLE_ADMIN
     * /user/**    ROLE_USER
     * /guest/**   ROLE_USER ROLE_GUEST
     *
     * admin      ADMIN USER
     * user       USER
     * blr        GUEST
     *
     */
    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "hello user";
    }

    @GetMapping("/guest/hello")
    public String guest() {
        return "hello guest";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
