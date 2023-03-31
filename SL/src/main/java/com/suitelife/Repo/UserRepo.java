package com.suitelife.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.suitelife.Entity.User;

/* 
 * All repo's are interfaces, not classes
 * The job of the repo is to communicate CRUD wise w database
 * Create, Read, Update, Delete
 */
@Repository // Give JpaRepo the name of your class and DataType of primary key
public interface UserRepo extends JpaRepository<User, Integer> {

    /* @Query will allow you to make a query to the database for the abstract function
     * It will return data from the database to your service
     * Value is the select statement you make for your functionality
     * nativeQuery should always be true, allows you to write basic SQL */
    @Query(value="select * from user where email = ?1 and password = ?2", nativeQuery = true)
    // This function MUST BE ABSTRACT, NO BRACKETS
    public User findByEmailAndPassword(String email, String password);
    
    @Query(value="select * from user where email = ?1", nativeQuery = true)
    public User findByEmail(String email);    
}