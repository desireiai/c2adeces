/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.services;

import com.admin.dao.BaseDAOBeanLocal;
import com.admin.dao.SysLogDAOBeanLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.admin.entities.SysLog;

/**
 *
 * @author firok
 */
@Stateless
public class SysLogServiceBean extends BaseServiceBean<SysLog, Integer> implements SysLogServiceBeanLocal {

    
    @EJB
    private SysLogDAOBeanLocal sysLogDAO;
    
    @Override
    protected BaseDAOBeanLocal<SysLog, Integer> getDAO() {
       return this.sysLogDAO;
    }

    

}
