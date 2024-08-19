package com.lrp.springboot.learn_spring_boot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 1. All request should be authenticated
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        // 2. If not authenticated, show a login page for basic authentication
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());

        // 3. CSRF -> POST / PUT
        http.csrf(
                csrf -> csrf.disable()
        );

        return http.build();
    }
}
