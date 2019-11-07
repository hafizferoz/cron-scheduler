/**
 * 
 */
package com.privasia.scheduler.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.privasia.scss.common.enums.Enumable;

/**
 * @author Hafiz Feroz
 *
 */
@Entity
@Table(name = "cbas_container_visit")
public class ContainerVisit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8558859344507166387L;

	public enum TideType implements Enumable{
		NEAP("NEAP"), SPRING("SPRING");

		private String neapSpringTide;

		private TideType(String neapSpringTide) {
			this.neapSpringTide = neapSpringTide;
		}

		public static TideType fromString(String value) {
			if (value.equals(NEAP.toString())) {
				return NEAP;
			} else if (value.equals(SPRING.toString())) {
				return SPRING;
			} else {
				return null;
			}

		}

		/**
		 * @return the neapSpringTide
		 */
		public String getNeapSpringTide() {
			return neapSpringTide;
		}

		/**
		 * @param neapSpringTide the neapSpringTide to set
		 */
		public void setNeapSpringTide(String neapSpringTide) {
			this.neapSpringTide = neapSpringTide;
		}

		@Override
		public String toString() {
			return neapSpringTide;
		}

		@Override
		public String getValue() {
			return neapSpringTide;
		}

		@Override
		public Enum<?> getEnumFromValue(String value) {
			return fromString(value);
		}

	}

	/**
	 * @author Ravi
	 */
	public enum PlanningStatus  implements Enumable {
		UNPLANNED(0), PLANNED(1), OMIT(2), EXPORTED(3);

		private int value;

		/**
		 * @param value int value
		 */
		PlanningStatus(int value) {
			this.value = value;
		}

		// the identifierMethod
		/**
		 * @return int value
		 */
		public int toInt() {
			return value;
		}

		// the valueOfMethod
		/**
		 * @param value value
		 * @return planning status
		 */
		public static PlanningStatus fromInt(int value) {
			switch (value) {
			case 0:
				return UNPLANNED;
			case 1:
				return PLANNED;
			case 2:
				return OMIT;
			case 3:
				return EXPORTED;
			default:
				return UNPLANNED;
			}
		}

		/**
		 * @return string value
		 */
		@Override
		public String toString() {
			switch (this) {
			case UNPLANNED:
				return "UNPLANNED";
			case PLANNED:
				return "PLANNED";
			case OMIT:
				return "OMIT";
			case EXPORTED:
				return "EXPORTED";
			default:
				return "UNPLANNED";
			}
		}

		@Override
		public String getValue() {
			return this.toString();
		}

		@Override
		public Enum<?> getEnumFromValue(String value) {
			return fromInt(Integer.parseInt(value));
		}
	}

	public enum TosFlag implements Enumable{

		COSMOS("COSMOS"), OPUS("OPUS");

		private String value;

		private TosFlag(String value) {
			this.value = value;
		}

		public static TosFlag fromString(String type) {
			if (type.equals(COSMOS.toString())) {
				return COSMOS;
			} else if (type.equals(OPUS.toString())) {
				return OPUS;
			} else {
				return null;
			}
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * @param value the value to set
		 */
		public void setValue(String value) {
			this.value = value;
		}

		/**
		 * 
		 */
		@Override
		public String toString() {
			return value;
		}

		@Override
		public Enum<?> getEnumFromValue(String value) {
			return fromString(value);
		}
	}

	@Id
	@GeneratedValue(generator = "idGen")
	@GenericGenerator(name = "idGen", strategy = "uuid.hex")
	@Column(name = "CONT_VISIT_ID", length = 64)
	private String id;

	@Column(name = "SCN", length = 20, nullable = false)
	private String scn;

	@Column(name = "VISIT_ID", length = 9)
	private String visitId;

	@Column(name = "SHIP_ID", length = 25, nullable = false)
	private String shipId;

	@Column(name = "VESSEL_TYPE", length = 20, nullable = false)
	private String vesselType;

	@Column(name = "VESSEL_CODE", length = 8, nullable = false)
	private String vesselCode;

	@Column(name = "VESSEL_NAME", length = 80, nullable = false)
	private String vesselName;

	@Column(name = "VESSEL_LOA", length = 6, nullable = false)
	private Integer vesselLoa;

	@Column(name = "OPERATOR_CODE", length = 8, nullable = false)
	private String operatorCode;

	@Column(name = "SERVICE_IN", length = 10, nullable = false)
	private String serviceIn;

	@Column(name = "SERVICE_OUT", length = 10, nullable = false)
	private String serviceOut;

	@Column(name = "VOYAGE_IN", length = 10, nullable = false)
	private String voyageIn;

	@Column(name = "VOYAGE_OUT", length = 10, nullable = false)
	private String voyageOut;

	@Column(name = "ALONG_SIDE", length = 20, nullable = false)
	private String alongside;

	@Column(name = "DISPLACEMENT_WEIGHT", length = 8)
	private Integer displacementWeight;

	@Column(name = "DISCHARGE_20", length = 5, nullable = false)
	private Integer discharge20;

	@Column(name = "DISCHARGE_40", length = 5, nullable = false)
	private Integer discharge40;

	@Column(name = "LOADING_20", length = 5, nullable = false)
	private Integer loading20;

	@Column(name = "LOADING_40", length = 5, nullable = false)
	private Integer loading40;

	@Column(name = "START_METER_MARK", length = 6)
	private Integer startMeterMark;

	@Column(name = "END_METER_MARK", length = 6)
	private Integer endMeterMark;

	@Column(name = "DRAFT", nullable = true, precision = 6, scale = 2)
	private Float draft;

	@Column(name = "ARRIVAL_DRAFT", nullable = true, precision = 8, scale = 2)
	private BigDecimal arrivalDraft = BigDecimal.ZERO;

	@Column(name = "DEPARTURE_DRAFT", nullable = true, precision = 8, scale = 2)
	private BigDecimal departureDraft = BigDecimal.ZERO;

	@Column(name = "CONTAINER_STACK_HEIGHT", length = 4)
	private Integer containerStackHeight;

	@Column(name = "MPH", length = 4, nullable = false)
	private Integer mph;

	@Column(name = "RESTOW", length = 5)
	private Integer restow;

	@Column(name = "NO_OF_CRANES", length = 4, nullable = false)
	private Integer noOfCranes;

	@Column(name = "REMRKS", length = 400)
	private String remarks;

	@Column(name = "ATB_REASON", length = 400)
	private String atbReason;

	@Column(name = "ATD_REASON", length = 400)
	private String atdReason;

	@Column(name = "ISSUE", length = 400)
	private String issue;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "DOUBLE_BANK_WITH", nullable = true)
	@ForeignKey(name = "FK_CONT_VSIT_DBL_BNK_WITH")
	private ContainerVisit doubleBankWith;

	@Column(name = "OMITED")
	private boolean omit;

	@Column(name = "ASSINED_WHARF")
	private String assignedWharf;

	@Column(name = "CREATED_BY", nullable = false)
	private String createdBy;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "MODIFIED_BY", nullable = true)
	private String modifiedBy;

	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;

	@Column(name = "ATA_DATE")
	private Date ataDate;

	@Column(name = "ATB_DATE")
	private Date atbDate;

	@Column(name = "ATD_DATE")
	private Date atdDate;

	@Column(name = "COSMOS_ETA_DATE", nullable = false)
	private Date cosmosEtaDate;

	@Column(name = "ETA_DATE", nullable = false)
	private Date etaDate;

	@Column(name = "ETB_DATE")
	private Date etbDate;

	@Column(name = "ETD_DATE", nullable = false)
	private Date etdDate;

	@Column(name = "PLANNING_STATUS", nullable = false, length = 1)
	//@Type(type = "com.privasia.scheduler.model.PlanningStatusTypeEnum", parameters = { @Parameter(name = "enumClass", value = "com.privasia.cbas.core.entity.ContainerVisit$PlanningStatus"), @Parameter(name = "identifierMethod", value = "toInt"), @Parameter(name = "valueOfMethod", value = "fromInt") })
	@Type(type = "com.privasia.scheduler.model.PlanningStatusTypeEnum")
	private PlanningStatus planningStatus;

	@Column(name = "PILOT_IN")
	private Date pilotIn;

	@Column(name = "PILOT_OUT")
	private Date pilotOut;

	@Column(name = "WINDOW_STATUS", length = 20, nullable = true)
	private String windowStatus;

	@Column(name = "MARINE_STATUS", length = 16)
	private String marineStatus;

	@Column(name = "DELAY_REASON")
	private String delayReason;

	@Column(name = "NORTH_BOLLARD_METERMARK", length = 6)
	private Integer northBollardMetermark;

	@Column(name = "SOUTH_BOLLARD_METERMARK", length = 6)
	private Integer southBollardMatermark;

	@Column(name = "SPLIT_VISIT")
	private Boolean split = Boolean.FALSE;

	@Column(name = "PRIMARY_VISIT")
	private Boolean primaryVisit = Boolean.TRUE;

	@Column(name = "LASHING", length = 100)
	private String lashing;

	@Column(name = "PAYER_NAME", length = 30)
	private String payer;


	@Column(name = "WINDOW_ID", nullable = true)
	private String window;

	@Column(name = "LAST_ETB_NOTIFICATION_TIME")
	private Date lastEtbNotificationTime; // USED FOR ETB NOTIFICATION SCHEDULED
											// JOB

	@Column(name = "LAST_ETB_CHANGE_TIME")
	private Date lastEtbChangeTime; // USED FOR ETB NOTIFICATION SCHEDULED JOB

	@Column(name = "ETB_NOTIFICATION_HOUR", length = 2)
	private Integer etbNotificationHour;

	@Column(name = "BERTH_DELAY", precision = 5, scale = 2)
	private Float berthDelay;

	@Column(name = "PREVIOUS_CRANE_MOVE", length = 100)
	private String previousCraneMove;

	@Column(name = "PLANNED_CRANE", length = 400)
	private String plannedCrane;

	@Column(name = "SHOW_BREAKDOWN_CRANE_MOVE")
	private Boolean showBreakdownCraneMove = Boolean.FALSE;

	@Column(name = "IS_MOTHER_VESSEL")
	private Boolean isMotherVessel = null;

	@Column(name = "TARGET_COMPLETION_DATE")
	private Date targetCompletionDate;

	@Column(name = "ORIGINAL_MOVES", length = 5)
	private Integer originalMoves;

	@Column(name = "TOTAL_MOVES", length = 5)
	private Integer totalMoves;

	@Column(name = "PRIMARY_VISIT_ID", nullable = true)
	private String parentVisit;

	@Column(name = "IS_PRIORITY")
	private Boolean isPriority = Boolean.FALSE;

	@Column(name = "LOCK_AND_GO")
	private Boolean lockAndGo = null;

	@Column(name = "MAIN_BLOCKS", length = 400)
	private String mainBlocks;

	@Column(name = "STACK_HEIGHT")
	private Boolean stackHeight = Boolean.FALSE;


	@Column(name = "PLANNING_BY", nullable = true)
	private String planningBy;

	@Column(name = "REF_CONT_VISIT_ID", length = 32)
	private String referenceId;

	@Column(name = "VESSEL_READY_REMRKS", length = 400)
	private String vesselReadyRemarks;

	@Column(name = "VESSEL_READY")
	private Date vesselReady;

	@Column(name = "SLOWDOWN_ETA_REMARKS", length = 400)
	private String slowdownETARemarks;

	@Column(name = "SLOWDOWN_ETA_DATE")
	private Date slowdownEtaDate;

	@Column(name = "OMIT_ID")
	private String omitReason;

	@Column(name = "OMIT_PORT", nullable = true, length = 80)
	private String omitPort;

	@Column(name = "LONG_CRANE", length = 5, nullable = true)
	private Integer longCrane;

	@Column(name = "AVG_TOTAL_MOVES", length = 5, nullable = true)
	private Integer avgTotalMoves;

	@Column(name = "CT_ALLOCATION", length = 255)
	private String ctAllocation;

	@Column(name = "IS_PRIORITY_VISIT")
	private Boolean priorityVisit = Boolean.FALSE;

	@Column(name = "IS_CMA_PARTNER")
	private Boolean cmaPartner = Boolean.FALSE;

	@Column(name = "MAX_WEIGHT_IND")
	private Boolean maxWeightInd = Boolean.FALSE;

	@Column(name = "NEXT_TIME_TRIGGER")
	private Date nextTimeTrigger;

	@Column(name = "MAX_WEIGHT", length = 6)
	private Integer maxWeight;

	@Column(name = "NEXT_PORT_CALL", length = 32)
	private String nextPortCall;

	@Column(name = "YARD_PLANNING_REMARKS", length = 400)
	private String yardRemarks;

	@Column(name = "TOS_FLAG", length = 10)
	//@Type(type = "com.privasia.scheduler.model.TosFlagTypeEnum", parameters = { @Parameter(name = "enumClass", value = "com.privasia.cbas.core.entity.ContainerVisit$TosFlag"), @Parameter(name = "identifierMethod", value = "toString"), @Parameter(name = "valueOfMethod", value = "fromString") })
	@Type(type = "com.privasia.scheduler.model.TosFlagTypeEnum")
	private TosFlag tosFlag;

	@Column(name = "IS_OPUS_SUCCESS", nullable = true)
	private Boolean isOpusSuccess = Boolean.FALSE;

	@Column(name = "OPUS_VISIT_NO", length = 17, nullable = true)
	private String opusVisitNo;

	@Column(name = "OPUS_VESSEL_CODE", length = 6, nullable = true)
	private String opusVesselCode;

	@Column(name = "OPUS_VESSEL_VOYAGE", length = 8, nullable = true)
	private String opusVesselVoyage;

	/*@Formula("CASE WHEN ((ETD_DATE + 3) < sysdate and ATD_DATE is null) or (ATD_DATE is not null and MARINE_STATUS <> 'SAILED') THEN 1 ELSE 0 END ")
	private Boolean saildButNotUpdated;*/


	// Updated from PwB : TRUE=RED, FALSE:GREEN
	@Column(name = "HIGH_STACK")
	private Boolean highStack = Boolean.FALSE;

	@Column(name = "UCUSTOMS_SCN", length = 20, nullable = true)
	private String ucustomsScn;

	@Column(name = "UCUSTOMS_VESSEL_ID", length = 32, nullable = true)
	private String ucustomsVesselId;

	@Column(name = "UCUSTOMS_ATA_SENT_DATE")
	private Date ucustomsAtaSentDate;

	@Column(name = "UCUSTOMS_ATD_SENT_DATE")
	private Date ucustomsAtdSentDate;

	@Column(name = "PRIORITY_COLOUR")
	private String priorityColour;

	@Column(name = "TIDE_TYPE", length = 15)
	//@Type(type = "com.privasia.scheduler.model.TideTypeEnum", parameters = { @Parameter(name = "enumClass", value = "com.privasia.cbas.core.entity.ContainerVisit$TideType"), @Parameter(name = "identifierMethod", value = "toString"), @Parameter(name = "valueOfMethod", value = "fromString") })
	@Type(type = "com.privasia.scheduler.model.TideTypeEnum")
	private TideType tideType;

	@Column(name = "LATITUDE", length = 20, nullable = true)
	private double latitude;

	@Column(name = "LONGITUDE", length = 20, nullable = true)
	private double longitude;
	
	@Column(name = "PARTNERS_ID")
	private String partner;
	





	/**
	 * The default constructor which initializes the state of some important properties.
	 * <ul>
	 * <li>split - Is split visit to FALSE</li>
	 * <li>primaryVisit - Is this a primary visit to TRUE</li>
	 * </ul>
	 */
	public ContainerVisit() {
		this.split = Boolean.FALSE;
		this.primaryVisit = Boolean.TRUE;
	}

	



	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the shipId
	 */
	public String getShipId() {
		return shipId;
	}

	/**
	 * @param shipId the shipId to set
	 */
	public void setShipId(String shipId) {
		this.shipId = shipId;
	}

	/**
	 * @return the vesselTYpe
	 */
	public String getVesselType() {
		return vesselType;
	}

	/**
	 * @param vesselType the vesselType to set
	 */
	public void setVesselType(String vesselType) {
		this.vesselType = vesselType;
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
	 * @return the vesselLoa
	 */
	public Integer getVesselLoa() {
		return vesselLoa;
	}

	/**
	 * @param vesselLoa the vesselLoa to set
	 */
	public void setVesselLoa(Integer vesselLoa) {
		this.vesselLoa = vesselLoa;
	}

	/**
	 * @return the operatorCode
	 */
	public String getOperatorCode() {
		return operatorCode;
	}

	/**
	 * @param operatorCode the operatorCode to set
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
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
	 * @return the etaDate
	 */
	public Date getEtaDate() {
		return etaDate;
	}

	/**
	 * @param etaDate the etaDate to set
	 */
	public void setEtaDate(Date etaDate) {
		this.etaDate = etaDate;
	}

	/**
	 * @return the cosmosEtaDate
	 */
	public Date getCosmosEtaDate() {
		return cosmosEtaDate;
	}

	/**
	 * @param cosmosEtaDate the cosmosEtaDate to set
	 */
	public void setCosmosEtaDate(Date cosmosEtaDate) {
		this.cosmosEtaDate = cosmosEtaDate;
	}

	/**
	 * @return the etdDate
	 */
	public Date getEtdDate() {
		return etdDate;
	}

	/**
	 * @param etdDate the etdDate to set
	 */
	public void setEtdDate(Date etdDate) {
		this.etdDate = etdDate;
	}

	/**
	 * @return the alongside
	 */
	public String getAlongside() {
		return alongside;
	}

	/**
	 * @param alongside the alongside to set
	 */
	public void setAlongside(String alongside) {
		this.alongside = alongside;
	}

	/**
	 * @return the displacementWeight
	 */
	public Integer getDisplacementWeight() {
		return displacementWeight;
	}

	/**
	 * @param displacementWeight the displacementWeight to set
	 */
	public void setDisplacementWeight(Integer displacementWeight) {
		this.displacementWeight = displacementWeight;
	}

	/**
	 * @return the discharge20
	 */
	public Integer getDischarge20() {
		return discharge20;
	}

	/**
	 * @param discharge20 the discharge20 to set
	 */
	public void setDischarge20(Integer discharge20) {
		this.discharge20 = discharge20;
	}

	/**
	 * @return the discharge40
	 */
	public Integer getDischarge40() {
		return discharge40;
	}

	/**
	 * @param discharge40 the discharge40 to set
	 */
	public void setDischarge40(Integer discharge40) {
		this.discharge40 = discharge40;
	}

	/**
	 * @return the loading20
	 */
	public Integer getLoading20() {
		return loading20;
	}

	/**
	 * @param loading20 the loading20 to set
	 */
	public void setLoading20(Integer loading20) {
		this.loading20 = loading20;
	}

	/**
	 * @return the loading40
	 */
	public Integer getLoading40() {
		return loading40;
	}

	/**
	 * @param loading40 the loading40 to set
	 */
	public void setLoading40(Integer loading40) {
		this.loading40 = loading40;
	}

	/**
	 * @return the startMeterMark
	 */
	public Integer getStartMeterMark() {
		return startMeterMark;
	}

	/**
	 * @param startMeterMark the startMeterMark to set
	 */
	public void setStartMeterMark(Integer startMeterMark) {
		this.startMeterMark = startMeterMark;
	}

	/**
	 * @return the endMeterMark
	 */
	public Integer getEndMeterMark() {
		return endMeterMark;
	}

	/**
	 * @param endMeterMark the endMeterMark to set
	 */
	public void setEndMeterMark(Integer endMeterMark) {
		this.endMeterMark = endMeterMark;
	}

	/**
	 * @return the containerStackHeight
	 */
	public Integer getContainerStackHeight() {
		return containerStackHeight;
	}

	/**
	 * @param containerStackHeight the containerStackHeight to set
	 */
	public void setContainerStackHeight(Integer containerStackHeight) {
		this.containerStackHeight = containerStackHeight;
	}

	/**
	 * @return the mph
	 */
	public Integer getMph() {
		return mph;
	}

	/**
	 * @param mph the mph to set
	 */
	public void setMph(Integer mph) {
		this.mph = mph;
	}

	/**
	 * @return the restow
	 */
	public Integer getRestow() {
		return restow;
	}

	/**
	 * @param restow set to restow
	 */
	public void setRestow(Integer restow) {
		this.restow = restow;
	}

	/**
	 * @return the noOfCranes
	 */
	public Integer getNoOfCranes() {
		return noOfCranes;
	}

	/**
	 * @param noOfCranes the noOfCranes to set
	 */
	public void setNoOfCranes(Integer noOfCranes) {
		this.noOfCranes = noOfCranes;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the doubleBankWith
	 */
	public ContainerVisit getDoubleBankWith() {
		return doubleBankWith;
	}

	/**
	 * @param doubleBankWith the doubleBankWith to set
	 */
	public void setDoubleBankWith(ContainerVisit doubleBankWith) {
		this.doubleBankWith = doubleBankWith;
	}

	/**
	 * @return the omit
	 */
	public boolean isOmit() {
		return omit;
	}

	/**
	 * @param omit the omit to set
	 */
	public void setOmit(boolean omit) {
		this.omit = omit;
	}

	/**
	 * @return the createdBY
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the modifiedDate
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @return the ataDate
	 */
	public Date getAtaDate() {
		return ataDate;
	}

	/**
	 * @param ataDate the ataDate to set
	 */
	public void setAtaDate(Date ataDate) {
		this.ataDate = ataDate;
	}

	/**
	 * @return the atbDate
	 */
	public Date getAtbDate() {
		return atbDate;
	}

	/**
	 * @param atbDate the atbDate to set
	 */
	public void setAtbDate(Date atbDate) {
		this.atbDate = atbDate;
	}

	/**
	 * @return the atdDate
	 */
	public Date getAtdDate() {
		return atdDate;
	}

	/**
	 * @param atdDate the atdDate to set
	 */
	public void setAtdDate(Date atdDate) {
		this.atdDate = atdDate;
	}

	/**
	 * @return the operationParticulars
	 *//*
	public List<OperationParticulars> getOperationParticulars() {
		return operationParticulars;
	}

	*//**
	 * @param operationParticulars the operationParticulars to set
	 *//*
	public void setOperationParticulars(List<OperationParticulars> operationParticulars) {
		this.operationParticulars = operationParticulars;
	}*/

	/**
	 * @return the planningStatus
	 */
	public PlanningStatus getPlanningStatus() {
		return planningStatus;
	}

	/**
	 * @param planningStatus the planningStatus to set
	 */
	public void setPlanningStatus(PlanningStatus planningStatus) {
		this.planningStatus = planningStatus;
	}

	/**
	 * @return the pilotIn
	 */
	public Date getPilotIn() {
		return pilotIn;
	}

	/**
	 * @param pilotIn the pilotIn to set
	 */
	public void setPilotIn(Date pilotIn) {
		this.pilotIn = pilotIn;
	}

	/**
	 * @return the pilotOut
	 */
	public Date getPilotOut() {
		return pilotOut;
	}

	/**
	 * @param pilotOut the pilotOut to set
	 */
	public void setPilotOut(Date pilotOut) {
		this.pilotOut = pilotOut;
	}

	/**
	 * @return etb
	 */
	public Date getEtbDate() {
		return etbDate;
	}

	/**
	 * @param etbDate to set
	 */
	public void setEtbDate(Date etbDate) {
		this.etbDate = etbDate;
	}

	/**
	 * @return window status
	 */
	public String getWindowStatus() {
		return windowStatus;
	}

	/**
	 * @param windowStatus set status
	 */
	public void setWindowStatus(String windowStatus) {
		this.windowStatus = windowStatus;
	}

	/**
	 * @return the marineStatus
	 */
	public String getMarineStatus() {
		return marineStatus;
	}

	/**
	 * @param marineStatus the marineStatus to set
	 */
	public void setMarineStatus(String marineStatus) {
		this.marineStatus = marineStatus;
	}

	/**
	 * @return the assignedWharf
	 */
	public String getAssignedWharf() {
		return assignedWharf;
	}

	/**
	 * @param assignedWharf the assignedWharf to set
	 */
	public void setAssignedWharf(String assignedWharf) {
		this.assignedWharf = assignedWharf;
	}

	/**
	 * @return the northBollardMetermark
	 */
	public Integer getNorthBollardMetermark() {
		return northBollardMetermark;
	}

	/**
	 * @param northBollardMetermark the northBollardMetermark to set
	 */
	public void setNorthBollardMetermark(Integer northBollardMetermark) {
		this.northBollardMetermark = northBollardMetermark;
	}

	/**
	 * @return southBollardMatermark
	 */
	public Integer getSouthBollardMatermark() {
		return southBollardMatermark;
	}

	/**
	 * @param southBollardMatermark to set southBollardMatermark
	 */
	public void setSouthBollardMatermark(Integer southBollardMatermark) {
		this.southBollardMatermark = southBollardMatermark;
	}

	/**
	 * @return issue
	 */
	public String getIssue() {
		return issue;
	}

	/**
	 * @param issue set issue
	 */
	public void setIssue(String issue) {
		this.issue = issue;
	}

	/**
	 * @return the {@link DelayReason}
	 */
	public String getDelayReason() {
		return delayReason;
	}

	/**
	 * @param delayReason to set
	 */
	public void setDelayReason(String delayReason) {
		this.delayReason = delayReason;
	}

	/**
	 * @return the split
	 */
	public Boolean getSplit() {
		return split;
	}

	/**
	 * @param split the split to set
	 */
	public void setSplit(Boolean split) {
		this.split = split;
	}

	/**
	 * @return the primaryVisit
	 */
	public Boolean getPrimaryVisit() {
		return primaryVisit;
	}

	/**
	 * @param primaryVisit the primaryVisit to set
	 */
	public void setPrimaryVisit(Boolean primaryVisit) {
		this.primaryVisit = primaryVisit;
	}

	/**
	 * @return lashing
	 */
	public String getLashing() {
		return lashing;
	}

	/**
	 * @param lashing to set lashing
	 */
	public void setLashing(String lashing) {
		this.lashing = lashing;
	}

	/**
	 * @return the payer
	 */
	public String getPayer() {
		return payer;
	}

	/**
	 * @param payer the payer to set
	 */
	public void setPayer(String payer) {
		this.payer = payer;
	}

/*	*//**
	 * @return Crane Moves
	 *//*
	public List<ContainerVisitCraneMove> getContainerVisitCraneMoves() {
		return containerVisitCraneMoves;
	}

	*//**
	 * @param containerVisitCraneMoves the crane moves to set.
	 *//*
	public void setContainerVisitCraneMoves(List<ContainerVisitCraneMove> containerVisitCraneMoves) {
		this.containerVisitCraneMoves = containerVisitCraneMoves;
	}*/

	/**
	 * @return the lastEtbNotificationTime
	 */
	public Date getLastEtbNotificationTime() {
		return lastEtbNotificationTime;
	}

	/**
	 * @param lastEtbNotificationTime the lastEtbNotificationTime to set
	 */
	public void setLastEtbNotificationTime(Date lastEtbNotificationTime) {
		this.lastEtbNotificationTime = lastEtbNotificationTime;
	}

	/**
	 * @return the lastEtbChangeTime
	 */
	public Date getLastEtbChangeTime() {
		return lastEtbChangeTime;
	}

	/**
	 * @param lastEtbChangeTime the lastEtbChangeTime to set
	 */
	public void setLastEtbChangeTime(Date lastEtbChangeTime) {
		this.lastEtbChangeTime = lastEtbChangeTime;
	}

	public String getPreviousCraneMove() {
		return previousCraneMove;
	}

	public void setPreviousCraneMove(String previousCraneMove) {
		this.previousCraneMove = previousCraneMove;
	}

	/**
	 * @return the window
	 */
	public String getWindow() {
		return window;
	}

	/**
	 * @param window the window to set
	 */
	public void setWindow(String window) {
		this.window = window;
	}

	/**
	 * @return the berthDelay
	 */
	public Float getBerthDelay() {
		return berthDelay;
	}

	/**
	 * @param berthDelay the berthDelay to set
	 */
	public void setBerthDelay(Float berthDelay) {
		this.berthDelay = berthDelay;
	}

	/**
	 * @return the isMotherVessel
	 */
	public Boolean getIsMotherVessel() {
		return isMotherVessel;
	}

	/**
	 * @param isMotherVessel the isMotherVessel to set
	 */
	public void setIsMotherVessel(Boolean isMotherVessel) {
		this.isMotherVessel = isMotherVessel;
	}

	public String getAtbReason() {
		return atbReason;
	}

	public void setAtbReason(String atbReason) {
		this.atbReason = atbReason;
	}

	public String getAtdReason() {
		return atdReason;
	}

	public void setAtdReason(String atdReason) {
		this.atdReason = atdReason;
	}

	public Boolean getShowBreakdownCraneMove() {
		return showBreakdownCraneMove;
	}

	public void setShowBreakdownCraneMove(Boolean showBreakdownCraneMove) {
		this.showBreakdownCraneMove = showBreakdownCraneMove;
	}

	public Date getTargetCompletionDate() {
		return targetCompletionDate;
	}

	public void setTargetCompletionDate(Date targetCompletionDate) {
		this.targetCompletionDate = targetCompletionDate;
	}


	/**
	 * @return the draft
	 */
	public Float getDraft() {
		return draft;
	}

	/**
	 * @param draft the draft to set
	 */
	public void setDraft(Float draft) {
		this.draft = draft;
	}

	/**
	 * @return the arrivalDraft
	 */
	public BigDecimal getArrivalDraft() {
		return arrivalDraft;
	}

	/**
	 * @param arrivalDraft the arrivalDraft to set
	 */
	public void setArrivalDraft(BigDecimal arrivalDraft) {
		this.arrivalDraft = arrivalDraft;
	}

	/**
	 * @return the departureDraft
	 */
	public BigDecimal getDepartureDraft() {
		return departureDraft;
	}

	/**
	 * @param departureDraft the departureDraft to set
	 */
	public void setDepartureDraft(BigDecimal departureDraft) {
		this.departureDraft = departureDraft;
	}

	/**
	 * @return the originalMoves
	 */
	public Integer getOriginalMoves() {
		return originalMoves;
	}

	/**
	 * @param originalMoves the originalMoves to set
	 */
	public void setOriginalMoves(Integer originalMoves) {
		this.originalMoves = originalMoves;
	}

	/**
	 * @return the totalMoves
	 */
	public Integer getTotalMoves() {
		return totalMoves;
	}

	/**
	 * @param totalMoves the totalMoves to set
	 */
	public void setTotalMoves(Integer totalMoves) {
		this.totalMoves = totalMoves;
	}






	/**
	 * @return the parentVisit
	 */
	public String getParentVisit() {
		return parentVisit;
	}

	/**
	 * @param parentVisit the parentVisit to set
	 */
	public void setParentVisit(String parentVisit) {
		this.parentVisit = parentVisit;
	}


	public Boolean isPriority() {
		return isPriority;
	}

	public void setPriority(Boolean priority) {
		isPriority = priority;
	}

	/**
	 * @return the lockAndGo
	 */
	public Boolean getLockAndGo() {
		return lockAndGo;
	}

	/**
	 * @param lockAndGo the lockAndGo to set
	 */
	public void setLockAndGo(Boolean lockAndGo) {
		this.lockAndGo = lockAndGo;
	}

	/**
	 * @return the mainBlocks
	 */
	public String getMainBlocks() {
		return mainBlocks;
	}

	/**
	 * @param mainBlocks the mainBlocks to set
	 */
	public void setMainBlocks(String mainBlocks) {
		this.mainBlocks = mainBlocks;
	}


	public Boolean getStackHeight() {
		return stackHeight;
	}

	public void setStackHeight(Boolean stackHeight) {
		this.stackHeight = stackHeight;
	}


	/**
	 * @return the etbNotificationHour
	 */
	public Integer getEtbNotificationHour() {
		return etbNotificationHour;
	}

	/**
	 * @param etbNotificationHour the etbNotificationHour to set
	 */
	public void setEtbNotificationHour(Integer etbNotificationHour) {
		this.etbNotificationHour = etbNotificationHour;
	}

	/**
	 * @return the plannedCrane
	 */
	public String getPlannedCrane() {
		return plannedCrane;
	}

	/**
	 * @param plannedCrane the plannedCrane to set
	 */
	public void setPlannedCrane(String plannedCrane) {
		this.plannedCrane = plannedCrane;
	}



	/**
	 * @return the planningBy
	 */
	public String getPlanningBy() {
		return planningBy;
	}

	/**
	 * @param planningBy the planningBy to set
	 */
	public void setPlanningBy(String planningBy) {
		this.planningBy = planningBy;
	}

	/**
	 * @return the referenceId
	 */
	public String getReferenceId() {
		return referenceId;
	}

	/**
	 * @param referenceId the referenceId to set
	 */
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}


	public String getVesselReadyRemarks() {
		return vesselReadyRemarks;
	}

	public void setVesselReadyRemarks(String vesselReadyRemarks) {
		this.vesselReadyRemarks = vesselReadyRemarks;
	}

	public Date getVesselReady() {
		return vesselReady;
	}

	public void setVesselReady(Date vesselReady) {
		this.vesselReady = vesselReady;
	}

	/**
	 * @return the omitReason
	 */
	public String getOmitReason() {
		return omitReason;
	}

	/**
	 * @return the omitPort
	 */
	public String getOmitPort() {
		return omitPort;
	}

	/**
	 * @param omitPort the omitPort to set
	 */
	public void setOmitPort(String omitPort) {
		this.omitPort = omitPort;
	}

	/**
	 * @param omitReason the omitReason to set
	 */
	public void setOmitReason(String omitReason) {
		this.omitReason = omitReason;
	}


	/**
	 * @return the isPriority
	 */
	public Boolean getIsPriority() {
		return isPriority;
	}

	/**
	 * @param isPriority the isPriority to set
	 */
	public void setIsPriority(Boolean isPriority) {
		this.isPriority = isPriority;
	}

	/**
	 * @return the LongCrane
	 */
	public Integer getLongCrane() {
		return longCrane;
	}

	/**
	 * @param avgLongCrane the avgLongCrane to set
	 */
	public void setLongCrane(Integer longCrane) {
		this.longCrane = longCrane;
	}

	/**
	 * @return the avgTotalMoves
	 */
	public Integer getAvgTotalMoves() {
		return avgTotalMoves;
	}

	/**
	 * @param avgTotalMoves the avgTotalMoves to set
	 */
	public void setAvgTotalMoves(Integer avgTotalMoves) {
		this.avgTotalMoves = avgTotalMoves;
	}



	/**
	 * @return the ctAllocation
	 */
	public String getCtAllocation() {
		return ctAllocation;
	}

	/**
	 * @param ctAllocation the ctAllocation to set
	 */
	public void setCtAllocation(String ctAllocation) {
		this.ctAllocation = ctAllocation;
	}

	/**
	 * @return the priorityVisit
	 */
	public Boolean getPriorityVisit() {
		return priorityVisit;
	}

	/**
	 * @param priorityVisit the priorityVisit to set
	 */
	public void setPriorityVisit(Boolean priorityVisit) {
		this.priorityVisit = priorityVisit;
	}

	/**
	 * @return the cmaPartner
	 */
	public Boolean getCmaPartner() {
		return cmaPartner;
	}

	/**
	 * @param cmaPartner the cmaPartner to set
	 */
	public void setCmaPartner(Boolean cmaPartner) {
		this.cmaPartner = cmaPartner;
	}

	/**
	 * @return the maxWeightInd
	 */
	public Boolean getMaxWeightInd() {
		return maxWeightInd;
	}

	/**
	 * @param maxWeightInd the maxWeightInd to set
	 */
	public void setMaxWeightInd(Boolean maxWeightInd) {
		this.maxWeightInd = maxWeightInd;
	}

	/**
	 * @return the nextTimeTrigger
	 */
	public Date getNextTimeTrigger() {
		return nextTimeTrigger;
	}

	/**
	 * @param nextTimeTrigger the nextTimeTrigger to set
	 */
	public void setNextTimeTrigger(Date nextTimeTrigger) {
		this.nextTimeTrigger = nextTimeTrigger;
	}

	/**
	 * @return the maxWeight
	 */
	public Integer getMaxWeight() {
		return maxWeight;
	}

	/**
	 * @param maxWeight the maxWeight to set
	 */
	public void setMaxWeight(Integer maxWeight) {
		this.maxWeight = maxWeight;
	}



	/**
	 * @return the nextPortCall
	 */
	public String getNextPortCall() {
		return nextPortCall;
	}

	/**
	 * @param nextPortCall the nextPortCall to set
	 */
	public void setNextPortCall(String nextPortCall) {
		this.nextPortCall = nextPortCall;
	}

	/**
	 * @return the yardRemarks
	 */
	public String getYardRemarks() {
		return yardRemarks;
	}

	/**
	 * @param yardRemarks the yardRemarks to set /**
	 * @return the saildButNotUpdated
	 *//*
	public Boolean getSaildButNotUpdated() {
		return saildButNotUpdated;
	}

	*//**
	 * @param saildButNotUpdated the saildButNotUpdated to set
	 *//*
	public void setSaildButNotUpdated(Boolean saildButNotUpdated) {
		this.saildButNotUpdated = saildButNotUpdated;
	}*/

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public void setYardRemarks(String yardRemarks) {
		this.yardRemarks = yardRemarks;
	}

	/**
	 * @return the tosFlag
	 */
	public TosFlag getTosFlag() {
		return tosFlag;
	}

	/**
	 * @param tosFlag the tosFlag to set
	 */
	public void setTosFlag(TosFlag tosFlag) {
		this.tosFlag = tosFlag;
	}

	/**
	 * @return the isOpusSuccess
	 */
	public Boolean getIsOpusSuccess() {
		return isOpusSuccess;
	}

	/**
	 * @param isOpusSuccess the isOpusSuccess to set
	 */
	public void setIsOpusSuccess(Boolean isOpusSuccess) {
		this.isOpusSuccess = isOpusSuccess;
	}

	/**
	 * @return the opusVisitNo
	 */
	public String getOpusVisitNo() {
		return opusVisitNo;
	}

	/**
	 * @param opusVisitNo the opusVisitNo to set
	 */
	public void setOpusVisitNo(String opusVisitNo) {
		this.opusVisitNo = opusVisitNo;
	}

	/**
	 * @return the opusVesselCode
	 */
	public String getOpusVesselCode() {
		return opusVesselCode;
	}

	/**
	 * @param opusVesselCode the opusVesselCode to set
	 */
	public void setOpusVesselCode(String opusVesselCode) {
		this.opusVesselCode = opusVesselCode;
	}

	/**
	 * @return the opusVesselVoyage
	 */
	public String getOpusVesselVoyage() {
		return opusVesselVoyage;
	}

	/**
	 * @param opusVesselVoyage the opusVesselVoyage to set
	 */
	public void setOpusVesselVoyage(String opusVesselVoyage) {
		this.opusVesselVoyage = opusVesselVoyage;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ContainerVisit other = (ContainerVisit) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (scn == null) {
			if (other.scn != null) {
				return false;
			}
		} else if (!scn.equals(other.scn)) {
			return false;
		}
		if (visitId == null) {
			if (other.visitId != null) {
				return false;
			}
		} else if (!visitId.equals(other.visitId)) {
			return false;
		}
		if (serviceIn == null) {
			if (other.serviceIn != null) {
				return false;
			}
		} else if (!serviceIn.equals(other.serviceIn)) {
			return false;
		}
		if (serviceOut == null) {
			if (other.serviceOut != null) {
				return false;
			}
		} else if (!serviceOut.equals(other.serviceOut)) {
			return false;
		}
		if (voyageIn == null) {
			if (other.voyageIn != null) {
				return false;
			}
		} else if (!voyageIn.equals(other.voyageIn)) {
			return false;
		}
		if (voyageOut == null) {
			if (other.voyageOut != null) {
				return false;
			}
		} else if (!voyageOut.equals(other.voyageOut)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((scn == null) ? 0 : scn.hashCode());
		result = prime * result + ((serviceIn == null) ? 0 : serviceIn.hashCode());
		result = prime * result + ((serviceOut == null) ? 0 : serviceOut.hashCode());
		result = prime * result + ((voyageIn == null) ? 0 : voyageIn.hashCode());
		result = prime * result + ((voyageOut == null) ? 0 : voyageOut.hashCode());
		return result;
	}

	public String getSlowdownETARemarks() {
		return slowdownETARemarks;
	}

	public void setSlowdownETARemarks(String slowdownETARemarks) {
		this.slowdownETARemarks = slowdownETARemarks;
	}

	public Date getSlowdownEtaDate() {
		return slowdownEtaDate;
	}

	public void setSlowdownEtaDate(Date slowdownEtaDate) {
		this.slowdownEtaDate = slowdownEtaDate;
	}



	/**
	 * @return the highStack
	 */
	public Boolean getHighStack() {
		return highStack;
	}

	/**
	 * @param highStack the highStack to set
	 */
	public void setHighStack(Boolean highStack) {
		this.highStack = highStack;
	}


	/**
	 * @return the ucustomsScn
	 */
	public String getUcustomsScn() {
		return ucustomsScn;
	}

	/**
	 * @param ucustomsScn the ucustomsScn to set
	 */
	public void setUcustomsScn(String ucustomsScn) {
		this.ucustomsScn = ucustomsScn;
	}

	/**
	 * @return the ucustomsVesselId
	 */
	public String getUcustomsVesselId() {
		return ucustomsVesselId;
	}

	/**
	 * @param ucustomsVesselId the ucustomsVesselId to set
	 */
	public void setUcustomsVesselId(String ucustomsVesselId) {
		this.ucustomsVesselId = ucustomsVesselId;
	}

	/**
	 * @return the ucustomsAtaSentDate
	 */
	public Date getUcustomsAtaSentDate() {
		return ucustomsAtaSentDate;
	}

	/**
	 * @param ucustomsAtaSentDate the ucustomsAtaSentDate to set
	 */
	public void setUcustomsAtaSentDate(Date ucustomsAtaSentDate) {
		this.ucustomsAtaSentDate = ucustomsAtaSentDate;
	}

	/**
	 * @return the ucustomsAtdSentDate
	 */
	public Date getUcustomsAtdSentDate() {
		return ucustomsAtdSentDate;
	}

	/**
	 * @param ucustomsAtdSentDate the ucustomsAtdSentDate to set
	 */
	public void setUcustomsAtdSentDate(Date ucustomsAtdSentDate) {
		this.ucustomsAtdSentDate = ucustomsAtdSentDate;
	}


	/**
	 * @return the priorityColour
	 */
	public String getPriorityColour() {
		return priorityColour;
	}

	/**
	 * @param priorityColour the priorityColour to set
	 */
	public void setPriorityColour(String priorityColour) {
		this.priorityColour = priorityColour;
	}

	/**
	 * @return the tideType
	 */
	public TideType getTideType() {
		return tideType;
	}

	/**
	 * @param tideType the tideType to set
	 */
	public void setTideType(TideType tideType) {
		this.tideType = tideType;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the partnersId
	 */
	public String getPartner() {
		return partner;
	}

	/**
	 * @param partnersId the partnersId to set
	 */
	public void setPartner(String partner) {
		this.partner = partner;
	}

	
}
