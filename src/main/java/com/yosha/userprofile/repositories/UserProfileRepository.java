package com.yosha.userprofile.repositories;

import com.yosha.userprofile.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends CrudRepository<UserEntity, Long> {
}