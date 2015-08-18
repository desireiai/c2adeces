/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dao;

import javax.ejb.Stateless;
import com.admin.entities.SysLog;

/**
 *
 * @author firok
 */
@Stateless
public class SysLogDAOBean extends BaseDAOBean<SysLog, Integer> implements SysLogDAOBeanLocal {

    public SysLogDAOBean() {
        super(SysLog.class);
    }

    

}
