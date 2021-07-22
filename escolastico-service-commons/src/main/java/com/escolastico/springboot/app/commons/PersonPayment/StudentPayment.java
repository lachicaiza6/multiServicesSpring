package com.escolastico.springboot.app.commons.PersonPayment;

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

@Entity
@Table(name="student_payment")
public class StudentPayment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5053875729835416274L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="id_student", unique = true)
	private Long idPayment;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_student", referencedColumnName = "id_student")
	private Student student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Long getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(Long idPayment) {
		this.idPayment = idPayment;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	
}
