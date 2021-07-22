package com.escolastico.springboot.app.commons.models.entity.person.relations;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.escolastico.springboot.app.commons.models.entity.person.Student;

@Entity
@Table(name="student_user")
public class StudentUser implements Serializable {
	
	private static final long serialVersionUID = 2027317816516158342L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="id_user",unique = true)
	private Long idUser;
	
	
	private Student student;

}
