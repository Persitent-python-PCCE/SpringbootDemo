package com.revature.demoapp.service;

import com.revature.demoapp.models.User;
import com.revature.demoapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User registerUser(User user) {
        return repository.save(user);
    }

    public User loginUser(String username, String password) {
        Optional<User> optUser = repository.findByUsername(username);
        if (optUser.isPresent() && optUser.get().getPassword().equals(password)) {
            return optUser.get();
        }
        return null;
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User userDetails) {
        User user = repository.findById(id).orElse(null);
        if (user != null) {
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            user.setEmail(userDetails.getEmail());
            return repository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
