package com.example.javaweb.service;

import com.example.javaweb.model.im_User;

import java.util.List;

public interface IUserReponsitory {
    List<im_User> GetAll();
    void addUser(im_User user);
    void register(String user,String pass,String email);
    void updateUser(im_User user);
    im_User findByName(String key);
    im_User checkUser(String username,String password);
    im_User FindById(String id);
}
