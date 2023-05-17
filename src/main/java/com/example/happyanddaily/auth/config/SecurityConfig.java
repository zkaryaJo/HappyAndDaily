package com.example.happyanddaily.auth.config;

import com.example.happyanddaily.auth.handler.MyAccessDeniedHandler;
import com.example.happyanddaily.auth.handler.MyAuthenticationEntryPoint;
import com.example.happyanddaily.auth.service.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig{
    private final PrincipalOauth2UserService principalOauth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                //인증
//                .antMatchers("").authenticated()
                //인가
                //.antMatchers("/admin/*").hasAuthority(User.UserRole.ADMIN.getValue())
                .anyRequest().permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .formLogin().disable()
                .oauth2Login()
                .loginPage("/login/oauth2/kakao")
                .defaultSuccessUrl("/")
                .redirectionEndpoint()
                .baseUri("/login/oauth2/code/*")
                .and()
                .userInfoEndpoint()
                .userService(principalOauth2UserService);
        http
                .exceptionHandling()
                .authenticationEntryPoint(new MyAuthenticationEntryPoint())
                .accessDeniedHandler(new MyAccessDeniedHandler());

        return http.build();
    }
}
