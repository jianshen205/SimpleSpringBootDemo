package com.ccgg.SpringBootRestDemo.beans;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program:
 * @description:
 * @author: Jina
 * @date:2019-09-30 11:12
 **/

@Entity
@Table(name = "ccgg_user_profile")
public class UserProfile implements GrantedAuthority {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    @Column
    private String type;

    public UserProfile(){
        super();
    }


    public UserProfile(Integer id) {
        super();
        this.id = id;
    }

    public UserProfile(Integer id, String type) {
        super();
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getAuthority() {
        return type;
    }
}
