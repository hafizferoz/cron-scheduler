/**
 * 
 */
package com.privasia.scheduler.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.privasia.scheduler.util.DateUtil;




/**
 * @author Hafiz Feroz
 *
 */
@Component("cbasCurrentDateTimeService")
public class CurrentDateTimeService {

  public LocalDateTime getCurrentDateAndTime() {
    return LocalDateTime.now();
  }

  public String getFormattedCurrentDateAndTime() {
    return DateUtil.getFormatteDateTime(LocalDateTime.now());
  }

}
