package com.scm.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity(name = "user")
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {
    @Id
   private String userId;
   @Column(name="user_name",nullable = false)
   private String name;
   @Column(nullable = false, unique = true)
   private String email;
   private String password;
   @Column(length = 1000)
   private String about;
   @Column(length = 1000)
   private String profilePic;
   private String phoneNumber;

   //information
   private boolean enabled=true;
   private boolean emailVerified=false;
   private boolean phoneVerified=false;


   @Enumerated(value = EnumType.STRING)
   //SELF, GOOGLE, FACEBOOK, TWITTER, LINKEDIN, GITHUB
   private Providers provider=Providers.SELF;
   private String providerId;

   @OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
   private List<Contact> contacts = new ArrayList<Contact>();

   @ElementCollection
   private List<String> roleList = new ArrayList<>();

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {

    // list of roles[USER,ADMIN]
        // Collection of SimpGrantedAuthority[roles{ADMIN,USER}]
       List<SimpleGrantedAuthority> roles = rollList.stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList());
    //return Collections.emptyList();
    return roles;
}

@Override
public String getUsername() {
    // yanha email hi hamara username hai
    return this.email;
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
    return this.enabled;
}

@Override
public String getPassword() {
    
    return this.password;
}

   
}
