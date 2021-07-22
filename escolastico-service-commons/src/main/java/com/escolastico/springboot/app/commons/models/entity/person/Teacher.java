package com.escolastico.springboot.app.commons.models.entity.person;

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


@Entity
@Table(name = "teachers")
public class Teacher extends Person implements Serializable{

	

	private static final long serialVersionUID = 6475432288005167352L;
	@Id
	@Column(name="id_teacher")
	//@Basic(optional=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@NotNull
	//@NotEmpty(message = "Ingrese el titulo")
	@Column(name="titulo")
	private String titulo;
	
	//@NotNull
	//@NotEmpty(message = "Ingrese el departamento")
	@Column(name="departament")
	private String depatament;
	
	//@NotNull
	//@NotEmpty(message = "Ingrese el tipo de jornada")
	@Column(name="tipo_jornada")
	private String tipoJornada;
	
	//@NotNull
	//@NotEmpty(message = "Ingrese las horas")
	@Column(name="horas")
	private Long horas;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_campus", referencedColumnName="id_campus")
	private Campus campus;

	public Teacher(Long id) {
		super();
		this.id = id;
	}

	public Teacher() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDepatament() {
		return depatament;
	}

	public void setDepatament(String depatament) {
		this.depatament = depatament;
	}

	public String getTipoJornada() {
		return tipoJornada;
	}

	public void setTipoJornada(String tipoJornada) {
		this.tipoJornada = tipoJornada;
	}

	public Long getHoras() {
		return horas;
	}

	public void setHoras(Long horas) {
		this.horas = horas;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	/*public List<UserTeacher> getUserTeacher() {
		return userTeacher;
	}

	public void setUserTeacher(List<UserTeacher> userTeacher) {
		this.userTeacher = userTeacher;
	}*/
	
	
	
}
