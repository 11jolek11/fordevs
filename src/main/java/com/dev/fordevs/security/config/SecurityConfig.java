package com.dev.fordevs.security.config;

import com.dev.fordevs.security.filter.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.AbstractRequestMatcherRegistry;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final AuthenticationProvider authProvider;
    private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(AuthenticationProvider authProvider, JwtAuthFilter jwtAuthFilter) {
        this.authProvider = authProvider;
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // no state, no cookies, no problem with csrf
                // TODO: fill requestMatchers
                .authorizeHttpRequests(authorize -> authorize.requestMatchers("/*").permitAll())
                .authorizeHttpRequests(authorize -> authorize.requestMatchers("/register").permitAll())
                .authorizeHttpRequests(authorize -> authorize.requestMatchers("/login").permitAll())
                .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
                .sessionManagement((sessionManagement) ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}