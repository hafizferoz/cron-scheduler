package com.privasia.scheduler.service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.privasia.scheduler.util.AppLogger;
import com.privasia.scheduler.util.DateUtil;
import com.privasia.scss.core.model.ExportsQ;

/**
 * @author Feroz Hafiz
 *
 */
@Service
public class DeleteExportQServiceImpl implements DeleteExportQService {
	
	private static final AppLogger log = AppLogger.getInstance();	
	@Autowired
	private ExportsQService exportsQService;

	@Autowired
	private VesselEnquiryService vesselEnquiryService;
	
	@Override
	public void exeucte() {
		try {
		log.info("ExportQList Processing started: " + DateUtil.getFormatteDate(LocalDateTime.now()));
		List<ExportsQ> exportsQList = getExportsList();
		if(exportsQList !=null){
			exportsQList.forEach(exportsQ -> {
				try {
					log.info("processing export id: " + exportsQ.getExportID());
					String scn = exportsQ.getVesselSCN();
					if(StringUtils.isNotBlank(scn)){
					log.info("SCN  : " + scn);
					String marrineStatus = getContainerVisitMarrineStatus(scn);
					log.info("VESSEL STATUS  : " + marrineStatus);
					if ("SAILED".equalsIgnoreCase(marrineStatus)) {
						deleteExportQ(exportsQ);
						log.info("successfully deleted: " + scn);
					}
					}
				} catch (Exception e) {
					log.error("An Error has occured while deleting exportsQ: " + e);
					e.printStackTrace();
				}
			});
		}
		log.info("ExportQList Processing ended: " + DateUtil.getFormatteDate(LocalDateTime.now()));
		}catch (Exception e) {
			log.error("An Error has occured while deleting exportsQ: " + e);
			e.printStackTrace();
		}

	}
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED, readOnly = false)
	private void deleteExportQ(ExportsQ exportsQ) throws Exception {
		exportsQService.delete(exportsQ);
	}

	@Transactional(value = "cbasTransactionManager", propagation = Propagation.REQUIRED, readOnly = true)
	private String getContainerVisitMarrineStatus(String scn) throws Exception {
		return vesselEnquiryService.findContainerVisitStatusByScn(scn);
	}

	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED, readOnly = true)
	private List<ExportsQ> getExportsList() throws Exception {
		return exportsQService.getAllExportsQ();
	}

}
