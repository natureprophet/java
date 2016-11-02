package com.simon.data.security;

import com.simon.data.domain.User;
import com.simon.data.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    private Map<String, String> settings = new HashMap<>();

    @Override
    public UserDetails loadUserByUsername(String nickName) throws UsernameNotFoundException {
        User user = userRepository.findByNickname(nickName);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", nickName));
        } else if (user.getSettings() == null) {
            user.setSettings(settings);
            userRepository.save(user);
        }

        return new UserRepositoryUserDetails(user);
    }
}
