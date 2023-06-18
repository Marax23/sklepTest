package com.pyszniutkie.fronend.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;

@Controller
public class LoginController {

    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login-form";
    }

    @PostMapping("/login")
    public String handleLogin(String mail, String password) {
        try {
            userService.loggin(mail, password);
            return "login-success";
        }catch (HttpClientErrorException e){
            System.out.println("Zwrotka na strone z błędem z powodu niepoprawnego logowania");
            return "login-fail";
        }

    }
}
