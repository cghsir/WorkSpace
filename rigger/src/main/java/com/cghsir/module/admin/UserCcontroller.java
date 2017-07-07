package com.cghsir.module.admin;

import com.cghsir.model.User;
import com.cghsir.module.admin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cghsir on 2017/7/7.
 */
@Api(value = "用户相关API")
@RestController()
@RequestMapping("/user")
public class UserCcontroller {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加用户", notes = "添加一个用户")
    @ApiImplicitParam(name = "user",value = "用户详细实体类",required = true,dataType = "User")
    @RequestMapping("/add")
    public String add(@RequestBody User user) {
        return "hello" + userService.add(user);
    }
}
