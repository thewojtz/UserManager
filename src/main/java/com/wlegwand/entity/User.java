package com.wlegwand.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity //zrobic package user i usergroup
@Table(name="user")
public class User {


    @Id
    @Column(name = "iduser")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer iduser;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "username")
    private String userName;
    @Column(name = "usersurname")
    private String userSurname;
    @Column(name = "dob")
    private String dob;



    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "userusergrouprelation",
            joinColumns = { @JoinColumn(name = "iduser") },
            inverseJoinColumns = { @JoinColumn(name = "iduseruroup") })
    private List <UserGroup> usergroup = new ArrayList<UserGroup>();


    public User() {

    }

    public Integer getId() {
        return iduser;
    }

    public void setId(Integer id) {
        this.iduser = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<UserGroup> getUserGroupList() {
        return usergroup;
    }

    public void setUserGroupList(List<UserGroup> userGroupList) {
        this.usergroup = userGroupList;
    }
}
