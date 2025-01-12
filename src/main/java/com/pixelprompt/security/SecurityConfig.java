package com.pixelprompt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home", "/public/**").permitAll()
                        .requestMatchers("/api/v1/user/auth/**").permitAll()
                        .anyRequest().permitAll()
                ).formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                ).csrf(AbstractHttpConfigurer::disable);


        return http.build();
    }
}