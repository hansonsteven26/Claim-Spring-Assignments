package com.suitelife.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suitelife.Entity.User;
import com.suitelife.Repo.UserRepo;

/* 
 * The job of the service is to ALL OF YOUR CRUD JAVA LOGIC
 * FOR YOUR ENTITY THEY CONTROL
 * You use your repo in your service to actually make your DB changes
 * To use your repo here, you MUST AUTOWIRE IT
 */
@Service
public class UserService {

    // This will construct a bean in your file
    // this allows you to use the autowired class's function in this file
    // YOU ONLY AUTOWIRE THE REPO FOR YOUR OWN ENTITY
    // YOU SHOULD NOT AUTOWIRE ANY SERVICES IN YOU SERVICE
    @Autowired
    UserRepo userRepo;

    // CRUD LOGIC GOES BELOW!!!

    // CREATE

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
        userRepo.deleteById(id);
    }
    
}