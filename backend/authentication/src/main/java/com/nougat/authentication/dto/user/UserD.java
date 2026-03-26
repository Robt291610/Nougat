package com.nougat.authentication.dto.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserD implements UserDetails {

    private String name;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public String getName(){ return name;};
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName(){ return lastName;};
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override public String getUsername() { return email; }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override public String getPassword() { return password; }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}
