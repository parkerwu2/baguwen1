package com.papa.baguwen1.baguwen1.security;


import org.springframework.stereotype.Component;

/**
 * AuthenticationProvider(身份验证提供者) 顾名思义,可以提供一个 Authentication 供Spring Security的上下文使用,
 *
 * @author itguang
 * @create 2018-01-02 16:23
 **/
@Component
public class CustomAuthenticationProvider{
        //implements AuthenticationProvider {

////    private UserDetailsService userDetailsService;
////
////    private PasswordEncoder bCryptPasswordEncoder;
////
////    public CustomAuthenticationProvider(UserDetailsService userDetailsService, PasswordEncoder bCryptPasswordEncoder) {
////        this.userDetailsService = userDetailsService;
////        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
////    }
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    /**
//     * 是否可以提供输入类型的认证服务
//     * <p>
//     * 如果这个AuthenticationProvider支持指定的身份验证对象，那么返回true。
//     * 返回true并不能保证身份验证提供者能够对身份验证类的实例进行身份验证。
//     * 它只是表明它可以支持对它进行更深入的评估。身份验证提供者仍然可以从身份验证(身份验证)方法返回null，
//     * 以表明应该尝试另一个身份验证提供者。在运行时管理器的运行时，可以选择具有执行身份验证的身份验证提供者。
//     *
//     * @param authentication
//     * @return
//     */
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//
//
//    /**
//     * 验证登录信息,若登陆成功,设置 Authentication
//     *
//     * @param authentication
//     * @return 一个完全经过身份验证的对象，包括凭证。
//     * 如果AuthenticationProvider无法支持已通过的身份验证对象的身份验证，则可能返回null。
//     * 在这种情况下，将会尝试支持下一个身份验证类的验证提供者。
//     */
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        // 获取认证的用户名 & 密码
//        String username = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
////        //通过用户名从数据库中查询该用户
////        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
////
////
////        //判断密码(这里是md5加密方式)是否正确
////        String dbPassword = userDetails.getPassword();
////        String encoderPassword = DigestUtils.md5DigestAsHex(password.getBytes());
////
////        if (!dbPassword.equals(encoderPassword)) {
////            throw new RuntimeException("密码错误");
////        }
////
//
//        // 还可以从数据库中查出该用户所拥有的权限,设置到 authorities 中去,这里模拟数据库查询.
//        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
//        if (password.equals("123")) {
//            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
//            authorities.add(grantedAuthority);
//        } else {
//            throw new RuntimeException("密码错误");
//        }
//        Authentication auth = new UsernamePasswordAuthenticationToken(username, password, authorities);
//
//        return auth;
//
//    }


}

