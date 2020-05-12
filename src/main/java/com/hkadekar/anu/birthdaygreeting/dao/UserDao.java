package com.hkadekar.anu.birthdaygreeting.dao;

import com.hkadekar.anu.birthdaygreeting.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void saveAllUsers(List<User> users);
    void removeAllUsers();
    void saveUser(User user);
    User getUser(Long id);
    void removeUser(User user);
}
