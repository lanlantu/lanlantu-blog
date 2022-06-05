package com.lanlantu.blog.config;

import com.lanlantu.blog.handler.AuthenticationEntryPointImpl;
import com.lanlantu.blog.handler.AuthenticationFailHandlerImpl;
import com.lanlantu.blog.handler.AuthenticationSuccessHandlerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * @version 1.0
 * @Author lanlantu
 * @Date 2022/6/4 22:51
 */
@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationSuccessHandlerImpl authenticationSuccessHandler;
    @Autowired
    private AuthenticationFailHandlerImpl authenticationFailHandler;


    @Autowired
    private AuthenticationEntryPointImpl authenticationEntryPoint;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginProcessingUrl("/login")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailHandler)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint);

        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .csrf().disable();


    }
}
