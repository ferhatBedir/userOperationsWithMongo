package com.ferhat.user.service;

import com.ferhat.user.entity.User;
import com.ferhat.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public User findByEmailAddress(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> findByEmailsAddress(String emails) {
		if (emails != null) {
			String[] emailList = emails.split(",");
			List<User> userList = new ArrayList<>();
			for (String email : emailList) {
				User user = userRepository.findByEmail(email);
				if (user != null) {
					userList.add(user);
				}

			}
			return userList;
		}
		return null;
	}

}
