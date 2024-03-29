package com.example.updatedspringsecurity.config;

import com.example.updatedspringsecurity.enum_entity.Authority;
import com.example.updatedspringsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private UserService userService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/signup/**")
                .permitAll()
                .requestMatchers("/student/**")
                .hasAuthority(String.valueOf(Authority.STUDENT))
                .requestMatchers("/teacher/**")
                .hasAuthority(String.valueOf(Authority.TEACHER))
                .requestMatchers("/home/**")
                .authenticated()
                .and()
                .formLogin();

        return http.build();
    }

}
