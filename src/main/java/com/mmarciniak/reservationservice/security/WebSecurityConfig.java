package com.mmarciniak.reservationservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private PasswordEncoder passwordEncoder;
    private DataSource dataSource;

    @Autowired
    public WebSecurityConfig(PasswordEncoder passwordEncoder, DataSource dataSource) {
        this.passwordEncoder = passwordEncoder;
        this.dataSource = dataSource;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .loginProcessingUrl("/authenticateUser")
                .failureUrl("/login?error=true")
                .and()
                .logout()
                .logoutUrl("/login?logout=true")
                .permitAll()
                .and()
                .csrf()
                .disable();


        http.csrf().disable();

        http.headers()
                .frameOptions()
                .sameOrigin();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/font-awesome/**")
                .and()
                .ignoring().antMatchers("/css/**")
                .and()
                .ignoring().antMatchers("/imgs/**")
                .and().ignoring().antMatchers("/js/**");

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT u.name, u.password_hash, 1 FROM user u WHERE u.name=?")
                .authoritiesByUsernameQuery("SELECT u.name, u.role,  FROM user u WHERE u.name=?")
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);
    }


}
