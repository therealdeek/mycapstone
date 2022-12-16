package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
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
                    .antMatchers("/pub/**", "/users/**", "/", "/homepage", "/about", "/products", "/cart",
                                "/loginpage", "/fileupload", "/follow", "/search", "/ajax", "/createusers").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/users/login")
                    .loginProcessingUrl("/users/loginpost")
                    .defaultSuccessUrl("/")
                    .and()
                .logout()
                    .invalidateHttpSession(true)
                    .logoutUrl("/users/logout")
                    .logoutSuccessUrl("/");

    }

    @Bean(name = "passwordEncoder")
    public PasswordEncoder getPassWordEncoder() {
        return new BCryptPasswordEncoder();


    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}

