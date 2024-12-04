package com.example.lombok.service.impl;

import com.example.lombok.models.User;
import com.example.lombok.repository.UserRepository;
import com.example.lombok.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void print() {
        System.out.println(userRepository.getAll().toString());
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
