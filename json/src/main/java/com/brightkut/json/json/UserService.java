package com.brightkut.json.json;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUserWithJsonIgnore(){
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");

        return user;
    }

    public UserDetail getUserDetailWithJsonIgnorePropertiesMultipleField(){
        UserDetail userDetail = new UserDetail();
        userDetail.setName("name");
        userDetail.setSurname("surname");
        userDetail.setEmail("test@g.com");

        return userDetail;
    }

    public UserDetail2 getUserDetail2(String email) {
        UserDetail2 userDetail = new UserDetail2();
        userDetail.setName("name");
        userDetail.setSurname("surname");
        if (!email.equals("no-email")){
            userDetail.setEmail(email);
        }
        return userDetail;
    }
}
