package com.ferhat.user.service;

import com.ferhat.user.entity.User;

import java.util.List;

public interface UserService {

	void createUser(List<User> userList);

	List<User> findAllUsers();

    User findByEmailAddress(String email);
}
