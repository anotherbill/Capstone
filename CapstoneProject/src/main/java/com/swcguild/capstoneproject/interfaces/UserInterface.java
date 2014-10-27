/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.interfaces;

import com.swcguild.capstoneproject.model.User;

/**
 *
 * @author apprentice
 */
public interface UserInterface {
    
    public void addUser(User user);
    
    public void editUser(User user);
    
    public void deleteUser(User user);
    
    public User getUserByUserId(int userId);
    
    public void resetPassword(User user);
    
    public void changeUserPassword(User user, String password);
    
}
