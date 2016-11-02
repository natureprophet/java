package com.simon.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
@Document
public class User {

    @Id
    private String id;

    private String password;

    private String nickname;

    private Set<Role> roles = new HashSet<>();

    private Map<String, String> settings;

    public User(User user) {
        super();
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.password = user.getPassword();
        this.roles = user.getRoles();
        this.settings = user.getSettings();
    }

    public User() {
    }
}
