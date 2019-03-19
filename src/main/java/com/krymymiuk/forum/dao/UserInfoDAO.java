package com.krymymiuk.forum.dao;

import com.krymymiuk.forum.model.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDAO extends JpaRepository<UserInfo, Integer> {
}
