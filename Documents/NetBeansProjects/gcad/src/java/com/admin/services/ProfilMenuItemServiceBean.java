/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.services;

import com.admin.dao.BaseDAOBeanLocal;
import com.admin.dao.ProfilMenuItemDAOBeanLocal;
import com.admin.entities.ProfilMenuItem;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author firok
 */
@Stateless
public class ProfilMenuItemServiceBean extends BaseServiceBean<ProfilMenuItem, Integer> implements ProfilMenuItemServiceBeanLocal {

    @EJB
    private ProfilMenuItemDAOBeanLocal profilMenuItemDAO;
    
    @Override
    protected BaseDAOBeanLocal<ProfilMenuItem,Integer> getDAO() {
        return this.profilMenuItemDAO;
    }

    @Override
    public List<ProfilMenuItem> selectionnerListeProfilMenuItem(String profilId) {
        return this.profilMenuItemDAO.selectionnerListeProfilMenuItem(profilId);
    }

    

}
