package ru.appfree.springapp.service;

import ru.appfree.springapp.model.User;


public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
