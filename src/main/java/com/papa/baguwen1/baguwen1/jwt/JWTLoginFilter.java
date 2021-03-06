package com.papa.baguwen1.baguwen1.jwt;


/**
 **/
public class JWTLoginFilter {
//        extends UsernamePasswordAuthenticationFilter {
//
//
//    private AuthenticationManager authenticationManager;
//
//    public JWTLoginFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//
//    /**
//     * 接收并解析用户登陆信息  /login,
//     *为已验证的用户返回一个已填充的身份验证令牌，表示成功的身份验证
//     *返回null，表明身份验证过程仍在进行中。在返回之前，实现应该执行完成该过程所需的任何额外工作。
//     *如果身份验证过程失败，就抛出一个AuthenticationException
//     *
//     *
//     * @param request  从中提取参数并执行身份验证
//     * @param response 如果实现必须作为多级身份验证过程的一部分(比如OpenID)进行重定向，则可能需要响应
//     * @return 身份验证的用户令牌，如果身份验证不完整，则为null。
//     */
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//
//
//        //得到用户登陆信息,并封装到 Authentication 中,供自定义用户组件使用.
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        if (username == null) {
//            username = "";
//        }
//
//        if (password == null) {
//            password = "";
//        }
//
//        username = username.trim();
//
//
//        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
//        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
//        authorities.add(grantedAuthority);
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password, authorities);
//
//        //authenticate()接受一个token参数,返回一个完全经过身份验证的对象，包括证书.
//        // 这里并没有对用户名密码进行验证,而是使用 AuthenticationProvider 提供的 authenticate 方法返回一个完全经过身份验证的对象，包括证书.
////        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
//        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
////UsernamePasswordAuthenticationToken 是 Authentication 的实现类
//        System.out.println("登录成功");
//        return authenticate;
//    }
//
//
//    /**
//     * 登陆成功后,此方法会被调用,因此我们可以在次方法中生成token,并返回给客户端
//     *
//     * @param request
//     * @param response
//     * @param chain
//     * @param authResult
//     */
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request,
//                                            HttpServletResponse response,
//                                            FilterChain chain, Authentication authResult) {
//
////        String token = Jwts.builder()
////                .setSubject(authResult.getName())
////                //有效期两小时
////                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 2 * 1000))
////                //采用什么算法是可以自己选择的，不一定非要采用HS512
////                .signWith(SignatureAlgorithm.HS512, "MyJwtSecret")
////                .compact();
//
//        String token = JWT.create().withAudience(authResult.getName())
//                .sign(Algorithm.HMAC256("123"));
//        System.out.println("登录以后设置token=" + token);
//        response.addHeader("token", "Bearer " + token);
//
//    }
}

