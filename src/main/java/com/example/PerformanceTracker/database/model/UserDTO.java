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
public class UserDTO {
    private String firstname;
    private String lastname;
    private String address;
    private String  username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
}
