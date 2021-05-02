/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.PerformanceTracker.database.model;

/**
 *
 * @author iqbal
 */
public class SignupResponseDTO {
    private String jwtToken;

    public SignupResponseDTO(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }
    
    
}
