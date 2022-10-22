package kr.onthelive.silver.config;

import kr.onthelive.silver.security.JwtAuthenticationFilter;
import kr.onthelive.silver.security.LoginAccessDeniedHandler;
import kr.onthelive.silver.security.LoginAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .httpBasic().disable()
                .csrf().disable()
                .cors().and()
                .headers().frameOptions().disable()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/v1/**").permitAll()
                .antMatchers("/api/v1/login").permitAll()
                .antMatchers("/api/v1/login1").permitAll()
                .antMatchers("/api/v1/owners").hasRole("ADMIN")
                .antMatchers("/api/v1/owner/new").hasRole("ADMIN")
                //.antMatchers("/api/v1/projects/").permitAll()
                .antMatchers("/v3/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new LoginAccessDeniedHandler())
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new LoginAuthenticationEntryPoint())
                //.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}