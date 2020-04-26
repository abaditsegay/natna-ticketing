package com.natnasolutions.ticketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natnasolutions.ticketing.model.Associate;
import com.natnasolutions.ticketing.service.AssociateService;
import com.natnasolutions.ticketing.util.EnConstants;
import com.natnasolutions.ticketing.util.ResponseDetails;

@RestController
public class AssociateController {

	@Autowired
	private AssociateService associateService;

	@GetMapping("/associate")
	public ResponseDetails getAllAssociates() {
		List<Associate> associateList = associateService.getAllAssociates();
		if (associateList.isEmpty()) {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE, associateList);
		}
	}

	@PostMapping("/associate")
	public ResponseDetails creatAssociate(Associate associate) {
		boolean response = associateService.addAssociate(associate);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}
	}

	@PutMapping(path = "/associate")
	public ResponseDetails updateAssociate(Associate associate) {
		boolean response = associateService.updateAssociate(associate);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}

	}

	@GetMapping("/associate/review/{id}")
	public ResponseDetails reviewAssociate(@PathVariable("id") Long id) {
		List<Associate> associateList = associateService.getAssociateById(id);
		if (associateList.isEmpty()) {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE, associateList);
		}

	}

	@PutMapping("/associate/approval/{id}")
	public ResponseDetails approveAssociate(@PathVariable("id") Long id) {
		boolean response = associateService.approveAssociateById(id);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}
	}

	@PutMapping("/associate/rejection/{id}")
	public ResponseDetails rejectAssociate(@PathVariable("id") Long id) {
		boolean response = associateService.rejectAssociateById(id);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}
	}

	@PutMapping("/associate/enable/{id}")
	public ResponseDetails enableAssociate(@PathVariable("id") Long id) {
		boolean response = associateService.enableAssociateById(id);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}
	}

	@PutMapping("/associate/disable/{id}")
	public ResponseDetails disableAssociate(@PathVariable("id") Long id) {
		boolean response = associateService.disableAssociateById(id);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}
	}

	@PutMapping("/associate/status/{status}")
	public ResponseDetails getAssociateByStatus(@PathVariable("status") String status) {
		List<Associate> associateList = associateService.getAssociateByStatus(status);
		if (associateList.isEmpty()) {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE, associateList);
		}
	}

	@PutMapping("/associate/approvals/{status}")
	public ResponseDetails getAssociateByApprovalStatus(@PathVariable("status") String status) {
		List<Associate> associateList = associateService.getAssociateByApprovalStatus(status);
		if (associateList.isEmpty()) {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE, associateList);
		}
	}

}
