package com.ferhat.user.service;

import com.ferhat.user.entity.User;
import com.ferhat.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void createUser(List<User> userList) {
		userRepository.saveAll(userList);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

}
