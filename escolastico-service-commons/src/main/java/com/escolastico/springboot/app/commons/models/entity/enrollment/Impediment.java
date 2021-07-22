package com.escolastico.springboot.app.commons.models.entity.enrollment;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "impediments")
public class Impediment implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3720787811613802563L;
	
	@Id
	@Column(name="id_impediments")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="description")
	@NotEmpty(message = "Ingrese la descripción")
	@NotNull
	@Size(min=5,max=50, message="La descripción debe tener al menos 5 caracteres y máximo 50 caracteres")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
