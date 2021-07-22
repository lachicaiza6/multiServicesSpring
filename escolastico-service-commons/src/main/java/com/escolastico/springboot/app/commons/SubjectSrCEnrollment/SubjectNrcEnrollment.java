package com.escolastico.springboot.app.commons.SubjectSrCEnrollment;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.escolastico.springboot.app.commons.models.entity.course.SubjectNrc;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="subjectnrc_enrollment")
public class SubjectNrcEnrollment implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6169332881033334440L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="id_enrolment",unique = true)
	private Long idEnrollment;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_sunjectnrc", referencedColumnName="id_subject_nrc")
	private SubjectNrc subjectNrc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdEnrollment() {
		return idEnrollment;
	}

	public void setIdEnrollment(Long idEnrollment) {
		this.idEnrollment = idEnrollment;
	}

	public SubjectNrc getSubjectNrc() {
		return subjectNrc;
	}

	public void setSubjectNrc(SubjectNrc subjectNrc) {
		this.subjectNrc = subjectNrc;
	}
	
	
	
	
}
