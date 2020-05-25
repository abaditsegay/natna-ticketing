package com.natnasolutions.ticketing.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.natnasolutions.ticketing.model.TicketCategory;
import com.natnasolutions.ticketing.service.TicketCategoryService;
import com.natnasolutions.ticketing.util.EnConstants;
import com.natnasolutions.ticketing.util.ResponseDetails;

@RestController
public class TicketCategoryController {

	private static final Logger logger = LogManager.getLogger(TicketCategoryController.class);

	@Autowired
	private TicketCategoryService ticketCategoryService;

	@GetMapping(path = "/ticketcategory")
	public ResponseDetails getAllTicketCategorys() {
		List<TicketCategory> ticketCategoryList = ticketCategoryService.getAllTicketCategorys();
		if (ticketCategoryList.isEmpty()) {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE, ticketCategoryList);
		}

	}

	@PostMapping(path = "/ticketcategory")
	public ResponseDetails createTicketCategory(@RequestBody @Valid TicketCategory ticketCategory) {
		boolean response = ticketCategoryService.addTicketCategory(ticketCategory);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}

	}

	@PutMapping(path = "/ticketcategory")
	public ResponseDetails updateTicketCategory(@RequestBody TicketCategory ticketCategory) {
		boolean response = ticketCategoryService.updateTicketCategory(ticketCategory);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}

	}

}
