package com.spring.springtest.repository;

import com.spring.springtest.entity.UserEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    @Query("select u from UserEntity u where u.status<>true")
    public List<UserEntity> showAllUsers();

    @Transactional
    @Modifying
    @Query("UPDATE UserEntity u set u.status=true WHERE u.id = :id")
    public void deleteUser(Integer id);

    public UserEntity findByEmail(String email);
}
