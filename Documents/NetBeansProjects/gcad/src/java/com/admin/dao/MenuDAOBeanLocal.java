/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dao;

import com.admin.entities.Menu;
import javax.ejb.Local;


/**
 *
 * @author firok
 */
@Local
public interface MenuDAOBeanLocal extends BaseDAOBeanLocal<Menu, Integer> {
    
}
