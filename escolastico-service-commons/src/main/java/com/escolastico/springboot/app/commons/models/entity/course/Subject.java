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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "subjects")
public class Subject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5030505767463198899L;
	
	
	@Id
	@Column(name = "id_subject")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Basic(optional = false)
	private Long id;
	
	@Column(name = "name", length=50)
	private String name;
	
	
	/*@NotNull
	@NotEmpty(message = "Ingrese los creditos")*/
	@Column(name = "credits")
	//@Min(0)
	//@Max(8)
	private Long credits;
	
	/*@NotNull
	@NotEmpty(message = "Ingrese el codigo de materia")*/
	@Size(min=3,max=10, message="El codigo debe tener minimo 3 y maximo 10  caracteres")
	@Column(name = "unique_code")
	private String uniqueCode;
	
	/*@OneToMany(fetch = FetchType.LAZY,mappedBy = "subject",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnoreProperties(value="subject")*/
	@OneToMany(fetch = FetchType.LAZY)
	private List<SubjectNrc> subjectNrcs;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value="subjects")
	@JoinColumn(name="career_id")
	private Career career;
	
	
	
	public Subject() {
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
	

	public Long getCredits() {
		return credits;
	}
	public void setCredits(Long credits) {
		this.credits = credits;
	}
	public String getUniqueCode() {
		return uniqueCode;
	}
	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
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
	public void removeSubject(SubjectNrc subjectNrc) {
		this.subjectNrcs.remove(subjectNrc);
	}
	public Career getCareer() {
		return career;
	}
	public void setCareer(Career career) {
		this.career = career;
	}

	

}
