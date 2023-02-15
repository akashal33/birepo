package com.akashk.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akashk.service.BenefitIssuanceService;

@RestController

public class BenefitIssuanceRest {
	
	@Autowired
	private BenefitIssuanceService benefitIssuanceService;

	@PostMapping("/generate")
	public ResponseEntity<String> generate(){
		
		benefitIssuanceService.generate();
		
		return ResponseEntity.ok("benefit issunace initiated");
	}
	
}
