package com.escolastico.springboot.app.oauth.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.escolastico.springboot.app.oauth.clients.UserFeignClient;

import brave.Tracer;
import feign.FeignException;

@Service
public class UserService implements IUserService, UserDetailsService{

	private Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient client;
	
	@Autowired
	private Tracer tracer;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {
			com.escolastico.springboot.app.user.commons.models.entity.User usuario = client.findByUsername(username);

			List<GrantedAuthority> authorities = usuario.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role.getName()))
					.peek(authority -> log.info("Role: " + authority.getAuthority())).collect(Collectors.toList());

			log.info("Usuario autenticado: " + username);

			return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true,
					authorities);

		} catch (FeignException e) {
			String error = "Error en el login, no existe el usuario '" + username + "' en el sistema";
			log.error(error);
			
			tracer.currentSpan().tag("error.mensaje", error+": "+ e.getMessage());
			throw new UsernameNotFoundException(error);
		}
	}

	@Override
	public com.escolastico.springboot.app.user.commons.models.entity.User findByUsername(String username) {
		//System.out.print("-------------------------------------------------username: "+username);
		log.info("Usuario autenticado: " + username);
		return client.findByUsername(username);
	}

	@Override
	public com.escolastico.springboot.app.user.commons.models.entity.User update(
			com.escolastico.springboot.app.user.commons.models.entity.User user, Long id) {
		// TODO Auto-generated method stub
		return client.update(user, id);
	}


}
