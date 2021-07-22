package com.escolastico.springboot.app.oauth.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.escolastico.springboot.app.oauth.services.IUserService;
import com.escolastico.springboot.app.user.commons.models.entity.User;

@Component
public class InfoAditionalToken implements TokenEnhancer{
	@Autowired
	private IUserService usuarioService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<String, Object>();
		
		User usuario = usuarioService.findByUsername(authentication.getName());
		info.put("id", usuario.getId());
		info.put("username", usuario.getUsername());
		info.put("email", usuario.getEmail());
		info.put("authorities", usuario.getRoles().toArray());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}
