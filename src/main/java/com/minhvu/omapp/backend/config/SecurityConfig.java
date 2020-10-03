package com.minhvu.omapp.backend.config;

import com.minhvu.omapp.backend.service.CustomizeAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
//    private CustomOidcUserService customOidcUserService;
    private CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{

        System.out.println("000000000000000000000");

        httpSecurity
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/").permitAll() //list of apis not required to do oauth2
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .successHandler(customizeAuthenticationSuccessHandler);
    }

}
