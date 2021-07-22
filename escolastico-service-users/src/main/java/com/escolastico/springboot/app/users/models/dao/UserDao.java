package com.escolastico.springboot.app.users.models.dao;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.escolastico.springboot.app.user.commons.models.entity.User;


//@RepositoryRestResource(path="users")
public interface UserDao extends PagingAndSortingRepository<User, Long>{

	/*@RestResource(path="findByUsername")
//	@Query("select u from User u where u.username=?1")
	public User findByUsername(@Param("username") String username);
	
//	@RestResource(path="findByEmail")
	public User findByEmail(@Param("email") String email);
	*/
}
