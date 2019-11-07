/**
 * 
 */
package com.privasia.scheduler.model;

import java.io.Serializable;

import com.privasia.scheduler.model.ContainerVisit.PlanningStatus;
import com.privasia.scss.common.enumusertype.GeneralEnumMapUserType;


/**
 * @author Hafiz Feroz
 *
 */
public class PlanningStatusTypeEnum extends GeneralEnumMapUserType<PlanningStatus> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 *
	 */
	public PlanningStatusTypeEnum() {
		super(PlanningStatus.class);
	}

}
