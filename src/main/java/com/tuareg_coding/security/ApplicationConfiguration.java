package com.tuareg_coding.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               .authorizeRequests()
               .antMatchers("/users").authenticated()
               .anyRequest().permitAll()
               .and()
               .formLogin()
               .usernameParameter("email")
               .defaultSuccessUrl("/users")
               .permitAll()
               .and()
               .logout().logoutSuccessUrl("/home").permitAll();
    }





// .authorizeRequests()
//               .antMatchers("/register")
//               .authenticated()
//               .anyRequest().permitAll()
//               .and()
//               .formLogin()
//               .loginPage("/login").permitAll()
//               .defaultSuccessUrl("/register", true);

//               .usernameParameter("email")
//               .defaultSuccessUrl("/register")
//               .permitAll()
//               .and()
//               .logout().logoutSuccessUrl("/")
//               .permitAll();








}
