/**
 * TodoList java backend.
 * Part of the TodoList project.
 * Copyright (c) 2016 GlobalLogic
 * All rights reserved.
 * Distribution under license.
 */
package com.simon.data.service;

import com.simon.data.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(exported = false)
public interface UserRepository extends MongoRepository<User, String> {
    User findByNickname(String nickname);
}
