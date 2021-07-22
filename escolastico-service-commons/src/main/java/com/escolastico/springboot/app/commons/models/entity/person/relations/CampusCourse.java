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

import com.escolastico.springboot.app.commons.models.entity.person.Campus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="campus_course")
public class CampusCourse implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	//@Basic(optional=true)
	private Long id;
	
	@Column(name="id_curse",unique=true)
	private Long idCourse;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_campus", referencedColumnName="id_campus")
	private Campus campus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public Long getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return false;
		if(!(obj instanceof CampusCourse))
		return false;
		CampusCourse a=(CampusCourse) obj;
			
		return this.getIdCourse()!=null && this.getIdCourse().equals(a.getIdCourse());
	}
	
	
	
}
