package com.zplus.repository;

import com.zplus.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper
{
    
    int save(User user);
    
    int update(User user);
    
    int deleteById(Long id);
    
    User selectById(Long id);
    
    List<User> selectAll();
}
