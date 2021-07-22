package com.escolastico.springboot.app.commons.models.entity.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import javax.persistence.CascadeType;

import com.escolastico.springboot.app.commons.PersonPayment.StudentPayment;
import com.escolastico.springboot.app.commons.models.entity.enrollment.Enrollment;
import com.escolastico.springboot.app.commons.models.entity.payment.Payment;
import com.escolastico.springboot.app.commons.models.entity.person.relations.StudentEnrollment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "students")
public class Student extends Person implements Serializable{


	private static final long serialVersionUID = 6743421530933136084L;
	@Id
	@Column(name="id_student")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*@NotNull
	@NotEmpty(message = "Seleccione el nivel")*/
	@Column(name="level")
	private String level;
	
	/*@NotNull
	@NotEmpty(message = "Seleccione el tipo")*/
	@Column(name="type")
	private String type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_campus", referencedColumnName="id_campus")
	private Campus campus;
	
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "student",cascade = CascadeType.ALL,orphanRemoval = true)
	//@JsonIgnore
	@JsonIgnoreProperties(value= {"student","hibernateLazyInitializer", "handler"},allowSetters = true)
	private List<StudentEnrollment> studentEnrollment;
	
	@Transient
	private List<Enrollment> enrollment;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "student",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnoreProperties(value= {"student"})
	private List<StudentPayment> studentPayment;
	
	@Transient
	private List<Payment> payment;
	
	public Student(Long id) {
		super();
		this.id = id;
		
		
	}

	public Student() {
		super();
		this.studentPayment= new ArrayList<>();
		this.payment=new ArrayList<>();
		this.studentEnrollment=new ArrayList<>();
		this.enrollment=new ArrayList<>();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}


	public List<StudentEnrollment> getStudentEnrollment() {
		return studentEnrollment;
	}

	public void setStudentEnrollment(List<StudentEnrollment> studentEnrollment) {
		this.studentEnrollment = studentEnrollment;
	}

	public List<Enrollment> getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(List<Enrollment> enrollment) {
		this.enrollment = enrollment;
	}
	
	
	//Personalisados
	public void addEnrollment(Enrollment e) {
		this.enrollment.add(e);
	}
	public void removeEnrollment(Enrollment e) {
		this.enrollment.remove(e);
	}
	
	
	public void addStudentEnrollment(StudentEnrollment courseStudent) {
		this.studentEnrollment.add(courseStudent);
	}
	
	public void removeStudentEnrollment(StudentEnrollment courseStudent) {
		this.studentEnrollment.remove(courseStudent);
	}

	public List<StudentPayment> getStudentPayment() {
		return studentPayment;
	}

	public void setStudentPayment(List<StudentPayment> studentPayment) {
		this.studentPayment = studentPayment;
	}
	public void addStudentPayment(StudentPayment studentPayment) {
		this.studentPayment.add(studentPayment);
	}
	public void removeStudentPayment(StudentPayment studentPayment) {
		this.studentPayment.add(studentPayment);
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}
	public void addPayment(Payment payment) {
		this.payment.add(payment);
	}
	public void removePayment(Payment payment) {
		this.payment.remove(payment);
	}
	
}
