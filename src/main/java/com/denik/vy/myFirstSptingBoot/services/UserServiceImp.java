package com.denik.vy.myFirstSptingBoot.services;

import com.denik.vy.myFirstSptingBoot.models.User;
import com.denik.vy.myFirstSptingBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> users() {
        return userRepository.findAll();
    }

    public User user(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void edit(int id, User user) {
        User u = userRepository.findById(id).orElse(null);
        if (u != null)
        {
            u.setName(user.getName());
            userRepository.save(u);
        }

    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
