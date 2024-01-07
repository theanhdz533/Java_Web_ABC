package com.dev.spring_web_music.services;

import com.dev.spring_web_music.model.Admin;
import com.dev.spring_web_music.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Admin login(String user, String pass) {
        return userRepository.findByUsernameAndPassword(user, pass);
    }
}
