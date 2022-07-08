package com.system.online.inventory.management.system.security;

import com.system.online.inventory.management.system.model.Role;
import com.system.online.inventory.management.system.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class MyUserDetails implements UserDetails {

    private User user;

    public MyUserDetails(User user) {
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role: roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

//    redirect
    public boolean hasRole(String roleName) {
        return user.hasRole(roleName);
    }

    @Query("SELECT * FROM User")
    public Integer getUserInfo() {
        return user.getUserId();
    }

    //    display all user info
    public Integer getUserId() {
        return this.user.getUserId();
    }

    public String getFistName() {
        return this.user.getFistName();
    }

    public String getLastName() {
        return this.user.getLastName();
    }

    public String getAddress() {
        return this.user.getAddress();
    }

    public String getBirthDate() {
        return this.user.getBirthDate();
    }

    public String getGender() {
        return this.user.getGender();
    }

    public String getEmail() {
        return this.user.getEmail();
    }

    public String getNumber() {
        return this.user.getNumber();
    }

    public String getProfile() {
        return this.user.getProfile();
    }


}
