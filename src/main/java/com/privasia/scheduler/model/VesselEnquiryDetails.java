package com.privasia.scheduler.model;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Hafiz Feroz
 */

public class VesselEnquiryDetails implements Serializable {

	private static final long serialVersionUID = 8563391431783262719L;

	private String visitId;

	private String shippingLine;

	private String vesselCode;

	private String vesselId;

	private String vesselName;

	private String vesselOperator;

	private String voyageIn;

	private String voyageOut;

	private String scn;

	private String callSign;

	private String serviceIn;

	private String serviceOut;

	private Date ataDatetime;

	private Date atbDatetime;

	private Date pilotInDatetime;

	private Date pilotOutDatetime;

	private Date atdDatetime;

	private Date etaDatetime;

	private Date etdDatetime;

	private Date openingDatetime;

	private Date closeDatetime;

	private Date startWorkingDatetime;

	private String berth;

	private String status;

	private String tosFlag;

	private boolean cosmosVisit;

	private String opusVesselCode;

	private String opusVoyage;

	private Date endWorkingDatetime;


	public VesselEnquiryDetails() {
	}

	

	/**
	 * @return the visitId
	 */
	public String getVisitId() {
		return visitId;
	}

	/**
	 * @param visitId the visitId to set
	 */
	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	/**
	 * @return the vesselCode
	 */
	public String getVesselCode() {
		return vesselCode;
	}

	/**
	 * @param vesselCode the vesselCode to set
	 */
	public void setVesselCode(String vesselCode) {
		this.vesselCode = vesselCode;
	}

	/**
	 * @return the vesselId
	 */
	public String getVesselId() {
		return vesselId;
	}

	/**
	 * @param vesselId the vesselId to set
	 */
	public void setVesselId(String vesselId) {
		this.vesselId = vesselId;
	}

	/**
	 * @return the vesselName
	 */
	public String getVesselName() {
		return vesselName;
	}

	/**
	 * @param vesselName the vesselName to set
	 */
	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	/**
	 * @return the vesselOperator
	 */
	public String getVesselOperator() {
		return vesselOperator;
	}

	/**
	 * @param vesselOperator the vesselOperator to set
	 */
	public void setVesselOperator(String vesselOperator) {
		this.vesselOperator = vesselOperator;
	}

	/**
	 * @return the voyageIn
	 */
	public String getVoyageIn() {
		return voyageIn;
	}

	/**
	 * @param voyageIn the voyageIn to set
	 */
	public void setVoyageIn(String voyageIn) {
		this.voyageIn = voyageIn;
	}

	/**
	 * @return the voyageOut
	 */
	public String getVoyageOut() {
		return voyageOut;
	}

	/**
	 * @param voyageOut the voyageOut to set
	 */
	public void setVoyageOut(String voyageOut) {
		this.voyageOut = voyageOut;
	}

	/**
	 * @return the scn
	 */
	public String getScn() {
		return scn;
	}

	/**
	 * @param scn the scn to set
	 */
	public void setScn(String scn) {
		this.scn = scn;
	}

	/**
	 * @return the callSign
	 */
	public String getCallSign() {
		return callSign;
	}

	/**
	 * @param callSign the callSign to set
	 */
	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}

	/**
	 * @return the serviceIn
	 */
	public String getServiceIn() {
		return serviceIn;
	}

	/**
	 * @param serviceIn the serviceIn to set
	 */
	public void setServiceIn(String serviceIn) {
		this.serviceIn = serviceIn;
	}

	/**
	 * @return the serviceOut
	 */
	public String getServiceOut() {
		return serviceOut;
	}

	/**
	 * @param serviceOut the serviceOut to set
	 */
	public void setServiceOut(String serviceOut) {
		this.serviceOut = serviceOut;
	}

	/**
	 * @return the ataDatetime
	 */
	public Date getAtaDatetime() {
		return ataDatetime;
	}

	/**
	 * @param ataDatetime the ataDatetime to set
	 */
	public void setAtaDatetime(Date ataDatetime) {
		this.ataDatetime = ataDatetime;
	}

	/**
	 * @return the atbDatetime
	 */
	public Date getAtbDatetime() {
		return atbDatetime;
	}

	/**
	 * @param atbDatetime the atbDatetime to set
	 */
	public void setAtbDatetime(Date atbDatetime) {
		this.atbDatetime = atbDatetime;
	}

	/**
	 * @return the pilotInDatetime
	 */
	public Date getPilotInDatetime() {
		return pilotInDatetime;
	}

	/**
	 * @param pilotInDatetime the pilotInDatetime to set
	 */
	public void setPilotInDatetime(Date pilotInDatetime) {
		this.pilotInDatetime = pilotInDatetime;
	}

	/**
	 * @return the pilotOutDatetime
	 */
	public Date getPilotOutDatetime() {
		return pilotOutDatetime;
	}

	/**
	 * @param pilotOutDatetime the pilotOutDatetime to set
	 */
	public void setPilotOutDatetime(Date pilotOutDatetime) {
		this.pilotOutDatetime = pilotOutDatetime;
	}

	/**
	 * @return the atdDatetime
	 */
	public Date getAtdDatetime() {
		return atdDatetime;
	}

	/**
	 * @param atdDatetime the atdDatetime to set
	 */
	public void setAtdDatetime(Date atdDatetime) {
		this.atdDatetime = atdDatetime;
	}

	/**
	 * @return the etaDatetime
	 */
	public Date getEtaDatetime() {
		return etaDatetime;
	}

	/**
	 * @param etaDatetime the etaDatetime to set
	 */
	public void setEtaDatetime(Date etaDatetime) {
		this.etaDatetime = etaDatetime;
	}

	/**
	 * @return the etdDatetime
	 */
	public Date getEtdDatetime() {
		return etdDatetime;
	}

	/**
	 * @param etdDatetime the etdDatetime to set
	 */
	public void setEtdDatetime(Date etdDatetime) {
		this.etdDatetime = etdDatetime;
	}

	/**
	 * @return the openingDatetime
	 */
	public Date getOpeningDatetime() {
		return openingDatetime;
	}

	/**
	 * @param openingDatetime the openingDatetime to set
	 */
	public void setOpeningDatetime(Date openingDatetime) {
		this.openingDatetime = openingDatetime;
	}

	/**
	 * @return the closeDatetime
	 */
	public Date getCloseDatetime() {
		return closeDatetime;
	}

	/**
	 * @param closeDatetime the closeDatetime to set
	 */
	public void setCloseDatetime(Date closeDatetime) {
		this.closeDatetime = closeDatetime;
	}

	/**
	 * @return the startWorkingDatetime
	 */
	public Date getStartWorkingDatetime() {
		return startWorkingDatetime;
	}

	/**
	 * @param startWorkingDatetime the startWorkingDatetime to set
	 */
	public void setStartWorkingDatetime(Date startWorkingDatetime) {
		this.startWorkingDatetime = startWorkingDatetime;
	}

	/**
	 * @return the berth
	 */
	public String getBerth() {
		return berth;
	}

	/**
	 * @param berth the berth to set
	 */
	public void setBerth(String berth) {
		this.berth = berth;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the shippingLine
	 */
	public String getShippingLine() {
		return shippingLine;
	}

	/**
	 * @param shippingLine the shippingLine to set
	 */
	public void setShippingLine(String shippingLine) {
		this.shippingLine = shippingLine;
	}

	public String getTosFlag() {
		return tosFlag;
	}

	public void setTosFlag(String tosFlag) {
		this.tosFlag = tosFlag;
	}

	public boolean isCosmosVisit() {
		return cosmosVisit;
	}

	public void setCosmosVisit(boolean cosmosVisit) {
		this.cosmosVisit = cosmosVisit;
	}

	public String getOpusVesselCode() {
		return opusVesselCode;
	}

	public void setOpusVesselCode(String opusVesselCode) {
		this.opusVesselCode = opusVesselCode;
	}

	public String getOpusVoyage() {
		return opusVoyage;
	}

	public void setOpusVoyage(String opusVoyage) {
		this.opusVoyage = opusVoyage;
	}

	/**
	 * @return the endWorkingDatetime
	 */
	public Date getEndWorkingDatetime() {
		return endWorkingDatetime;
	}

	/**
	 * @param endWorkingDatetime the endWorkingDatetime to set
	 */
	public void setEndWorkingDatetime(Date endWorkingDatetime) {
		this.endWorkingDatetime = endWorkingDatetime;
	}


	public String toLogString() {
		return "VesselEnquiryDetails [visitId=" + visitId + ", shippingLine=" + shippingLine + ", vesselCode=" + vesselCode + ", vesselId=" + vesselId + ", vesselName=" + vesselName + ", vesselOperator=" + vesselOperator + ", voyageIn=" + voyageIn + ", voyageOut=" + voyageOut + ", scn=" + scn + ", callSign=" + callSign + ", serviceIn=" + serviceIn + ", serviceOut=" + serviceOut + ", ataDatetime=" + ataDatetime + ", atbDatetime=" + atbDatetime + ", pilotInDatetime=" + pilotInDatetime + ", pilotOutDatetime=" + pilotOutDatetime + ", atdDatetime=" + atdDatetime + ", etaDatetime=" + etaDatetime + ", etdDatetime=" + etdDatetime + ", openingDatetime=" + openingDatetime + ", closeDatetime=" + closeDatetime + ", startWorkingDatetime=" + startWorkingDatetime + ", berth=" + berth + ", status=" + status + ", tosFlag=" + tosFlag + ", cosmosVisit=" + cosmosVisit + ", opusVesselCode=" + opusVesselCode + ", opusVoyage=" + opusVoyage + "]";
	}

}
