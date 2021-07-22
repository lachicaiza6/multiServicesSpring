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
@Table(name = "enrollments")
public class Enrollment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3581007878786241471L;
	@Id
	@Column(name="id_enrollment")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "evaluation", precision=4, scale=2)
	private float evaluation;
	
	@Column(name="type")
	/*@NotEmpty(message = "Ingrese el tipo de matricula")
	@NotNull
	@Size(min=5,max=50, message="El tipo de matricula debe tener al menos 5 caracteres y máximo 50 caracteres")*/
	private String type;
	
	//@Column(name = "price", precision=4, scale=2)
	//@NotNull
	private float price;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public float getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(float evaluation) {
		this.evaluation = evaluation;
	}
	
	

}
