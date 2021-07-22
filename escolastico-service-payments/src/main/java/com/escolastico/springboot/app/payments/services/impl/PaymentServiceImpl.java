package com.escolastico.springboot.app.payments.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.escolastico.springboot.app.commons.models.entity.payment.Payment;
import com.escolastico.springboot.app.commons.services.CommonServiceImpl;
import com.escolastico.springboot.app.payments.models.dao.PaymentDao;
import com.escolastico.springboot.app.payments.services.interfaces.PaymentService;
@Service
public class PaymentServiceImpl extends CommonServiceImpl<Payment, PaymentDao> implements  PaymentService{

	@Override
	@Transactional(readOnly = true)
	public Iterable<Payment> findAllById(Iterable<Long> ids) {
		
		return repository.findAllById(ids);
	}


	
	
	
}
