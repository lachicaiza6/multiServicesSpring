package com.escolastico.springboot.app.commons.models.entity.course;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mentorings")
public class Mentoring implements Serializable{

	private static final long serialVersionUID = -9186979587098747475L;
	@Id
	@Column(name="id_mentoring")
	//@Basic(optional=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*@NotNull
	@NotEmpty(message = "ingrese el nombre")*/
	@Column(name="name")
	private String name;
	
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH-mm-ss")
	//@NotEmpty(message = "Ingrese la hora de inicio")
	@FutureOrPresent(message= "No puede ser una fecha pasado")
	//@NotNull
	@Column(name="start_time")
	private Date startTime;
	
	@Column(name="end_time")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH-mm-ss")
	//@NotEmpty(message = "Ingrese la hora de finalización")
	@FutureOrPresent(message= "No puede ser una fecha pasado")
	//@NotNull
	private Date endTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="schedule_id")
	@JsonIgnoreProperties(value= {"mentorings"})
	private Schedule schedule;
	
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
	
}
