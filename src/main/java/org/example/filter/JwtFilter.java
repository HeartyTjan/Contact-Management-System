//package org.example.filter;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.validation.constraints.NotNull;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.example.data.repository.UserRepository;
//import org.example.service.JwtService;
//import org.example.service.UserInfoUserDetailsService;
//import org.example.utility.mapper.UserInfoTOUserDetails;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.lang.NonNullApi;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Slf4j
//@Component
//@AllArgsConstructor
//public class JwtFilter extends OncePerRequestFilter {
//
//
//    private final JwtService jwtService;
////    private final UserInfoUserDetailsService customUserDetailsService;
//    private final UserRepository userRepository;
//
//    @Override
//    protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
//        String uri = request.getRequestURI();
//
//        if (uri.startsWith("/user/register")|| uri.startsWith("/user/login")) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//       try {
//           final String authHeader = request.getHeader("Authorization");
//           final String token;
//           final String email;
//
//           if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//               filterChain.doFilter(request, response);
//               return;
//           }
//           token = authHeader.substring(7);
//           email = jwtService.extractEmail(token);
//           System.out.println("jwtemailconfirm " + email);
//           System.out.println("token: " + token);
//
//           if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
////               UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);
//               UserDetails userDetails = userRepository.findUserByContact_Email(email)
//                       .map(UserInfoTOUserDetails::new)
//                       .orElse(null);
//               System.out.println("jwtuserdetails "+ userDetails);
//
//               if (jwtService.validateToken(token, userDetails)) {
//                   UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                   authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                   SecurityContextHolder.getContext().setAuthentication(authentication);
//               }
//           }
//       }catch (Exception e) {
//           response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Invalid token");
//           return;
//       }
//         filterChain.doFilter(request, response);
//    }
//
//}
