package com.escolastico.springboot.app.commons.models.entity.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "administrative_positions")
public class AdministrativePosition implements Serializable {

	
	private static final long serialVersionUID = -2651272763576940406L;
	
	@Id
	@Column(name="id_administrative")
	//@Basic(optional=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*@NotNull
	@NotEmpty(message = "Ingrese el cargo")*/
	@Column(name="cargo")
	private String cargo;
	
	/*@NotNull
	@NotEmpty(message = "Ingrese el tipo")*/
	@Column(name="type")
	private String type;
	
	@JsonIgnoreProperties(value= {"campus"},allowSetters = true)
	@OneToMany(mappedBy = "campus",fetch = FetchType.LAZY,cascade =CascadeType.ALL,orphanRemoval = true )
	private List<Teacher> teachers;

	
	
	public AdministrativePosition() {
		//super();
		this.teachers=new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public void addTeachers(Teacher teachers) {
		this.teachers.add(teachers);
	}
	public void removeTeachers(Teacher teachers) {
		this.teachers.remove(teachers);
	}
	
	
}
