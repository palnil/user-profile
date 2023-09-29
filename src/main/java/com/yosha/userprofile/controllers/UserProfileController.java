package com.yosha.userprofile.controllers;

import com.yosha.userprofile.pojos.User;
import com.yosha.userprofile.services.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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

       int id = userProfileService.createUserProfile(user);
       return new ResponseEntity<>("User Created " + id, HttpStatus.OK);
    }

    @GetMapping("/hi")
    ResponseEntity<String> hello(){

        HttpHeaders httpHeaders =  new HttpHeaders();
        httpHeaders.add("Town", "Ashburn");

        return new ResponseEntity<String>("Hello", httpHeaders, HttpStatus.OK);
    }

}
