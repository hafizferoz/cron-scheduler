package com.privasia.scheduler.service;

import java.util.List;

import com.privasia.scss.core.model.ExportsQ;

/**
 * @author Hafiz Feroz
 *
 */
public interface ExportsQService {
	
	
	List<ExportsQ> getAllExportsQ() throws Exception;

	void delete(ExportsQ exports) throws Exception;
	

}
