/**
 * TodoList java backend.
 * Part of the TodoList project.
 * Copyright (c) 2016 GlobalLogic
 * All rights reserved.
 * Distribution under license.
 */
package com.simon.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

@Data
public class Role implements GrantedAuthority {

    @NotEmpty
    private String name;

    @JsonIgnore
    private Set<User> users = new HashSet<>();

    @Override
    public String getAuthority() {
        return name;
    }
}
