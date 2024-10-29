package com.reviewer.mvc.model.service;

import org.springframework.stereotype.Service;

import com.reviewer.mvc.model.dao.UserDao;
import com.reviewer.mvc.model.dto.User;

@Service
public class UserServiceImpl implements UserService{

	private final UserDao userDao;
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public User selectByIdAndPass(String id, String pass) {
		return userDao.selectForLogin(id, pass);
	}

	@Override
	public User selectById(String id) {
		return userDao.selectById(id);
	}

	@Override
	public boolean signup(User signupUser) {
		if (userDao.selectForSignup(signupUser.getId()) == 0) {
			int result = userDao.insert(signupUser);
			if(result == 1) {
				return true;
			}
		} else {
			
		}
		return false;
	}

}
