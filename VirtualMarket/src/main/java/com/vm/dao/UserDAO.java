package com.vm.dao;

import java.util.List;

import com.vm.model.User;
 
public interface UserDAO {
 
    public void addUser(User p);
    public void updateUser(User p);
    public List<User> listUser();
    public User getUserById(int id);
    public void removeUser(int id);
    public User loginUser(String userName, String password);
}