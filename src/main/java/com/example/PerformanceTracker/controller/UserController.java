/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.PerformanceTracker.controller;

import com.example.PerformanceTracker.database.model.SignInRequestUserDTO;
import com.example.PerformanceTracker.database.model.SignupResponseDTO;
import com.example.PerformanceTracker.database.model.User;
import com.example.PerformanceTracker.database.model.UserDTO;
import com.example.PerformanceTracker.exceptionHandler.InputNotValidException;
import com.example.PerformanceTracker.exceptionHandler.UserExistsException;
import com.example.PerformanceTracker.service.JwtUserDetailsService;
import com.example.PerformanceTracker.service.UserService;
import com.example.PerformanceTracker.util.JwtTokenUtil;
import com.example.PerformanceTracker.util.ObjectMapperUtil;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author iqbal
 */
@RestController
public class UserController extends ResponseEntityExceptionHandler{
    
    @Autowired
    UserService userService;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUserDetailsService userDetailsService;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @RequestMapping(method =RequestMethod.GET, value="/all")
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ObjectMapperUtil.mapAll(users, UserDTO.class);
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Object> saveUser(@Valid @RequestBody User user, BindingResult bindingResult) throws Exception, UserExistsException {
        if(bindingResult.hasErrors()) 
            throw new InputNotValidException(HttpStatus.BAD_REQUEST, bindingResult);
        return ResponseEntity.ok(userDetailsService.save(user));
    }
    
    
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<Object> createAuthenticationToken(@RequestBody SignInRequestUserDTO authenticationRequest) throws Exception {

            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

            final String token = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new SignupResponseDTO(token));
    }

    private void authenticate(String username, String password) throws Exception {
            try {
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            } catch (DisabledException e) {
                    throw new Exception("USER_DISABLED", e);
            } catch (BadCredentialsException e) {
                    throw new Exception("INVALID_CREDENTIALS", e);
            }
    }

}
