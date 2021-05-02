/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.PerformanceTracker.database.repository;

import com.example.PerformanceTracker.database.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author iqbal
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    Boolean existsByUsername(String username);
    User findByUsername(String username);
}