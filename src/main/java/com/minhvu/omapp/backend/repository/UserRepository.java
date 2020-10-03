package com.minhvu.omapp.backend.repository;

import com.minhvu.omapp.backend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByEmail(String email);
    Boolean existsUserByEmail(String email);
}
