/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.services;

import com.admin.dao.BaseDAOBeanLocal;
import com.admin.dao.MenuDAOBeanLocal;
import com.admin.entities.Menu;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author firok
 */
@Stateless
public class MenuServiceBean extends BaseServiceBean<Menu, Integer> implements MenuServiceBeanLocal {

    @EJB
    private MenuDAOBeanLocal menuDAO;
    
    @Override
    protected BaseDAOBeanLocal<Menu, Integer> getDAO() {
        return this.menuDAO;
    }

    

}
