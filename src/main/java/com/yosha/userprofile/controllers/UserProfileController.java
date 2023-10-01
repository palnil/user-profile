package com.yosha.userprofile.controllers;

import com.yosha.userprofile.pojos.User;
import com.yosha.userprofile.services.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

@RestController
@RequestMapping("/userprofile")
@Slf4j
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/submit")
    ResponseEntity<String> saveUserProfile(@RequestBody User user) {

        if(user.getAge() < 18){

            return new ResponseEntity<>("Minor User", HttpStatus.BAD_REQUEST);
        }

       Long id = userProfileService.createUserProfile(user);
       return new ResponseEntity<>("User Created " + id, HttpStatus.OK);
      //  return new ResponseEntity<>("Error while creating user", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/user")
    ResponseEntity<User> getUser(@RequestParam int id) {
        User user = new User();
        try {
             user = userProfileService.getUser(id);
        }catch (HttpServerErrorException e) {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}
