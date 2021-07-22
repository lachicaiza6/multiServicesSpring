package com.escolastico.springboot.app.commons.models.entity.course;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.escolastico.springboot.app.commons.SubjectSrCEnrollment.SubjectNrcEnrollment;
import com.escolastico.springboot.app.commons.models.entity.enrollment.Enrollment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="subjectNrc")
public class SubjectNrc implements Serializable{

	
	private static final long serialVersionUID = 3896044886549563383L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_subject_nrc")
	private Long id;

	/*@NotNull
	@NotEmpty(message = "Ingrese el nrc")
	@Size(min=1,max=5, message="El nrc debe tener minimo 1 y maximo 5 caracteres")*/
	@Column(name="nrc")
	private String nrc;
	
	/*@NotNull
	@NotEmpty(message = "Ingrese el nrc")
	@Size(min=12,max=30, message="los cupos debe tener minimo 12 y maximo 30 cupos")*/
	@Column(name="quotas")
	private String quotas;
	
	/*@JsonIgnoreProperties(value= {"subjectNrcs"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="course_id")
	private Course course;*/

	@JsonIgnoreProperties(value= {"subjectNrcs"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="subject_id")
	private Subject subject;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "subjectNrc",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnoreProperties(value= {"subjectNrc"})
	private List<Schedule> schedules;
	
	@JsonIgnoreProperties(value={"subjectNrc","hibernateLazyInitializer","handler"},allowSetters = true)
	//@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "subjectNrc",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<SubjectNrcEnrollment> subjectNrcEnrollment;
	
	@Transient
	private List<Enrollment> enrollment;
	
	
	public SubjectNrc() {
		super();
		this.subjectNrcEnrollment=new ArrayList<>();
		this.enrollment=new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	public String getQuotas() {
		return quotas;
	}

	public void setQuotas(String quotas) {
		this.quotas = quotas;
	}

	/*public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}*/

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
	public List<SubjectNrcEnrollment> getSubjectNrcEnrollment() {
		return subjectNrcEnrollment;
	}

	public void setSubjectNrcEnrollment(List<SubjectNrcEnrollment> subjectNrcEnrollment) {
		this.subjectNrcEnrollment = subjectNrcEnrollment;
	}
	public void addSubjectNrcEnrollment(SubjectNrcEnrollment subjectNrcEnrollment) {
		this.subjectNrcEnrollment.add(subjectNrcEnrollment);
	}
	public void deleteSubjectNrcEnrollment(SubjectNrcEnrollment subjectNrcEnrollment) {
		this.subjectNrcEnrollment.remove(subjectNrcEnrollment);
	}
	
	
	public List<Enrollment> getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(List<Enrollment> enrollment) {
		this.enrollment = enrollment;
	}
	public void addEnrollment(Enrollment enrollment) {
		this.enrollment.add(enrollment);
	}
	public void removeEnrollment(Enrollment enrollment) {
		this.enrollment.remove(enrollment);
	}
	@Override
	public boolean equals(Object obj) {
		
		if(this.equals(obj))
			return true;
		if(!(obj instanceof SubjectNrc))
			return false;
		SubjectNrc a=(SubjectNrc) obj;
		
		return this.id!=null && this.id.equals(a.getId());
	}
	
	
	
	
}
