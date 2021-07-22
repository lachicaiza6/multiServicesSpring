package com.escolastico.springboot.app.commons.models.entity.person.relations;

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

import com.escolastico.springboot.app.commons.models.entity.person.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="student_enrollment")
public class StudentEnrollment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9147405425858293326L;

	@Id
	@Column(name="id_student_enrollment")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="id_enrollment")
	private Long idEnrollment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value= {"studentEnrollment"})
	@JoinColumn(name="fk_student", referencedColumnName="id_student")
	private Student student;

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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return false;
		}
		if(!(obj instanceof StudentEnrollment))
			return false;
		
		StudentEnrollment a=(StudentEnrollment) obj;
		return this.idEnrollment!=null && this.idEnrollment.equals(a.getIdEnrollment());
	}
	
	
}
