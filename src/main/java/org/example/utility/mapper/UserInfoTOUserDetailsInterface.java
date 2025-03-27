package org.example.utility.mapper;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public interface UserInfoTOUserDetailsInterface extends UserDetails{
    Collection<? extends GrantedAuthority> getAuthorities();

    String getPassword();

    String getEmail();

    boolean isAccountNonExpired();

    boolean isAccountNonLocked();

    boolean isCredentialsNonExpired();

    boolean isEnabled();
}
