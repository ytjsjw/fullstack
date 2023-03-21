package com.board.project.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Log4j2
@Configuration
public class SecureConfig {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeRequests((auth)->{
           //권한이 없는 유저도 접근 가능 하도록 설정함
           auth.antMatchers("/","/main/index","/login/join","/login/loginPage").permitAll();
        });
        http.csrf().disable();//교차 스크립팅 보안 금지 사용시 활성화

        http.logout().deleteCookies("JSESSIONID");

        http.formLogin();//기본 로그인 폼으로 되돌리기.

        //OAuth2 인증 적용하기
        http.oauth2Login();

        return http.build();
    }
}
