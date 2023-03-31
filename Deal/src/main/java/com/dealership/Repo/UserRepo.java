package com.dealership.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dealership.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    
    @Query(value="select * from user where email = ?1 and password = ?2", nativeQuery = true)
    // This function MUST BE ABSTRACT, NO BRACKETS
    public User findByEmailAndPassword(String email, String password);
    
    @Query(value="select * from user where email = ?1", nativeQuery = true)
    public User findByEmail(String email);
}
