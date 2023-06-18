package com.pyszniutkie.backend.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    private UserApiService userApiService;

    public UserApiController(UserApiService userApiService) {
        this.userApiService = userApiService;
    }

    @PostMapping("/api/users")
    public ResponseEntity<User> addUser(@RequestBody User user){
        try {
            userApiService.add(user);
        }catch (UserApiServiceException e){
            return ResponseEntity.status(400).body(user);
        }
        return ResponseEntity.status(200).body(user);//Doczytac wzorzec builder
        //return ResponseEntity.status(200).body("Udalo sie zrobic");
    }
    @PostMapping("/api/users/login")
    public ResponseEntity<User> loginUser(@RequestBody User user){
        try {
            userApiService.login(user);
        }catch (UserApiServiceException e){
            return ResponseEntity.status(400).body(user);
        }
        return ResponseEntity.status(200).body(user);
    }
}
