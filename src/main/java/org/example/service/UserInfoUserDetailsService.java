//package org.example.service;
//
//import lombok.RequiredArgsConstructor;
//import org.example.data.model.UserModel;
//import org.example.data.repository.UserRepository;
//import org.example.utility.exception.ResourcesNotFoundException;
//import org.example.utility.mapper.UserInfoTOUserDetails;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserInfoUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    private static final Logger logger = LoggerFactory.getLogger(UserInfoUserDetailsService.class);
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        if (email == null || email.isEmpty()) {
//            throw new ResourcesNotFoundException("email cannot be null or empty");
//        }
//        try {
//            Optional<UserModel> userInfo = userRepository.findUserByContact_Email(email);
//            return userInfo.map(UserInfoTOUserDetails::new).orElseThrow(() -> new ResourcesNotFoundException("User not found " + userInfo));
//        }catch (Exception e){
//            logger.error("Error loading user by email: {}", email, e);
//            throw new ResourcesNotFoundException(email);
//
//
//        }
//    }
//}
