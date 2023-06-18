package com.pyszniutkie.fronend.user;

import com.pyszniutkie.backend.user.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

//    private UserRepository userRepository;
    private UserClient userClient;

    public UserService(UserClient userClient) {
        this.userClient = userClient;
    }

    public void addUser(String mail, String password)
    {
        User user = new User(mail, password);
        userClient.saveUser(user);
    }
    public void loggin(String mail, String password){
        User user= new User(mail,password);
        userClient.login(user);
    }
}
