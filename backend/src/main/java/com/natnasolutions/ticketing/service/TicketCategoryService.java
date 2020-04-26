package com.natnasolutions.ticketing.service;

import java.util.List;
import java.util.Optional;

import com.natnasolutions.ticketing.model.Role;
import com.natnasolutions.ticketing.model.TicketCategory;

public interface TicketCategoryService {

	public List<TicketCategory> getAllTicketCategorys();

	boolean addTicketCategory(TicketCategory ticketCategory);

	public boolean updateTicketCategory(TicketCategory ticketCategory);

	

}
