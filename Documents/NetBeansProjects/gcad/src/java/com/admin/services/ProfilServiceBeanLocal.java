/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.services;

import com.admin.entities.Profil;
import javax.ejb.Local;


/**
 *
 * @author firok
 */
@Local
public interface ProfilServiceBeanLocal extends BaseServiceBeanLocal<Profil, Integer> {
    
}
