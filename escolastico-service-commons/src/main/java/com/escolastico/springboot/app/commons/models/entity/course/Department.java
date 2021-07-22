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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "departments")
public class Department implements Serializable{
	
	
	private static final long serialVersionUID = 3132252112410919761L;
	@Id
	//@Basic(optional=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_department")
	private Long id;
	
	/*@NotNull
	@NotEmpty(message = "Ingrese el cargo")*/
	@Column(name="name")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "department",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnoreProperties(value= {"depatment"})
	private List<Career> careers;

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

	public List<Career> getCareers() {
		return careers;
	}

	public void setCareers(List<Career> careers) {
		this.careers = careers;
	}

	
	
}
