package com.hesmar.app.service;

import com.hesmar.app.domain.User;
import com.hesmar.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void add(User user) {
        userRepository.save(user);
    }

    public void update(User user) {
        User savedUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new RuntimeException("Cannot find User by id " + user.getId())
        );

        savedUser.setFirstName(user.getFirstName());
        savedUser.setLastName(user.getLastName());
        savedUser.setEmail(user.getEmail());
        savedUser.setPassword(user.getPassword());

        userRepository.save(savedUser);
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find User by id " + id));
    }
}