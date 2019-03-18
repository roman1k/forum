package com.krymymiuk.forum.service.impl;

import com.krymymiuk.forum.dao.UserDAO;
import com.krymymiuk.forum.dao.UserInfoDAO;
import com.krymymiuk.forum.model.User;
import com.krymymiuk.forum.model.UserInfo;
import com.krymymiuk.forum.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    MailSender mailSender;

    private static Logger logger = LogManager.getLogger(UserServiceImpl.class);
    @Autowired
    UserDAO userDAO;
    @Autowired
    UserInfoDAO userInfoDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findByUsername(username);
    }

    private boolean isUserPresent(User user) {
        if (userDAO.findByUsername(user.getUsername()) == null) {
            return false;
        } else
            return true;
    }
    @Override
    public void newUser(String userName,  String password, String email) {
        User user = new User(userName, password);
        if (!isUserPresent(user)) {
            String encode = passwordEncoder.encode(user.getPassword());
            user.setPassword(encode);
            user.setActivationCode(UUID.randomUUID().toString());
            UserInfo userInfo = new UserInfo();
            userInfo.setEmail(email);
            user.setUserInfo(userInfo);
            userDAO.save(user);
            String message = String.format(
                    "Hello, %s! \n" +
                            " Please, visit next link: http://localhost:8080/activate/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );

            mailSender.send(userInfo.getEmail(), "Activation code", message);
        }
    }

    @Override
    public boolean activateUser(String code) {
        User user = userDAO.findByActivationCode(code);
        if (user == null) {
            logger. error(user);
            return false;
        }
        user.setActivationCode(null);
        user.setEnabled(true);
        userDAO.save(user);
        return true;
    }
    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);

    }
}