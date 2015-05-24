package com.vm.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
 

import com.vm.model.User;
 
@Repository
public class UserDAOImpl implements UserDAO {
     
    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addUser(User p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Person saved successfully, Person Details="+p);
    }

    @Override
    public void updateUser(User p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Person updated successfully, Person Details="+p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> listUser() {
    	System.out.println("Hello coming to listUser....");
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        for(User p : userList){
            logger.info("Users List::"+p);
        }
        return userList;
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        User p = (User) session.load(User.class, new Integer(id));
        logger.info("Person loaded successfully, Person details="+p);
        return p;
    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User p = (User) session.load(User.class, new Integer(id));
        if(null != p){
            session.delete(p);
        }
        logger.info("Person deleted successfully, person details="+p);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public User loginUser(String userName, String password) {
    	
    	List<User> users = new ArrayList<User>();
        users = this.sessionFactory.getCurrentSession().createQuery("from User where user_name=? and password=?")
        		.setParameter(0, userName).setParameter(1, password).list();
        
        if(users.size() > 0) {
        	
        	logger.info("Person loggedin successfully.");
        	return users.get(0);
        }else {
        	
        	return null;
        }
    }
}