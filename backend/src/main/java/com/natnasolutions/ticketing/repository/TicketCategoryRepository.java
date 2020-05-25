package com.natnasolutions.ticketing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natnasolutions.ticketing.model.TicketCategory;

@Repository
public interface TicketCategoryRepository extends JpaRepository<TicketCategory, Long> {

}
