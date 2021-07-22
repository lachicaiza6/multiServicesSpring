package com.escolastico.springboot.app.commons.models.entity.enrollment;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.FutureOrPresent;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "enrollment_schedules")
public class EnrollmentSchedule implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3903067263202478142L;

	@Id
	@Column(name="id_enrollment_schedulle")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="student_type")
	@NotEmpty(message = "Ingrese un tipo de estudiante")
	@NotNull
	@Size(min=1,max=10, message="El tipo de estudiante debe tener al menos 2 caracteres y máximo 10 caracteres")
	private String studentType;
	
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
	
	
	@Column(name="type")
	@NotEmpty(message = "Ingrese un tipo de horario de matrícula")
	@NotNull
	@Size(min=5,max=20, message="El tipo de horario de  matrícula debe tener al menos 5 caracteres y máximo 20 caracteres")
	private String Type;
	
	
	@JoinColumn(name="fk_period", referencedColumnName="id_period")
	@ManyToOne
	private Period period;


	
	
	public EnrollmentSchedule() {
		super();
	}


	public EnrollmentSchedule(Long id,
			@NotEmpty(message = "Ingrese un tipo de estudiante") @NotNull @Size(min = 1, max = 10, message = "El tipo de estudiante debe tener al menos 2 caracteres y máximo 10 caracteres") String studentType,
			@NotEmpty(message = "Ingrese la fecha de inicio") @FutureOrPresent(message = "No puede ser una fecha pasada") @NotNull Date startDate,
			@NotEmpty(message = "Ingrese la fecha de finalización") @FutureOrPresent(message = "No puede ser una fecha pasada") @NotNull Date endDate,
			@NotEmpty(message = "Ingrese un tipo de horario de matrícula") @NotNull @Size(min = 5, max = 20, message = "El tipo de horario de  matrícula debe tener al menos 5 caracteres y máximo 20 caracteres") String type,
			Period period) {
		super();
		this.id = id;
		this.studentType = studentType;
		this.startDate = startDate;
		this.endDate = endDate;
		Type = type;
		this.period = period;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStudentType() {
		return studentType;
	}


	public void setStudentType(String studentType) {
		this.studentType = studentType;
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


	public String getType() {
		return Type;
	}


	public void setType(String type) {
		Type = type;
	}


	public Period getPeriod() {
		return period;
	}


	public void setPeriod(Period period) {
		this.period = period;
	}
	
	
}
