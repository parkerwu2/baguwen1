package com.papa.baguwen1.baguwen1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@EnableDiscoveryClient
//打开定时
@EnableScheduling
@SpringBootApplication
@MapperScan("com.papa.baguwen1.baguwen1.dao.mapper")
@ConditionalOnProperty(prefix="study", name ="enabled", havingValue = "true")
public class Baguwen1Application {
    // 指定密码的加密方式
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    //        return new PasswordEncoder() {
    //            @Override
    //            public String encode(CharSequence charSequence) {
    //                return charSequence.toString();
    //            }
    //
    //            @Override
    //            public boolean matches(CharSequence charSequence, String s) {
    //                return Objects.equals(charSequence.toString(), s);
    //            }
    //        };
    }
    public static void main(String[] args) {
        SpringApplication.run(Baguwen1Application.class, args);
    }

}
