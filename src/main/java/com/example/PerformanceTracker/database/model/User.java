/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.PerformanceTracker.database.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author iqbal
 */
@Entity
@Table(name="user")
public class User implements Serializable {
    @Id
    private int id;
    @Column(name = "first_name")
    @NotBlank(message = "First name is required")
    private String firstname;
    @Column(name = "last_name")
    @NotBlank(message = "Last name is required")
    private String lastname;
    @NotBlank(message = "username name is required")
    private String username;
    @NotBlank(message = "Password cannot be blank")
    private String password;
    private String address;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
}
