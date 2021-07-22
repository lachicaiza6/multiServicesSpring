package com.escolastico.springboot.app.oauth.services;

import com.escolastico.springboot.app.user.commons.models.entity.User;

public interface IUserService {
	public User findByUsername(String username);
	
	public User update(User user, Long id);
}
