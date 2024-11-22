package com.example.oauth.config.auth;

import com.example.oauth.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configurable
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(
                        (csrfConfig) -> csrfConfig.disable()
                )
                .headers(
                        (headerConfig) -> headerConfig.frameOptions(
                                frameOptions -> frameOptions.disable()
                        )
                )
                .authorizeHttpRequests((authorizationRequests) -> authorizationRequests
                        .requestMatchers("/user").hasRole(Role.USER.name())
                        .requestMatchers("/", "/styles/**", "/scripts/**").permitAll()
                        .anyRequest().authenticated()
                )
                .logout(
                        (logoutConfig) -> logoutConfig.logoutSuccessUrl("/")
                )
                .oauth2Login(Customizer.withDefaults())
                .build();
    }
}
