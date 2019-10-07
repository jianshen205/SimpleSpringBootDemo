package com.ccgg.SpringBootRestDemo.dao;

import com.ccgg.SpringBootRestDemo.beans.CcggUser;
import org.springframework.data.jpa.repository.JpaRepository;

//为什么这里是<CcggUser, Integer> , 对应ID
public interface UserDao extends JpaRepository<CcggUser, Integer> {
     CcggUser findByUsername(String username);

}
