package com.reviewer.mvc.model.dao;

import com.reviewer.mvc.model.dto.User;

public interface UserDao {

	User selectForLogin(String id, String pass);

	int selectForSignup(String id);

	int insert(User signupUser);

	User selectById(String id);

}
