package com.kapokframework.security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.Collection;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * WebSecurityConfigurer
 * <p>
 * 想要查看加载了哪些 {@link SecurityFilterChain} 可以在
 * {@link org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration} 中相应的方法打上断点查看。
 * </p>
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * @since 1.0
 */
@Slf4j
@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // .authenticated() Specify that URLs are allowed by any authenticated user.
        // .denyAll() Specify that URLs are not allowed by anyone.
        // .permitAll() Specify that URLs are allowed by anyone.

        http.authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/login", "/error", "/getAllController").permitAll()
            .requestMatchers("/").authenticated()
            .anyRequest().access((authentication, context) -> {
                Collection<? extends GrantedAuthority> authorities = authentication.get().getAuthorities();
                String requestURI = context.getRequest().getRequestURI();
                log.info("requestURI : {}", requestURI);
                for (GrantedAuthority grantedAuthority : authorities) {
                    RequestMatcher antPathRequestMatcher = new AntPathRequestMatcher(grantedAuthority.getAuthority());
                    if (antPathRequestMatcher.matches(context.getRequest())) {
                        return new AuthorizationDecision(true);
                    }
                }
                return new AuthorizationDecision(false);
            })
        ).formLogin(withDefaults());

        return http.build();

    }

}
