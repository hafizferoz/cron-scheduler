/**
 * 
 */
package com.privasia.scheduler.model;

import java.io.Serializable;

import com.privasia.scheduler.model.ContainerVisit.TosFlag;
import com.privasia.scss.common.enumusertype.GeneralEnumMapUserType;


/**
 * @author Hafiz Feroz
 *
 */
public class TideTypeEnum extends GeneralEnumMapUserType<TosFlag> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 *
	 */
	public TideTypeEnum() {
		super(TosFlag.class);
	}

}
