package com.suitelife.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.suitelife.Entity.Place;
import com.suitelife.Entity.User;
import com.suitelife.Service.UserService;

import com.suitelife.Service.PlaceService;

@Controller
public class AdminController {

    @Autowired
    UserService userService;
    @Autowired
    PlaceService placeService;

    @GetMapping("/admin-tool")
    public String adminToolHome(Model model, HttpSession session) {
        String email = (String) session.getAttribute("emailCookie");
        if (email != null) {

            User loggedInUser = userService.findUserByEmail(email);
            model.addAttribute("user", loggedInUser);
            if (loggedInUser.getIsAdmin() != true) {
                return "redirect:";
            }
            return "adminTools";
        }
        return "redirect:";
    }

    @GetMapping("/adminPlace")
    public String adminPlace(Model model, HttpSession session) {
        String email = (String) session.getAttribute("emailCookie");
        if (email != null) {

            User loggedInUser = userService.findUserByEmail(email);
            model.addAttribute("user", loggedInUser);
            if (loggedInUser.getIsAdmin() != true) {
                return "redirect:";
            }
            // Model attribute for my form
            model.addAttribute("place", new Place());
            // Get list of places from database
            List<Place> allPlaces = placeService.findAll();
            model.addAttribute("allPlaces", allPlaces);
            return "adminPlace";
        }
        return "redirect:";
    }

    @PostMapping("/adminPlace")
    public String adminPlace(@ModelAttribute Place place) {

        placeService.save(place);

        return "redirect:adminPlace";
    }
}