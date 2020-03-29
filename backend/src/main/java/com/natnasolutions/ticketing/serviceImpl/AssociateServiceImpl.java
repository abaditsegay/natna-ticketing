package com.natnasolutions.ticketing.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.natnasolutions.ticketing.model.Associate;
import com.natnasolutions.ticketing.repository.AssociateRepository;
import com.natnasolutions.ticketing.service.AssociateService;

@Service
@Transactional
public class AssociateServiceImpl implements AssociateService {

	@Autowired
	private AssociateRepository repository;

	@Override
	public Associate registerAssociate(Associate associate) {

		return repository.saveAndFlush(associate);
	}

	@Override
	public List<Associate> getAllAssociates() {

		return repository.findAll();
	}

	@Override
	public Associate getAssociate(String businessName, String ownerName) {

		return repository.getAssociate(businessName, ownerName);
	}

	@Override
	public void approveAssociate(String businessName, String ownerName) {

		repository.approveAssociate(businessName, ownerName);
	}

	@Override
	public void rejectAssociate(String businessName, String ownerName) {

		repository.rejectAssociate(businessName, ownerName);
	}

	@Override
	public void enableAssociate(String businessName, String ownerName) {

		repository.enableAssociate(businessName, ownerName);
	}

	@Override
	public void disableAssociate(String businessName, String ownerName) {

		repository.disableAssociate(businessName, ownerName);
	}

}
