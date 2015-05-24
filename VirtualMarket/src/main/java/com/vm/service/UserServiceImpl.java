package com.vm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.vm.dao.UserDAO;
import com.vm.model.User;
 
@Service
public class UserServiceImpl implements UserService {
     
    private UserDAO userDAO;
 
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
 
    @Override
    @Transactional
    public void addUser(User p) {
        this.userDAO.addUser(p);
    }
 
    @Override
    @Transactional
    public void updateUser(User p) {
        this.userDAO.updateUser(p);
    }
 
    @Override
    @Transactional
    public List<User> listUser() {
        return this.userDAO.listUser();
    }
 
    @Override
    @Transactional
    public User getUserById(int id) {
        return this.userDAO.getUserById(id);
    }
 
    @Override
    @Transactional
    public void removeUser(int id) {
        this.userDAO.removeUser(id);
    }
 
    @Override
    @Transactional
    public User loginUser(String userName, String password) {
    	
        return this.userDAO.loginUser(userName, password);
    }
}