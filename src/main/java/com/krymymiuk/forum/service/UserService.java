package com.krymymiuk.forum.service;



import com.krymymiuk.forum.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService  extends UserDetailsService {
   void newUser(String username,  String password, String email);
   boolean activateUser(String code);
   User findByUsername(String username);}