package com.escolastico.springboot.app.user.commons.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1285470789614025940L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_user")
	private Long id;

	//@Column(unique = true, length = 20)
	private String username;
	//@Column(length = 60)
	private String password;
	private Boolean enabled;
	//@Column(unique = true, length = 100)
	private String email;
	
	private Integer attempts;
	
	private Long idStudent;
	
	@ManyToMany(fetch= FetchType.LAZY)
	@JoinTable(name="users_rols", joinColumns= @JoinColumn (name= "id_user"), inverseJoinColumns = @JoinColumn(name="id_rol"),uniqueConstraints = {
				@UniqueConstraint(columnNames= {"id_user","id_rol"})})
	private List<Rol> roles;



	public Integer getAttempts() {
		return attempts;
	}

	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long idUser) {
		this.id = idUser;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public List<Rol> getRoles() {
		return roles;
	}

	public Long getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Long idStudent) {
		this.idStudent = idStudent;
	}


}
