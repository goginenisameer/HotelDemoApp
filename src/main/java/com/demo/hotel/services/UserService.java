package com.demo.hotel.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.demo.hotel.entity.User;
import com.demo.hotel.temp.CurrentUser;

//Service Pattern for User
public interface UserService extends UserDetailsService {

	public User findUserByEmail(String email);

	public void saveUser(CurrentUser currentUser);

	public int getLoggedUserId();

	public User getLoggedUser();

}
