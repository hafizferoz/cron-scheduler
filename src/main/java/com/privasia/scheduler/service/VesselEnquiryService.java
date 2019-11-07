package com.privasia.scheduler.service;

import com.privasia.scheduler.model.ContainerVisit;

/**
 * @author Hafiz Feroz
 *
 */
public interface VesselEnquiryService { 
	/**
	 * @param scn
	 * @return
	 * @throws Exception
	 */
	ContainerVisit getVesselSatusByScn(String scn) throws Exception;

	String findContainerVisitStatusByScn(String scn) throws Exception;

}
