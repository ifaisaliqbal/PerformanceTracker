/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.PerformanceTracker.service;

import com.example.PerformanceTracker.database.model.User;
import com.example.PerformanceTracker.database.repository.UserRepository;
import com.example.PerformanceTracker.exceptionHandler.UserExistsException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author iqbal
 */
@Component
public class UserService implements IUserService  {
    @Autowired
    UserRepository repository;
    
    @Autowired
    BCryptPasswordEncoder pe;
    
    public void signup(User user)throws UserExistsException {
        if(repository.existsByUsername(user.getUsername())){
            throw new UserExistsException();
        }
        user.setPassword(pe.encode(user.getPassword()));
        repository.save(user);
    }
    
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }
    
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        repository.findAll().forEach(users::add); 
        return users;
    }
    
    public User save(User user) throws UserExistsException {
        if(doesExist(user.getUsername()))
            throw new UserExistsException();
        repository.save(user);
        return user;
    }
    
    private Boolean doesExist(String username) {
        if(repository.existsByUsername(username)) return true;
        else return false;
    }
}
