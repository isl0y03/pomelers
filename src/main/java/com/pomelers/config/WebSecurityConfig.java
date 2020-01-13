package com.pomelers.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/images/**",
                "/css/**",
                "/javascript/**");
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER");
    }

    @Override
    //@formatter:off
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                        .antMatchers("/login").anonymous()
                        .anyRequest().authenticated()
                        .and()
                .formLogin()
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/")
                        .failureUrl("/login?error")
                        .permitAll()
                        .and()
                .logout()
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll();
    }
    //@formatter:on

}
