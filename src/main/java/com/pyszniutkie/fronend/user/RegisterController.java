package com.pyszniutkie.fronend.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;

@Controller
public class RegisterController {

    private UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterForm() {
        return "register-form";
    }

    @PostMapping("/register/new-user")
    public String newUser(String mail, String password) {
        try {
            userService.addUser(mail, password);
        }catch (HttpClientErrorException e){
            System.out.println(e.getMessage());
            return "register-fail";
        }
        return "register-success";
    }
}
