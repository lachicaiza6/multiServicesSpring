package com.escolastico.springboot.app.commons.models.entity.course;

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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="courses")
public class Course implements Serializable{
	

	private static final long serialVersionUID = 1747292766655104400L;
	@Id
	//@Basic(optional=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_course")
	private Long id;
	
	/*@NotNull
	@NotEmpty(message = "Ingrese el codigo de materia")
	@Size(min=3,max=10, message="El codigo debe tener minimo 3 y maximo 10  caracteres")*/
	@Column(name="name")
	private String name;
	
	/*@NotNull
	@NotEmpty(message = "Ingrese el codigo de materia")
	@Size(min=3,max=10, message="El codigo debe tener minimo 3 y maximo 10  caracteres")*/
	@Column(name="parallel")
	private String parallel;
	
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "course",cascade=CascadeType.ALL,orphanRemoval = true)
	//@JsonIgnoreProperties(value= {"course"})
	@OneToMany(fetch = FetchType.LAZY)
	private List<SubjectNrc> subjectNrcs;

	
	
	public Course() {
		this.subjectNrcs=new ArrayList<>();
	}

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

	public String getParallel() {
		return parallel;
	}

	public void setParallel(String parallel) {
		this.parallel = parallel;
	}

	public List<SubjectNrc> getSubjectNrcs() {
		return subjectNrcs;
	}

	public void setSubjectNrcs(List<SubjectNrc> subjectNrcs) {
		this.subjectNrcs = subjectNrcs;
	}
	public void addSubjectNrcs(SubjectNrc subjectNrc) {
		this.subjectNrcs.add(subjectNrc);
	}
	public void removeSubjectNrcs(SubjectNrc subjectNrc) {
		this.subjectNrcs.remove(subjectNrc);
	}
	
	
}
