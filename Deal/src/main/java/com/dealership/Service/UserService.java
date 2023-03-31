package com.dealership.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealership.Entity.User;
import com.dealership.Repo.UserRepo;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    
    public User signUp(User user) {
        return userRepo.save(user);
    }

    // READ

    public User signIn(User user) throws Exception {
        User loggedInUser = userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if(loggedInUser == null) {
            throw new Exception("User not found. Try again, Billy");
        }
        return loggedInUser;
    }

    public User findUserById(Integer id) {
        // Find by id isn't perfect. Gotta do .get() on the end
        // to get your object off of the function
        return userRepo.findById(id).get();
    }

    public User findUserByEmail(String email) {

        return userRepo.findByEmail(email);
    }

    // UPDATE

    public User update(User user) throws Exception {

        if(user.getId() == null) {
            throw new Exception("Try again, Billy!");
        }
        return userRepo.save(user);
    }

    // DELETE

    public void deleteUserById(Integer id) {
        // Delete by id isn't perfect. Gotta do .get() on the end
        // to get your object off of the function
        userRepo.deleteById(id);
    }
}
