package org.example.service;

import org.example.data.model.UserModel;
import org.example.data.repository.UserRepository;
import org.example.utility.exception.ResourcesNotFoundException;
import org.example.utility.mapper.UserInfoTOUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      Optional<UserModel> userInfo = userRepository.findUserByContact_Email(email);
       return  userInfo.map(UserInfoTOUserDetails::new).orElseThrow(() -> new ResourcesNotFoundException("User not found " + userInfo));
    }
}
