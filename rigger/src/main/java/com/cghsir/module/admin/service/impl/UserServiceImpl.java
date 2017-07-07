package com.cghsir.module.admin.service.impl;

import com.cghsir.mapper.UserMapper;
import com.cghsir.model.User;
import com.cghsir.module.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cghsir on 2017/7/7.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 添加一个用户
     * @param user 用户对象
     * @return
     */
    @Override
    public boolean add(User user) {
        return userMapper.insert(user) > 0;
    }
}
