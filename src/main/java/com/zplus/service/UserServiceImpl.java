package com.zplus.service;

import com.zplus.entity.User;
import com.zplus.repository.UserMapper;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl
{
    @Resource
    private UserMapper userMapper;


    public User saveUser(User user) {
        userMapper.save(user);
        // 返回用户信息，带id
        return user;
    }

    /**
     * @CacheEvict 应用到删除数据的方法上，调用方法时会从缓存中删除对应key的数据
     *      condition 与unless相反，只有表达式为真才会执行。
     * @param id 主键id
     * @return
     */
    @CacheEvict(value = "user", key = "#root.args[0]", condition = "#result eq true")
    public Boolean removeUser(Long id) {
        // 如果删除记录不为1  则是失败
        return userMapper.deleteById(id) == 1;
    }

    /**
     *  @Cacheable 应用到读取数据的方法上，先从缓存中读取，如果没有再从DB获取数据，然后把数据添加到缓存中
     *            key 缓存在redis中的key
     *            unless 表示条件表达式成立的话不放入缓存
     * @param id 主键id
     * @return
     */
    @Cacheable(value = "user", key = "#root.args[0]", unless = "#result eq null ")
    public User getById(Long id) {
        return userMapper.selectById(id);
    }

    /**
     *  @CachePut 应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存
     * @param user 用户信息
     * @return
     */
    @CachePut(value = "user", key = "#root.args[0]", unless = "#user eq null ")
    public User updateUser(User user) {
        userMapper.update(user);
        return user;
    }
}
