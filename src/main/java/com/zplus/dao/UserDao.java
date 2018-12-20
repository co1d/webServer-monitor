package com.zplus.dao;

import com.zplus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long>
{
}
