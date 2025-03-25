package org.example.utility;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurePassword {

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public static String hashPassword(String Password){
        return passwordEncoder.encode(Password);
    }

    public static boolean matchPassword(String Password, String hashedPassword){
        return passwordEncoder.matches(Password, hashedPassword);
    }
}
