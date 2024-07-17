package com.scm.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Entity(name = "user")
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
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


   //SELF, GOOGLE, FACEBOOK, TWITTER, LINKEDIN, GITHUB
   private Providers provider=Providers.SELF;
   private String providerId;

   @OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
   private List<Contact> contacts = new ArrayList<Contact>();

   
}
