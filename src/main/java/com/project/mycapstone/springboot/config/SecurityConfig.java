package com.project.mycapstone.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/pub/**", "/users/**", "/", "/index").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                // url to the login page
                    .loginPage("/users/login")
                // url login page will submit to with action users/login method POST
                    .loginProcessingUrl("/users/login")
                    .defaultSuccessUrl("/")
                .and()
                .logout()
                    .invalidateHttpSession(true)
                    .logoutUrl("/users/logout")
                // url to send browser after user has logged out
                    .logoutSuccessUrl("/index");


    }

    @Bean
    public PasswordEncoder getPassWordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
