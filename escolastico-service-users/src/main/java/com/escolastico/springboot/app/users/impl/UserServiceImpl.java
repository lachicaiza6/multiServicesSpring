package com.escolastico.springboot.app.users.impl;

import org.springframework.stereotype.Service;

import com.escolastico.springboot.app.commons.services.CommonServiceImpl;
import com.escolastico.springboot.app.user.commons.models.entity.User;
import com.escolastico.springboot.app.users.interfaces.UserService;
import com.escolastico.springboot.app.users.models.dao.UserDao;

@Service
public class UserServiceImpl extends CommonServiceImpl<User,UserDao> implements UserService {

}
