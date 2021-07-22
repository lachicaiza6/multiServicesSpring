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
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.escolastico.springboot.app.commons.models.entity.course.Course;
import com.escolastico.springboot.app.commons.models.entity.person.relations.CampusCourse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "campus")
public class Campus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4146340851746169896L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Basic(optional=true)
	@Column(name="id_campus")
	private Long id;
	
	/*@NotNull
	@NotEmpty(message = "Ingrese el nombre")*/
	@Column(name="name")
	private String name;
	
	/*@NotNull
	@NotEmpty(message = "Ingrese la dirección")*/
	@Column(name="address")
	private String address;
	
	/*@NotNull
	@NotEmpty(message = "Ingrese la ciudad")*/
	@Column(name="city")
	private String city;
	
	/*@NotNull
	@NotEmpty(message = "Ingrese la provincia")*/
	@Column(name="province")
	private String province;
	
	@OneToMany(mappedBy = "campus", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Student> students;
	
	
	@OneToMany(mappedBy = "campus", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Teacher> teachers;
	
	@JsonIgnoreProperties(value={"campus","hibernateLazyInitializer","handler"},allowSetters = true)
	//@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "campus",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<CampusCourse> campusCourse;
	
	@Transient
	private List<Course> course;
	
	public Campus() {
		super();
		this.course=new ArrayList<>();
		this.campusCourse=new ArrayList<>();
		this.teachers=new ArrayList<>();
		this.students=new ArrayList<>();
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public void addStudents(Student students) {
		this.students.add(students);
	}
	public void removeStudents(Student students) {
		this.students.remove(students);
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
	
	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}
	public void addCourse(Course course) {
		this.course.add(course);
	}
	public void removeCourse(Course course) {
		this.course.remove(course);
	}


	public List<CampusCourse> getCampusCourse() {
		return campusCourse;
	}

	public void setCampusCourse(List<CampusCourse> campusCourse) {
		this.campusCourse = campusCourse;
	}
	public void addCampusCourse(CampusCourse campusCourse) {
		this.campusCourse.add(campusCourse);
	}
	public void removeCampusCourse(CampusCourse campusCourse) {
		this.campusCourse.remove(campusCourse);
	}
	
}
