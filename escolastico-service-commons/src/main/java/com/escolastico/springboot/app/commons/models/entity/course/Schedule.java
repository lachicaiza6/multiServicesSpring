package com.escolastico.springboot.app.commons.models.entity.course;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "schedules")
public class Schedule implements Serializable{

	private static final long serialVersionUID = -9186979587098747475L;
	@Id
	@Column(name="id_schedule")
	//@Basic(optional=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*@NotNull
	@NotEmpty(message = "Ingrese el dia")*/
	@Column(name="day")
	private String day;
	
	
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
	@JsonIgnoreProperties(value= {"schedules"})
	@JoinColumn(name="subjecNrc_id")
	private SubjectNrc subjectNrc;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "schedule",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnoreProperties(value= {"schadule"})
	private List<Mentoring> mentorings;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
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

	public SubjectNrc getSubjectNrc() {
		return subjectNrc;
	}

	public void setSubjectNrc(SubjectNrc subjectNrc) {
		this.subjectNrc = subjectNrc;
	}

	public List<Mentoring> getMentorings() {
		return mentorings;
	}

	public void setMentorings(List<Mentoring> mentorings) {
		this.mentorings = mentorings;
	}
	
	
}
