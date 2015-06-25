package com.imine.backend.model;

import com.imine.backend.dao.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by dev on 2015/6/25.
 */
public class User implements Serializable {
    public static final String TABLE_NAME = "USER";
    private long userId;
    private String username;
    private String password;
    private String email;
    private List<PersonInfo> personInfoList;

    @Id
    @Column(name = "USER_ID")
    @TableGenerator(name = TABLE_NAME)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = TABLE_NAME)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long id) {
        this.userId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @OrderBy(value = "personInfoUid")
    public List<PersonInfo> getPersonInfoList() {
        return personInfoList;
    }

    public void setPersonInfoList(List<PersonInfo> personInfoList) {
        this.personInfoList = personInfoList;
    }
}
