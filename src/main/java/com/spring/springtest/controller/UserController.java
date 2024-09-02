package com.spring.springtest.controller;

import com.spring.springtest.entity.UserEntity;
import com.spring.springtest.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/saveuser")
    public UserEntity insertUser(@RequestBody UserEntity user){

        return service.insertUser(user);
    }

    @RequestMapping(value = "/showuser",method = RequestMethod.GET)
    public List<UserEntity> showAllUser(){
        return service.showAllUsers();
    }

    @RequestMapping(value = "/showbyid/{id}",method = RequestMethod.GET)
    public Optional<UserEntity> showbyId(@PathVariable("id") String id){
        return service.showbyUserID(Integer.parseInt(id));
    }

    @PostMapping("/updateuser")
    public UserEntity updateUser(@RequestBody UserEntity user){

        return service.updateUser(user);
    }

    @PostMapping("/deleteuser/{id}")
    public UserEntity deleteUser(@PathVariable("id")String id){

        Optional<UserEntity> user = service.showbyUserID(Integer.parseInt(id));
        UserEntity obj = null; // dar myoe ko service mar pl yay
         if(user.isPresent()){
             obj = user.get();
             obj.setStatus(true);
         }
         return service.updateUser(obj);
    }

    @PutMapping("/deleteuserwith/{id}")
    public void deleteUser(@PathVariable("id")Integer id){
        service.deleteUser(id);
    }

    @GetMapping("/findbyemail/{email}")
    public UserEntity findByEmail(@PathVariable("email") String email){
        return service.findByEmail(email);
    }
}
