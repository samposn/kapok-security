package com.kapokframework.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * WebSecurityConfigurer
 * <p>
 *     想要查看加载了哪些 {@link SecurityFilterChain} 可以在
 * {@link org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration} 中相应的方法打上断点查看。
 * </p>
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * @since 1.0
 */
@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // .authenticated() Specify that URLs are allowed by any authenticated user.
        // .denyAll() Specify that URLs are not allowed by anyone.
        // .permitAll() Specify that URLs are allowed by anyone.

        http.authorizeHttpRequests(authorize -> authorize
//            .requestMatchers("/").authenticated()
            .requestMatchers("/admin/**").hasRole("ADMIN")
//            .requestMatchers("/order").hasAuthority("order")
            .anyRequest().permitAll()
        ).formLogin();

        return http.build();

    }

//    @Bean
//    DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder()
//            .setType(H2)
//            .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
//            .build();
//    }
//
//    @Bean
//    UserDetailsManager users(DataSource dataSource) {
//        UserDetails user = User.builder()
//            .username("user")
//            .password("{bcrypt}$2a$10$t2DLC0tvEhcLwWg0.9pbyOquAP2k6jffx3HQFa8aBXyhma.wqUmwG")
//            .roles("USER")
//            .build();
//        UserDetails admin = User.builder()
//            .username("admin")
//            .password("{bcrypt}$2a$10$hp5zHvkRldpDf3fGIHZU/.2V3lUxF/HCW9laxEw7Tqt0nE8HO8Chm")
//            .roles("USER", "ADMIN")
//            .build();
//        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//        users.createUser(user);
//        users.createUser(admin);
//        return users;
//    }

}
