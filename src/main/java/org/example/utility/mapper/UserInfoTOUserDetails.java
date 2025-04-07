//package org.example.utility.mapper;
//
//import org.example.data.model.Contact;
//import org.example.data.model.UserModel;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class UserInfoTOUserDetails  implements UserDetails{
//
//    private final String email;
//    private final String password;
//    private final String role;
////    private final List<GrantedAuthority> authorities;
//
//
//    public UserInfoTOUserDetails(UserModel userModel) {
//        email = userModel.getContact().getEmail();
//        password = userModel.getPassword();
//        role = userModel.getRole();
////        authorities = Arrays.stream(new String[]{userModel.getRole()})
////                        .map(SimpleGrantedAuthority::new)
////                        .collect(Collectors.toList());
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//          return List.of(new SimpleGrantedAuthority("ROLE_" + role));
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
