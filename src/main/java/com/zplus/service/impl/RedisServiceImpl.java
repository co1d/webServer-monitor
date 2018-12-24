package com.zplus.service.impl;

import com.zplus.controller.AsyncController;
import com.zplus.dao.PersonDao;
import com.zplus.dao.UserDao;
import com.zplus.entity.User;
import com.zplus.service.RedisService;
import com.zplus.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;

@Service
public class RedisServiceImpl implements RedisService
{
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private AsyncController asyncController;
    
    @Resource
    private PersonDao personDao;
    
    @Resource
    private UserDao userDao;
    
    @Resource
    private UserServiceImpl service;
    
    @Override
    public void save(Map<String, String> map)
    {
        for(Map.Entry<String,String> v:map.entrySet())
        {
            redisTemplate.opsForValue().set(v.getKey(),v.getValue());
        }
    }

    @Cacheable(value = "user", keyGenerator = "cacheKeyGenerator")
    public Optional<User> getById(Long id) {
        return userDao.findById(id);
    }
    
}