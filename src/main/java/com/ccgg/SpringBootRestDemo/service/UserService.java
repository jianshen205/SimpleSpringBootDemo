package com.ccgg.SpringBootRestDemo.service;

import com.ccgg.SpringBootRestDemo.beans.CcggUser;
import com.ccgg.SpringBootRestDemo.beans.UserProfile;
import com.ccgg.SpringBootRestDemo.dao.UserDao;
import com.ccgg.SpringBootRestDemo.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: Jina
 * @date:2019-10-01 10:20
 **/

@Service
@Transactional
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Response register(CcggUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<UserProfile> profiles = new ArrayList<UserProfile>();
        profiles.add(new UserProfile(2)); //默认 user, not admin
        user.setProfiles(profiles);
        System.out.println(user);
        userDao.save(user);
        return new Response(true);
    }

    public Response deleteUser(Integer id) {

        if (userDao.findById(id) != null) {
            userDao.deleteById(id);
            return new Response(true);
        } else {
            return new Response(false, "User is not found!");
        }
    }
}
