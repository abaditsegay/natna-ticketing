package com.natnasolutions.ticketing.service;

import java.util.List;

import com.natnasolutions.ticketing.model.Associate;

public interface AssociateService {

	public Associate registerAssociate(Associate associate);
	public List<Associate> getAllAssociates();
	public Associate getAssociate(String businessName, String ownerName);
	public void approveAssociate(String businessName, String ownerName);
	public void rejectAssociate(String businessName, String ownerName);
	
	public void enableAssociate(String businessName, String ownerName);
	public void disableAssociate(String businessName, String ownerName);
}
