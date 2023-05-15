package com.example.happyanddaily.auth.config;

import com.example.happyanddaily.auth.handler.MyAccessDeniedHandler;
import com.example.happyanddaily.auth.handler.MyAuthenticationEntryPoint;
import com.example.happyanddaily.auth.service.PrincipalOauth2UserService;
import com.example.happyanddaily.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PrincipalOauth2UserService principalOauth2UserService;

    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                //인증
//                .antMatchers("").authenticated()
                //인가
//                .antMatchers("").hasAuthority(User.UserRole.ADMIN.name())
                .anyRequest().permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .formLogin().disable()
                .oauth2Login()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .userInfoEndpoint()
                .userService(principalOauth2UserService);
//        http
//                .exceptionHandling()
//                .authenticationEntryPoint(new MyAuthenticationEntryPoint())
//                .accessDeniedHandler(new MyAccessDeniedHandler());
    }
}
