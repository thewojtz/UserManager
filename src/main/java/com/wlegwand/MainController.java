package com.wlegwand;

import com.wlegwand.entity.User;
import com.wlegwand.entity.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import com.wlegwand.repository.UserRepository;
import com.wlegwand.repository.UserGroupRepository;

import java.text.MessageFormat;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class MainController {

    private final UserRepository userRepository;

    private final UserGroupRepository userGroupRepository;

    @Autowired
    public MainController(UserRepository userRepository, UserGroupRepository userGroupRepository) {
        this.userRepository = userRepository;
        this.userGroupRepository = userGroupRepository;
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password,@RequestParam(value = "username") String userName, @RequestParam(value = "usersurname") String userSurname, @RequestParam(value = "dob") String dob) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setUserName(userName);
        user.setUserSurname(userSurname);
        user.setDob(dob);
        userRepository.save(user);
        return "User added";

    }


    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam(value = "id") Long id, @RequestParam(value = "name") String name, @RequestParam(value = "password") String password,@RequestParam(value = "username") String userName, @RequestParam(value = "usersurname") String userSurname, @RequestParam(value = "dob") String dob) {
      /*  User user = userRepository.findById(id).get();
        user.setName(name);
        user.setPassword(password);
        user.setUserName(userName);
        user.setUserSurname(userSurname);
        user.setDob(dob);
        userRepository.save(user);
        */
        return "User added";

    }

    @GetMapping("/getusers")
    public List<User> getUsers(){
        return (List<User>) userRepository.findAll();
    }

    @DeleteMapping("/removeuser")
    public void removeUser(@RequestParam(value = "id") Long id){
        userRepository.deleteById(id);
    }

    @RequestMapping("/addusergroup")
    public String addUserGroup(@RequestParam(value = "usergroupname") String userGroupName) {
        UserGroup userGroup = new UserGroup();
        userGroup.setUserGroupName(userGroupName);
        userGroupRepository.save(userGroup);
        return "User group added";
    }

    @RequestMapping("/updateusergroup")
    public String updateUserGroup(@RequestParam(value = "id") Long id, @RequestParam(value = "usergroupname") String userGroupName) {
        //UserGroup userGroup = new UserGroup();
       // userGroup.setUserGroupName(userGroupName);
       // userGroupRepository.save(userGroup);
        return "User group updated";
    }

    @GetMapping("/getusergroups")
    public List<UserGroup> getUserGroups(){
        return  (List<UserGroup>) userGroupRepository.findAll();
    }

    @DeleteMapping("/removeusergroup")
    public void removeUserGroup(@RequestParam(value = "id") Long id){
        userGroupRepository.deleteById(id);
    }

}