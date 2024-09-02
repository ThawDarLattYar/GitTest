package com.spring.springtest.service;

import com.spring.springtest.entity.UserEntity;
import com.spring.springtest.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repo;
    public UserEntity insertUser(UserEntity user){
        return repo.save(user);
    }

    public List<UserEntity> showAllUsers(){
        return repo.showAllUsers();
    }

    public Optional<UserEntity> showbyUserID(Integer id){
        return repo.findById(id);
    }

    public UserEntity updateUser(UserEntity user){
        return repo.save(user);
    }
    public void deleteUser(Integer id){
        repo.deleteUser(id);
    };

    public UserEntity findByEmail(String email){
        return repo.findByEmail(email);
    }
}
