package com.privasia.scheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.privasia.scheduler.model.ContainerVisit;
import com.privasia.scheduler.repo.cbas.ContainerVisitRepository;

/**
 * @author Hafiz Feroz
 *
 */
@Service
public class VesselEnquiryServiceImpl implements VesselEnquiryService {
	
	@Autowired
	private ContainerVisitRepository containerVisitRepository;

	@Override
	@Transactional(value = "cbasTransactionManager", propagation = Propagation.REQUIRED, readOnly = true)
	public ContainerVisit getVesselSatusByScn(String scn) throws Exception {
		return containerVisitRepository.getCotainerVisitByScn(scn);
	}
	
	@Override
	@Transactional(value = "cbasTransactionManager", propagation = Propagation.REQUIRED, readOnly = true)
	public String findContainerVisitStatusByScn(String scn) throws Exception{
		return containerVisitRepository.getContainerMarrineStatusByScn(scn);
		
	}
}
