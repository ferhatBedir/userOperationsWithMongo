package com.ferhat.user.controller;


import com.ferhat.user.entity.User;
import com.ferhat.user.model.LogModel;
import com.ferhat.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/user")
@Component
public class UserController {


	private UserService userService;
	public static final Logger log = LoggerFactory.getLogger(UserController.class);
	private LogModel Q1 = new LogModel();
	private LogModel Q2 = new LogModel();
	private LogModel Q3 = new LogModel();


	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/create")
	public void createUsers(@RequestBody @Valid List<User> userList,
	                        BindingResult bindingResult,
	                        HttpServletResponse httpServletResponse) throws IOException {
		if (bindingResult.hasErrors()) {
			httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameters invalid..");
		} else {
			userService.createUser(userList);
		}
	}

	@GetMapping("/allUsers")
	public List<User> findAllUsers_Q1() {
		Q1.setRequestType("GetMapping");
		Q1.setRequestCount(Q1.getRequestCount() + 1);
		return userService.findAllUsers();
	}

	@PostMapping("/email")
	public User findByUserEmail_Q2(@RequestParam(value = "email") String email) {
		Q2.setRequestType("PostMapping");
		Q2.setRequestCount(Q2.getRequestCount() + 1);
		User user = null;
		try {
			user = userService.findByEmailAddress(email);
			if (user == null) {
				throw new Exception("Sisteme kayıtlı email adresi bulunamadı.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return user;
	}

	@PostMapping("/emails")
	public List<User> findByUserEmail_Q3(@RequestParam(value = "emails") String emails) {
		Q3.setRequestType("PostMapping");
		Q3.setRequestCount(Q3.getRequestCount() + 1);
		List<User> userList = new ArrayList<>();
		try {
			userList = userService.findByEmailsAddress(emails);
			if (userList == null || userList.isEmpty()) {
				throw new Exception("Sisteme kayıtlı email adresi bulunamadı.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return userList;
	}

	@Scheduled(fixedRate = 10000)
	private void log() {
		log.info("Q1 Methoduna "+ Q1.getRequestType()+" tipinde 10sn içerisinde toplam "+Q1.getRequestCount()+" adet istek yapılmıştır.");
		log.info("Q2 Methoduna "+ Q2.getRequestType()+" tipinde 10sn içerisinde toplam "+Q2.getRequestCount()+" adet istek yapılmıştır.");
		log.info("Q3 Methoduna "+ Q3.getRequestType()+" tipinde 10sn içerisinde toplam "+Q3.getRequestCount()+" adet istek yapılmıştır.");

		Q1.setRequestType("");
		Q1.setRequestCount(0);
		Q2.setRequestType("");
		Q2.setRequestCount(0);
		Q3.setRequestType("");
		Q3.setRequestCount(0);
	}
}
