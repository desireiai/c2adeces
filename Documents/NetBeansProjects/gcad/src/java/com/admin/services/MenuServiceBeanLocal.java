/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.services;

import com.admin.entities.Menu;
import javax.ejb.Local;


/**
 *
 * @author firok
 */
@Local
public interface MenuServiceBeanLocal extends BaseServiceBeanLocal<Menu, Integer> {
    
}
