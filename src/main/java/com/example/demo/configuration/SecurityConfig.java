package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Profile("h2")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("customer")
                .password(passwordEncoder().encode("1234"))
                .roles("CUSTOMER")
                .and()
                .withUser("guest")
                .password(passwordEncoder().encode("1234"))
                .roles("GUEST");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()/*.anyRequest().authenticated()*/
                .antMatchers("/").hasAnyRole("GUEST","CUSTOMER")
                .antMatchers("/product/**").hasRole("CUSTOMER")
                .and()
                .formLogin().loginPage("/showLogInForm")
                .loginProcessingUrl("/authUser")
                .failureUrl("/login-error").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access_denied");

        http.csrf().ignoringAntMatchers("/h2-console/**");
        http.headers()
                .frameOptions()
                .sameOrigin();
    }
}
