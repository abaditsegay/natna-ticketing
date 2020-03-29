package com.natnasolutions.ticketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natnasolutions.ticketing.model.Associate;
import com.natnasolutions.ticketing.service.AssociateService;

@RestController
public class AssociateController {
	
	@Autowired
	private AssociateService associateService;
	
	@PostMapping("/associate/register")
	public Associate registerAssociate(Associate associate) {
		return associateService.registerAssociate(associate);
	}
	
	@GetMapping("/associates")
	public ResponseEntity<List<Associate>> getAssociates(){
		List<Associate> associates = associateService.getAllAssociates(); 
		return new ResponseEntity<List<Associate>>(associates, HttpStatus.OK);
	}

	@GetMapping("/associates/{businessName}/{ownerName}")
	public ResponseEntity<Associate> reviewAssociate(@PathVariable("businessName") String businessName, @PathVariable("ownerName") String ownerName){
		Associate associate = associateService.getAssociate(businessName, ownerName);
		return new ResponseEntity<Associate>(associate, HttpStatus.OK);
	}
	
	@PutMapping("/associate/approval/{businessName}/{ownerName}")
	public void approveAssociate(@PathVariable("businessName") String businessName, @PathVariable("ownerName") String ownerName){
		associateService.approveAssociate(businessName, ownerName);
	}
	
	@PutMapping("/associate/rejection/{businessName}/{ownerName}")
	public void rejectAssociate(@PathVariable("businessName") String businessName, @PathVariable("ownerName") String ownerName){
		associateService.rejectAssociate(businessName, ownerName);
	}
	
	@PutMapping("/associate/enable/{businessName}/{ownerName}")
	public void enableAssociate(@PathVariable("businessName") String businessName, @PathVariable("ownerName") String ownerName){
		associateService.enableAssociate(businessName, ownerName);
	}
	
	@PutMapping("/associate/disable/{businessName}/{ownerName}")
	public void disableAssociate(@PathVariable("businessName") String businessName, @PathVariable("ownerName") String ownerName){
		associateService.disableAssociate(businessName, ownerName);
	}
	
}
