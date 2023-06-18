package com.pyszniutkie.backend.user;

import org.springframework.stereotype.Service;

@Service
public class UserApiService {

    private UserRepository userApiRepository;
    private User loggedUser;

    public UserApiService(UserRepository userApiRepository) {
        this.userApiRepository = userApiRepository;
    }

    void add(User user){
        User search = userApiRepository.findByMail(user.getMail());
        if (search == null){//czy to jest wolne miejsce
            userApiRepository.save(user);
        }
        else //mail juz zajety, zglaszamy problem
        {
            throw new UserApiServiceException();
        }
//        System.out.println(user);
//        userApiRepository.save(user);
    }
    void login(User user){
        User search = userApiRepository.findByMail(user.getMail());
        if (search == null){
            throw new UserApiServiceException();
        }
        if (!search.getPassword().equals(user.getPassword())){
            throw new UserApiServiceException();
        }
        loggedUser = search;
    }
}
