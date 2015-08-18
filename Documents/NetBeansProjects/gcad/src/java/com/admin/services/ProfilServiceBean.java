/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.services;

import com.admin.dao.BaseDAOBeanLocal;
import com.admin.dao.ProfilDAOBeanLocal;
import com.admin.entities.Profil;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author firok
 */
@Stateless
public class ProfilServiceBean extends BaseServiceBean<Profil, Integer> implements ProfilServiceBeanLocal {

    
    @EJB
    private ProfilDAOBeanLocal profilDAO;
    
    @Override
    protected BaseDAOBeanLocal<Profil, Integer> getDAO() {
        return this.profilDAO;
    }

    

}
