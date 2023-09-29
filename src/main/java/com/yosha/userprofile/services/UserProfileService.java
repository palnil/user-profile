package com.yosha.userprofile.services;

import com.yosha.userprofile.pojos.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class UserProfileService {

    public int createUserProfile(User user) {

        int id = new Random().nextInt(999999);
        log.info("User created - " + user.getFirstName() + " " + user.getLastName() + " and ID is " + id);
        return id;
    }
}
