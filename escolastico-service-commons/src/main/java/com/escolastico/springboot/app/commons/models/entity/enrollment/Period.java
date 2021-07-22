package com.escolastico.springboot.app.commons.models.entity.enrollment;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "periods")
public class Period implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 624622394230792228L;
	
	@Id
	@Column(name="id_period")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	@NotEmpty(message = "Ingrese el nombre del periodo")
	@NotNull
	@Size(min=5,max=50, message="El nombre del periodo debe tener al menos 5 caracteres y máximo 50 caracteres")
	private String name;
	
	@Column(name="start_date")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotEmpty(message = "Ingrese la fecha de inicio")
	@FutureOrPresent(message= "No puede ser una fecha pasada")
	@NotNull
	private Date startDate;
	
	@Column(name="end_date")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotEmpty(message = "Ingrese la fecha de finalización")
	@FutureOrPresent(message= "No puede ser una fecha pasada")
	@NotNull
	private Date endDate;
	
	//**Cardinalidad uno a varios 	//mappedBy apunta al nombre del atributo en la clase shoppingCart
	@OneToMany(mappedBy="period", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<EnrollmentSchedule> enrollmentSchedulle;

	public Period() {
		super();
	}

	public Period(Long id) {
		super();
		this.id = id;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<EnrollmentSchedule> getEnrollmentSchedulle() {
		return enrollmentSchedulle;
	}

	public void setEnrollmentSchedulle(List<EnrollmentSchedule> enrollmentSchedulle) {
		this.enrollmentSchedulle = enrollmentSchedulle;
	}
	
	
	
	
}
