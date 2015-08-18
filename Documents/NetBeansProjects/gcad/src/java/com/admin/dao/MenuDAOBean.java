/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dao;

import com.admin.entities.Menu;
import javax.ejb.Stateless;


/**
 *
 * @author firok
 */
@Stateless
public class MenuDAOBean extends BaseDAOBean<Menu,Integer> implements MenuDAOBeanLocal {

    public MenuDAOBean() {
        super(Menu.class);
    }

    

}
