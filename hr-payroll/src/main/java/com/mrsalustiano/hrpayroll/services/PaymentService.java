package com.mrsalustiano.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.mrsalustiano.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(long workedId, int days) {
		
		return new Payment("BOB", 200.00, days);
	}

}
