package com.brightkut.other.json;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<User> getUserWithJsonIgnore(){
        return ResponseEntity.ok(userService.getUserWithJsonIgnore());
    }

    @GetMapping("/userDetails")
    public ResponseEntity<UserDetail> getUserDetailWithJsonIgnorePropertiesMultipleField(){
        return ResponseEntity.ok(userService.getUserDetailWithJsonIgnorePropertiesMultipleField());
    }

    @GetMapping("/userDetails-2/{email}")
    public ResponseEntity<UserDetail2> getUserDetail2(@PathVariable String email){
        return ResponseEntity.ok(userService.getUserDetail2(email));
    }
}
