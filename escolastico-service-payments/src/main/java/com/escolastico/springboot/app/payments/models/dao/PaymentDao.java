package com.escolastico.springboot.app.payments.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.escolastico.springboot.app.commons.models.entity.payment.Payment;

//@RepositoryRestResource(path="payment-repository")
public interface PaymentDao extends PagingAndSortingRepository<Payment, Long>{

}
