/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dao;

import com.admin.entities.ProfilMenuItem;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;


/**
 *
 * @author firok
 */
@Stateless
public class ProfilMenuItemDAOBean extends BaseDAOBean<ProfilMenuItem, Integer> implements ProfilMenuItemDAOBeanLocal {

    public ProfilMenuItemDAOBean() {
        super(ProfilMenuItem.class);
    }

    @Override
    public List<ProfilMenuItem> selectionnerListeProfilMenuItem(String profilId) {
        Query q = this.em.createQuery("SELECT p FROM ProfilMenuItem p WHERE p.profil.profilId=:profilId");
        q.setParameter("profilId", profilId);
        return q.getResultList();
    }
}
