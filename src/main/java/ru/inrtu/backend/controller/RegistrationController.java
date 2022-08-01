package ru.inrtu.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.inrtu.backend.entity.authorization.User;
import ru.inrtu.backend.service.UserService;

@RestController
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<?> addUser(@RequestBody User user){
        if (userService.createUser(user)){
            return ResponseEntity.ok("User successfully created");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User with this username already exist");
        }
    }
}
