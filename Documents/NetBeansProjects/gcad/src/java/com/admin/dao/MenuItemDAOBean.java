/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dao;

import com.admin.entities.MenuItem;
import javax.ejb.Stateless;


/**
 *
 * @author firok
 */
@Stateless
public class MenuItemDAOBean extends BaseDAOBean<MenuItem, Integer> implements MenuItemDAOBeanLocal {

    public MenuItemDAOBean() {
        super(MenuItem.class);
    }

    

}
