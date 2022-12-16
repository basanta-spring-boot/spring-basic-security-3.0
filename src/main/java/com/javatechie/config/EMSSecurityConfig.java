package com.javatechie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author Basanta Kumar Hota
 * Approach : Legacy Implementation (WebSecurityConfigurerAdapter Deprecated in Spring Boot 3.0)
 **/
@Configuration
@EnableWebSecurity
public class EMSSecurityConfig
        extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Basant")
                .password(passwordEncoder().encode("Pwd1"))
                .roles("USER");
        auth.inMemoryAuthentication()
                .withUser("Santosh")
                .password(passwordEncoder()
                        .encode("Pwd2"))
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/text").permitAll()
                .and()
                .authorizeRequests().antMatchers("/greeting", "/text/**").authenticated()
                .and().httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
