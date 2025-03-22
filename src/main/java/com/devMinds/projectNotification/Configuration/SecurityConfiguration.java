package com.devMinds.projectNotification.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(r -> r.disable())
                .authorizeHttpRequests(r ->r.anyRequest().authenticated())
                .oauth2Login(r -> r.defaultSuccessUrl("/dashboard", true))
                .logout(r -> r.logoutSuccessUrl("/dashboard"))
                .securityContext(r -> r.securityContextRepository(new HttpSessionSecurityContextRepository()))
                .build();
    }
}
