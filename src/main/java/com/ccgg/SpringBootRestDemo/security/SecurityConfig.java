package com.ccgg.SpringBootRestDemo.security;

import com.ccgg.SpringBootRestDemo.handler.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * @program:
 * @description:
 * @author: Jina
 * @date:2019-10-02 10:17
 **/

/**
 * cors: cross original resource sharing (浏览器机制) JSONP(在xml里配置, 更老的一种解决机制)
 * xss: cross site scripting.
 * csrf: cross-site request forgery
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthenticationEntryPointImpl authenticationEntryPointImpl;

    @Autowired
    AccessDeniedHandlerImpl accessDeniedHandlerImpl;

    @Autowired
    AuthenticationSuccessHandlerImpl authenticationSuccessHandlerImpl;

    @Autowired
    AuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;

    @Autowired
    LogoutSuccessHandlerImpl logoutSuccessHandlerImpl;

    @Autowired
    UserServiceImpl userDetailsService;

    @Override
    //and() 连接前后两个语法.
    //***
    protected void configure(HttpSecurity http) throws Exception {
        //permitAll 任何用户都被保护.
        //author
        http.csrf().disable()
                .cors()
                .and()
                .authorizeRequests().antMatchers("/products/*").permitAll()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPointImpl)
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandlerImpl)
                .and()
                .formLogin() //默认用的格式是form data
                    .permitAll()
                    .loginProcessingUrl("/login")
                    .successHandler(authenticationSuccessHandlerImpl)
                    .failureHandler(authenticationFailureHandlerImpl)
                    .usernameParameter("username").passwordParameter("password")
                    .and()
                .logout()
                    .permitAll()
                    .logoutUrl("/logout")
                    .logoutSuccessHandler(logoutSuccessHandlerImpl)
                    .and()
                .rememberMe();


    }
    //header是什么

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        //you should only set trusted site here. e.g. http://
        //为什么要加head, options?
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","HEAD","OPTIONS"));
        configuration.addAllowedHeader("*");//jsessionid 在这里面, 所以需要允许 header
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder(11);
        return encoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder());
    }
}
