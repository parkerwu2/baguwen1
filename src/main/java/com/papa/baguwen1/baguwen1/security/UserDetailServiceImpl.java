package com.papa.baguwen1.baguwen1.security;

import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl {
//        implements UserDetailsService {
//    @Value("${system.user.password.secret}")
//    private String secret;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        List<GrantedAuthority> authorityList = new ArrayList<>();
//        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
//        authorityList.add(grantedAuthority);
////        PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(this.secret);
//        String password = passwordEncoder.encode("123");
//        System.out.println("pwd=" + password);
//        UserDetails userDetails = new User("admin", password, authorityList);
//        return userDetails;
//    }
}
