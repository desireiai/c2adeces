/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.services;

import javax.ejb.Local;
import com.admin.entities.SysLog;

/**
 *
 * @author firok
 */
@Local
public interface SysLogServiceBeanLocal extends BaseServiceBeanLocal<SysLog, Integer> {
    
}
