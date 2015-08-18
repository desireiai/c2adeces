/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.services;

import com.admin.dao.BaseDAOBeanLocal;
import com.admin.dao.TypeOperDAOBeanLocal;
import com.admin.entities.TypeOper;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author firok
 */
@Stateless
public class TypeOperServiceBean extends BaseServiceBean<TypeOper, String> implements TypeOperServiceBeanLocal {

    @EJB
    private TypeOperDAOBeanLocal typeOperDAO;
    
    
    @Override
    protected BaseDAOBeanLocal<TypeOper, String> getDAO() {
        return this.typeOperDAO;
    }

   

}
