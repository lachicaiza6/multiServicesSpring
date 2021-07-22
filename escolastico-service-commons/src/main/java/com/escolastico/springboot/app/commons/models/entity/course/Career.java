package com.escolastico.springboot.app.commons.models.entity.course;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "careers")
public class Career implements Serializable {

	
	private static final long serialVersionUID = -2146818486662654529L;
	@Id
	//@Basic(optional=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_career")
	private Long id;
	
	/*@NotNull
	@NotEmpty(message = "Ingrese el nombre")*/
	@Column(name="name")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "career",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnoreProperties(value= {"career"})
	private List<Subject> subjects; 

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value= {"careers"})	
	@JoinColumn(name="career_id")
	private Department department;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
	
}
