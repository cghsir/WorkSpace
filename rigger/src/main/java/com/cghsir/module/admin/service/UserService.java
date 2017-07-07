package com.cghsir.module.admin.service;

import com.cghsir.model.User;

/**
 * 用户服务
 * Created by cghsir on 2017/7/7.
 */
public interface UserService {
    /**
     * 添加一个用户
     * @param user 用户对象
     * @return
     */
    public boolean add(User user);
}
