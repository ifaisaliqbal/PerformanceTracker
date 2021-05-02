/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.PerformanceTracker.service;

import com.example.PerformanceTracker.database.model.User;
import com.example.PerformanceTracker.database.model.UserDTO;
import com.example.PerformanceTracker.exceptionHandler.UserExistsException;
import com.example.PerformanceTracker.util.ObjectMapperUtil;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author iqbal
 */
@Component
public class JwtUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UserService userservice;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userservice.findByUsername(username);
        
        if(user == null) throw new UsernameNotFoundException(username);
        
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
    }
    
    public UserDTO save(User user) throws UserExistsException{
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userservice.save(user);
        UserDTO userDTO = new UserDTO();
        return ObjectMapperUtil.map(user, userDTO);
    }
    
}
