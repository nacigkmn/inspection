package com.example.inspection.service;

import com.example.inspection.entity.User;
import com.example.inspection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public User updateUser(int id, User user) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setUsername(user.getUsername());
                    existingUser.setPassword(user.getPassword());
                    existingUser.setRoles(user.getRoles());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
