package com.escolastico.springboot.app.commons.models.entity.payment;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment implements Serializable{

	
	
	private static final long serialVersionUID = -8971725602747473883L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_payment")
	private Long id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="number_payment")
	private String numberPayment;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="quantity", precision=4, scale=2)
	private float quantity;

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

	public String getNumberPayment() {
		return numberPayment;
	}

	public void setNumberPayment(String numberPayment) {
		this.numberPayment = numberPayment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
}
