/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dao;

import com.admin.entities.Profil;
import javax.ejb.Local;


/**
 *
 * @author firok
 */
@Local
public interface ProfilDAOBeanLocal extends BaseDAOBeanLocal<Profil, Integer> {
    
}
