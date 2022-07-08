package com.system.online.inventory.management.system.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashPassword {

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pwd = "feytoto123";
        String pwdEncoder = passwordEncoder.encode(pwd);
        System.out.println(pwdEncoder);
    }
}
