package com.mrsalustiano.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsalustiano.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
	
	
	

}
