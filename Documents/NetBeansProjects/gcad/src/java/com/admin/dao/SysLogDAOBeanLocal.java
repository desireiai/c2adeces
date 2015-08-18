/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dao;

import javax.ejb.Local;
import com.admin.entities.SysLog;

/**
 *
 * @author firok
 */
@Local
public interface SysLogDAOBeanLocal extends BaseDAOBeanLocal<SysLog, Integer> {
    
}
