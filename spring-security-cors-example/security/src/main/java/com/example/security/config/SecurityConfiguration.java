package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity // 안하니까 Could not autowire. No beans of 'HttpSecurity' type found 가 떴음 // 2022.2 이상으로 버전 업데이트하면
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .cors(c-> {
                    CorsConfigurationSource source = request -> {
                        CorsConfiguration config = new CorsConfiguration();
                        config.setAllowedOrigins(List.of("http://localhost:8080", "http://127.0.0.1"));
                        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
                        return config;
                    };
                    c.configurationSource(source);
                })
                .csrf().disable()
                .authorizeHttpRequests((authz) -> authz.anyRequest().permitAll())
                .build();
    }
}
