package com.flyers.tms.config;

import com.flyers.tms.security.CustomAccessDeniedHandler;
import com.flyers.tms.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * Spring security configuration.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig {

  @Autowired
  JwtAuthenticationFilter jwtAuthenticationFilter;

  @Autowired
  CustomAccessDeniedHandler customAccessDeniedHandler;


  /**
   * Security Filter Chain setup for Ams.
   */
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .httpBasic(AbstractHttpConfigurer::disable)
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(
            (authorize) -> {
              authorize
                  .anyRequest()
                  .permitAll();
            }
        )
        .exceptionHandling(
            (exception) -> {
              exception.accessDeniedHandler(customAccessDeniedHandler);
            }
        )
        .sessionManagement(
            (session) -> {
              session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            }
        )
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
    ;

    return http.build();
  }

}
