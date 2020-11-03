package com.mrsalustiano.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsalustiano.hrpayroll.entities.Payment;
import com.mrsalustiano.hrpayroll.entities.Worker;
import com.mrsalustiano.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(Long workedId, int days) {
		
		
		Worker worker = workerFeignClient.findById(workedId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome().doubleValue(), days);
	}

}
