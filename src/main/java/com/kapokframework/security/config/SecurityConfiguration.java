package com.kapokframework.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * WebSecurityConfigurer
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * @since 1.0
 */
@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
                .httpBasic(withDefaults())
                .formLogin(withDefaults());

        return http.build();

//        http.authorizeRequests()
//            .requestMatchers("/login.html", "/index").permitAll() // 放行的资源写在 anyRequest 之前
//            .anyRequest().authenticated()
//            .and()
//            .formLogin()
//            .loginPage("/login.html") // 用来指定默认登录页面，注意：一旦指定自定义登录页面之后，必须指定处理登录请求 Url
//            .loginProcessingUrl("/doLogin") // 指定处理登录请求 Url
//            .usernameParameter("uname")
//            .passwordParameter("upass")
//            // .successForwardUrl("") // 指定认证成功后 forward 的 Url ，始终在认证成功之后跳转到指定请求
//            // .defaultSuccessUrl("") // 指定认证成功后 redirect 的 Url ，重定向到上一次访问的 Url
//            .successHandler(null) // 指定认证成功后的处理器
//            // .failureForwardUrl("") // 指定认证失败后 forward 的 Url
//            // .failureUrl("") // 指定认证失败后 redirect 的 Url
//            .failureHandler(null) // 指定认证失败之后的处理器
//            .and()
//            .logout()
//            // .logoutUrl("/logout") // 指定注销登录 Url 默认请求方式必须：GET
//            .logoutRequestMatcher(new OrRequestMatcher(
//                new AntPathRequestMatcher("/aa", "GET"),
//                new AntPathRequestMatcher("/bb", "POST")
//            ))
//            .invalidateHttpSession(true) // 默认 会话失效
//            .clearAuthentication(true) // 默认 清除认证标记
//            // .logoutSuccessUrl("login.html") // 注销成功之后跳转页面
//            .logoutSuccessHandler(null) // 注销成功之后的处理器
//            .and()
//            .csrf().disable(); // 关闭 csrf 跨站请求保护
    }
}
