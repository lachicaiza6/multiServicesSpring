package com.escolastico.springboot.app.oauth.security.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.escolastico.springboot.app.oauth.services.IUserService;
import com.escolastico.springboot.app.user.commons.models.entity.User;

import brave.Tracer;
import feign.FeignException;

@Component
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher{
	private Logger log = LoggerFactory.getLogger(AuthenticationSuccessErrorHandler.class);

	@Autowired
	private IUserService usuarioService;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private Tracer tracer;

	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		if(authentication.getName().equalsIgnoreCase(env.getProperty("config.security.oauth.client.id"))){
            return; // si es igual a frontendapp se salen del método!
        }
		UserDetails user = (UserDetails) authentication.getPrincipal();
		String mensaje = "Success Login: " + user.getUsername();
		System.out.println(mensaje);
		log.info(mensaje);
		
		User usuario = usuarioService.findByUsername(authentication.getName());
		
		if(usuario.getAttempts() != null && usuario.getAttempts() > 0) {
			usuario.setAttempts(0);
			usuarioService.update(usuario, usuario.getId());
		}
	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		String mensaje = "Error en el Login: " + exception.getMessage();
		log.error(mensaje);
		System.out.println(mensaje);

		try {
			
			StringBuilder errors = new StringBuilder();
			errors.append(mensaje);
			
			User usuario = usuarioService.findByUsername(authentication.getName());
			if (usuario.getAttempts() == null) {
				usuario.setAttempts(0);;
			}
			
			log.info("Intentos actual es de: " + usuario.getAttempts());
			
			usuario.setAttempts(usuario.getAttempts()+1);
			
			log.info("Intentos después es de: " + usuario.getAttempts());
			
			errors.append(" - Intentos del login: " + usuario.getAttempts());
			
			if(usuario.getAttempts() >= 3) {
				String errorMaxIntentos = String.format("El usuario %s des-habilitado por máximos intentos.", usuario.getUsername());
				log.error(errorMaxIntentos);
				errors.append(" - " + errorMaxIntentos);
				usuario.setEnabled(false);
			}
			
			usuarioService.update(usuario, usuario.getId());
			
			tracer.currentSpan().tag("error.mensaje", errors.toString());
			
		} catch (FeignException e) {
			log.error(String.format("El usuario %s no existe en el sistema", authentication.getName()));
		}

	}

}
