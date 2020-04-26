package com.natnasolutions.ticketing.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.natnasolutions.ticketing.model.TicketCategory;
import com.natnasolutions.ticketing.repository.TicketCategoryRepository;
import com.natnasolutions.ticketing.service.TicketCategoryService;

@Service
@Transactional
public class TicketCategoryServiceImpl implements TicketCategoryService {

	@Autowired
	private TicketCategoryRepository ticketCategoryRepository;

	public boolean addTicketCategory(TicketCategory ticketCategory) {
		return ticketCategoryRepository.save(ticketCategory) != null;
	}

	public List<TicketCategory> getAllTicketCategorys() {
		return ticketCategoryRepository.findAll();
	}

	@Override
	public boolean updateTicketCategory(TicketCategory ticketCategory) {
		return ticketCategoryRepository.save(ticketCategory) != null;
	}

}
