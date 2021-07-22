package com.escolastico.springboot.app.commons.models.entity.person.relations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user_teacher")
public class UserTeacher {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="user_id",unique=true)
	private Long userId;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value= {"userTeacher"})
	@JoinColumn(name="teacher_id")
	private Teacher teacher;*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

/*	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
*/

	
	
	
}
