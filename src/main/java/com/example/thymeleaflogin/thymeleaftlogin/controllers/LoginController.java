package com.example.thymeleaflogin.thymeleaftlogin.controllers;

import com.example.thymeleaflogin.thymeleaftlogin.model.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

        //Get login form page
        @RequestMapping(value ="/login", method = RequestMethod.GET)
        public String getLoginForm(){
            //return html page name
            return "login";
        }

        //checking login creds
        @RequestMapping(value="/login", method =RequestMethod.POST)
        public String login(@ModelAttribute(name = "loginForm")LoginForm loginForm, Model model) {
            String userName = loginForm.getUserName();
            String password = loginForm.getPassword();
            if("admin".equals(userName) && "admin".equals(password)) {
                //if userName and pass are correct we return to home page
                return "home";
            }
            //If username or pass are wrong
            model.addAttribute("invalidCredentials", true);
            //return again login page
            return "login";
        }



}
