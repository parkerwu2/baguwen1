package com.papa.baguwen1.baguwen1.jwt;

/**
 * token校验
 *
 **/
public class JWTAuthenticationFilter{
//        extends BasicAuthenticationFilter {
//
//    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
//        super(authenticationManager);
//    }
//
//
//    /**
//     * 在此方法中检验客户端请求头中的token,
//     * 如果存在并合法,就把token中的信息封装到 Authentication 类型的对象中,
//     * 最后使用  SecurityContextHolder.getContext().setAuthentication(authentication); 改变或删除当前已经验证的 pricipal
//     *
//     * @param request
//     * @param response
//     * @param chain
//     * @throws IOException
//     * @throws ServletException
//     */
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//        String token = request.getHeader("token");
//        System.out.println("验证token" + token);
//        //判断是否有token
//        if (token == null || !token.startsWith("Bearer ")) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(token);
//        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//
//        //放行
//        chain.doFilter(request, response);
//
//
//    }
//
//    /**
//     * 解析token中的信息,并判断是否过期
//     */
//    private UsernamePasswordAuthenticationToken getAuthentication(String token) {
//
//
////        Claims claims = Jwts.parser().setSigningKey("MyJwtSecret")
////                .parseClaimsJws(token.replace("Bearer ", ""))
////                .getBody();
////
////        //得到用户名
////        String username = claims.getSubject();
////
////        //得到过期时间
////        Date expiration = claims.getExpiration();
////
////        //判断是否过期
////        Date now = new Date();
////
////        if (now.getTime() > expiration.getTime()) {
////
////            throw new UsernameIsExitedException("该账号已过期,请重新登陆");
////        }
//        token = token.replace("Bearer ", "");
//        String username = null;
//        try {
//            username = JWT.decode(token).getAudience().get(0);
//        } catch (Exception e){
//            System.out.println("token解析失败" + token);
//            return null;
//        }
//        // 验证 token
//        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("123")).build();
//        try {
//            jwtVerifier.verify(token);
//        } catch (JWTVerificationException e) {
//            throw new RuntimeException("401");
//        }
//        System.out.println("获取token中的username="+ username);
//        if (username != null) {
//            if (username.equals("admin")) {
//                ArrayList<GrantedAuthority> authorities = new ArrayList<>();
//                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
//                authorities.add(grantedAuthority);
//                return new UsernamePasswordAuthenticationToken(username, "123", authorities);
//            } else {
//                return new UsernamePasswordAuthenticationToken("user", null, new ArrayList<>());
//            }
//        }
//        return null;
//    }


}
