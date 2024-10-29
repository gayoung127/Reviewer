package com.reviewer.mvc.model.service;

import com.reviewer.mvc.model.dto.User;

public interface UserService {

	User selectByIdAndPass(String id, String pass);

	User selectById(String id);

	boolean signup(User signupUser);

}
