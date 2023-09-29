package com.yosha.userprofile.services;

import com.yosha.userprofile.entities.UserEntity;
import com.yosha.userprofile.pojos.User;
import com.yosha.userprofile.repositories.UserProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Optional;
import java.util.Random;

@Service
@Slf4j
public class UserProfileService {


    @Autowired
    private UserProfileRepository userProfileRepository;
    public Long createUserProfile(User user) {

        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPhoneNumber(user.getPhoneNumber());

        UserEntity entity = userProfileRepository.save(userEntity);

        return entity.getUserId();

    }


    public User getUser(int userId){
        User u = new User();
        Optional<UserEntity> user = userProfileRepository.findById(Long.valueOf(userId));
        UserEntity userEntity = user.orElse(null);
        if(userEntity == null) {
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
        }

        u.setFirstName(userEntity.getFirstName());
        u.setLastName(userEntity.getLastName());
        u.setEmail(userEntity.getEmail());
        u.setPhoneNumber(userEntity.getPhoneNumber());
       return u;
    }
}
