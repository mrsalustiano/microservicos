package com.mrsalustiano.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrsalustiano.hrpayroll.entities.Payment;
import com.mrsalustiano.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResources {

	@Autowired
	private PaymentService services;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{workedId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workedId, @PathVariable Integer days ){
		
		Payment payment = services.getPayment(workedId, days);
		return ResponseEntity.ok(payment);
		
	}
	
	
	public ResponseEntity<Payment> getPaymentAlternative(Long workedId, Integer days ){
		Payment payment = new Payment("Joao", 400.0, days);
		return ResponseEntity.ok(payment);
	}
}
