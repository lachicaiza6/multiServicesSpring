package com.escolastico.springboot.app.commons.models.entity.person;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class Person{
	
	/*@NotNull
	@Size(min=10,max=10, message="debe tener 10 caracteres")
	@NotEmpty(message = "Ingrese la cedula")*/
	@Column(name="target_id")
	private String targetId;
	
	/*@NotNull
	@Size(min=2,max=20, message="El nombre debe tener al menos 2 caracteres y máximo 20 caracteres")
	@NotEmpty(message = "Ingrese el nombre")*/
	@Column(name="name")
	private String name;
	
	/*@NotNull
	@Size(min=2,max=20, message="El apellido debe tener al menos 2 caracteres y máximo 20 caracteres")
	@NotEmpty(message = "Ingrese el apellido")*/
	@Column(name="last_name")
	private String lastName;
	
	/*@NotNull
	@Size(min=2,max=20, message="El numero telefonico debe tener 10 caracteres")
	@NotEmpty(message = "Ingrese el telefono")*/
	@Column(name="phone")
	private String phone;
	

	/*@NotNull
	@NotEmpty(message = "Ingrese el correo electrónico")*/
	@Column(name="email")
	private String email;
	
	/*@NotNull
	@NotEmpty(message = "Ingrese el sexo")*/
	@Column(name="sex")
	private String sex;
	
/*	@NotNull
	@NotEmpty(message = "Ingrese la dirección")*/
	@Column(name="residence")
	private String residence;
	

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}
	
	
}
