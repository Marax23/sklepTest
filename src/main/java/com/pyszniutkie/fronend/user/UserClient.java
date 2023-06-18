package com.pyszniutkie.fronend.user;

import com.pyszniutkie.backend.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {

    private RestTemplate restTemplate;

    public UserClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void saveUser(User user) {
        ResponseEntity<User> response = restTemplate.postForEntity("http://localhost:8080/api/users", user, User.class);
    }

    public void login(User user){
        ResponseEntity<User> response = restTemplate.postForEntity("http://localhost:8080/api/users/login",user, User.class);
    }
}
