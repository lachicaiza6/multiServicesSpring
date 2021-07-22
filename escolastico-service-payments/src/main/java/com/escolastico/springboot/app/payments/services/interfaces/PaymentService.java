package com.escolastico.springboot.app.payments.services.interfaces;

import com.escolastico.springboot.app.commons.models.entity.payment.Payment;
import com.escolastico.springboot.app.commons.services.CommonService;

public interface PaymentService extends CommonService<Payment> {

	//gets all the courses when you pass a list of id's 
		Iterable<Payment> findAllById(Iterable<Long> ids);
}
