package com.krymymiuk.forum.dao;

import com.krymymiuk.forum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User, String> {
    User findByUsername(String username);
    User findByActivationCode(String activationCode);
    List<User> findUsersBy();
}
