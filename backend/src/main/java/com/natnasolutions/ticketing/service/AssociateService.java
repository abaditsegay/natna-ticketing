package com.natnasolutions.ticketing.service;

import java.util.List;
import java.util.Optional;

import com.natnasolutions.ticketing.model.Associate;

public interface AssociateService {

	public List<Associate> getAllAssociates();

	public boolean addAssociate(Associate associate);

	public boolean updateAssociate(Associate associate);

	public List<Associate> getAssociateById(Long id);

	public boolean approveAssociateById(Long id);

	public boolean rejectAssociateById(Long id);

	public boolean enableAssociateById(Long id);

	public boolean disableAssociateById(Long id);

	public List<Associate> getAssociateByStatus(String status);

	public List<Associate> getAssociateByApprovalStatus(String status);
}
