package com.natnasolutions.ticketing.serviceImpl;

import java.util.List;
import java.util.Optional;

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
	private AssociateRepository associaterepository;

	@Override
	public List<Associate> getAllAssociates() {

		return associaterepository.findAll();
	}

	@Override
	public boolean addAssociate(Associate associate) {
		return associaterepository.save(associate) != null;
	}

	@Override
	public boolean updateAssociate(Associate associate) {
		return associaterepository.save(associate) != null;
	}

	@Override
	public List<Associate> getAssociateById(Long id) {
		return associaterepository.getAssociateByID(id);
	}

	@Override
	public boolean approveAssociateById(Long id) {
		int response = associaterepository.approveAssociate(id);
		if (response > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean rejectAssociateById(Long id) {
		int response = associaterepository.rejectAssociate(id);
		if (response > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean enableAssociateById(Long id) {
		int response = associaterepository.enableAssociate(id);
		if (response > 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean disableAssociateById(Long id) {
		int response = associaterepository.disableAssociate(id);
		if (response > 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<Associate> getAssociateByStatus(String status) {
		return associaterepository.getAssociateByStatus(status);
	}

	@Override
	public List<Associate> getAssociateByApprovalStatus(String status) {
		return associaterepository.getAssociateByApprovalStatus(status);
	}

}
