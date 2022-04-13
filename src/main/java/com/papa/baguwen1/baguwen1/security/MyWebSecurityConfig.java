package com.papa.baguwen1.baguwen1.security;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MyWebSecurityConfig{
//        extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private UserDetailServiceImpl userService;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private CustomAuthenticationProvider customAuthenticationProvider;
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication()
////                .withUser("root").password("123").roles("ADMIN","DBA")
////                .and()
////                .withUser("admin").password("123").roles("ADMIN","USER")
////                .and()
////                .withUser("hangge").password("123").roles("USER");
////        auth.userDetailsService(userService);
//        auth.authenticationProvider(customAuthenticationProvider);
//    }    // 配置 URL 访问权限
//    @Override
//    protected  void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests() // 开启 HttpSecurity 配置
//                .antMatchers("/admin/**").hasRole("ADMIN") // admin/** 模式URL必须具备ADMIN角色
//                .antMatchers("/user/**").access("hasAnyRole('ADMIN','USER')") // 该模式需要ADMIN或USER角色
//                .antMatchers("/hello/**").access("hasRole('ADMIN') or hasRole('DBA')") // 需ADMIN和DBA角色
//                .anyRequest().authenticated() // 用户访问其它URL都必须认证后访问（登录后访问）
//                .and().formLogin().loginProcessingUrl("/login").permitAll() // 开启表单登录并配置登录接口
//                .and().csrf().disable(); // 关闭csrf
////        http.addFilter(new JWTLoginFilter(authenticationManager())) //整合jwt验证登录
////        .addFilter(new JWTAuthenticationFilter(authenticationManager())); //整合jwt验证token
//    }
}