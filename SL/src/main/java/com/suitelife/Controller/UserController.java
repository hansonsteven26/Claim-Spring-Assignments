package com.suitelife.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.suitelife.Entity.User;
import com.suitelife.Service.UserService;

// Liason between the JSP and the Services
// When the user makes input on the browser, it will correspond to
// one of the functions in the Controller first. Get 404'd otherwise
// Then the controller will use services to get whatever data needed
// for the page, and return the correct JSP
@Controller
public class UserController {

    @Autowired
    UserService userService;

    // Get mappings are when you are going straight to a url
    // no form submission at all
    @GetMapping("/")
    // This function will run whenever someone goes to the / url (http://localhost:8080/)
    public String index(HttpSession session, Model model) {

        String email = (String) session.getAttribute("emailCookie");
        if (email != null) {
            
            User loggedInUser = userService.findUserByEmail(email);

            model.addAttribute("user", loggedInUser);
        }

        return "home";
    }

    @GetMapping("/sign-up")
    /* Whenever you are putting data on a page
    * (like adding an object to the jsp to show or update data)
    * you need a ModelAttribute */
    public String signUp(Model model) {

        /* We must set a model attribute on the page, so our form can have a 
        * blank object to construct with the form data */
        model.addAttribute("user", new User());

        return "signUp";
    }

    @GetMapping("/sign-in")
    public String signIn(Model model) {
        
        model.addAttribute("user", new User());

        return "signIn";
    }

    /* Logging out is simply stopping the user from accessing their data until
    */ 
    // they log in again. Remove the cookie, and redirect them
    @GetMapping("/logout")
    public String logOut(HttpSession session) {
        
        session.removeAttribute("emailCookie");

        return "redirect:";
    }

    /* Whenever you are submitting data, you need a postmapping
     * This will grab the modelAttribute you submitted so you
     * can now do whatever you need to do with it */
    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute("user") User user, Model model, HttpSession session) {
        
        User loggedInUser = userService.signUp(user);

        model.addAttribute("user", loggedInUser);
        session.setAttribute("emailCookie", loggedInUser.getEmail());

        return "redirect:";
    }

    @PostMapping("/sign-in")
    public String signIn(@ModelAttribute("user") User user, Model model, HttpSession session) {

        try {
            
            User loggedInUser = userService.signIn(user);

            session.setAttribute("emailCookie", loggedInUser.getEmail());

            model.addAttribute("user", loggedInUser); // allow to show person's data

            return "redirect:";

        } catch(Exception e) {

            return "signIn";
        }
    }
}