package com.ccgg.SpringBootRestDemo.controller;

import com.ccgg.SpringBootRestDemo.beans.CcggUser;
import com.ccgg.SpringBootRestDemo.http.Response;
import com.ccgg.SpringBootRestDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @program:
 * @description:
 * @author: Jina
 * @date:2019-10-01 10:33
 **/

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping
    public Response addUser(@RequestBody CcggUser user){
        return userService.register(user);
    }

    //权限管理
    //?? 这里是从jsessionid里面调取信息来验证吗?
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public Response deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }
}
