/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dao;

import com.admin.entities.MenuItem;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;


/**
 *
 * @author firok
 */
@Stateless
public class MenuItemDAOBean extends BaseDAOBean<MenuItem, Integer> implements MenuItemDAOBeanLocal {

    public MenuItemDAOBean() {
        super(MenuItem.class);
    }

    @Override
    public List<MenuItem> sousmenusdroit() {
        Query q=this.em.createQuery("SELECT s from MenuItem s WHERE s.active=:valeur AND s.filterField is null");
        q.setParameter("valeur", "actif");
        return q.getResultList();
    }

    

}
