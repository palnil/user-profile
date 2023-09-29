package com.yosha.userprofile.controllers;

import com.yosha.userprofile.pojos.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userprofile")
@Slf4j
public class UserProfileController {


    @PostMapping("/submit")
    ResponseEntity<String> saveUserProfile(@RequestBody User user) {

       log.info(user.getFirstName());
       return new ResponseEntity<>("User Created", HttpStatus.OK);
    }

    @GetMapping("/hi")
    ResponseEntity<String> hello(){
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

}
