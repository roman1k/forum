package com.krymymiuk.forum.service;


import com.krymymiuk.forum.dao.UserDAO;
import com.krymymiuk.forum.model.Role;
import com.krymymiuk.forum.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.UUID;

public interface UserService  extends UserDetailsService {
   void newUser(String username,  String password, String email);
   boolean activateUser(String code);
   User findByUsername(String username);}