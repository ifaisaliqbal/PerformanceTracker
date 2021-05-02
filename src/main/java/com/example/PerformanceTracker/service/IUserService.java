/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.PerformanceTracker.service;

import com.example.PerformanceTracker.database.model.User;
import com.example.PerformanceTracker.exceptionHandler.UserExistsException;
import java.util.List;

/**
 *
 * @author iqbal
 */
public interface IUserService {
    abstract void signup (User user) throws UserExistsException;
    abstract List<User> getAllUsers();
}
