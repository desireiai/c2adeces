/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dao;

import com.admin.entities.ProfilMenuItem;
import java.util.List;
import javax.ejb.Local;


/**
 *
 * @author firok
 */
@Local
public interface ProfilMenuItemDAOBeanLocal extends BaseDAOBeanLocal<ProfilMenuItem, Integer> {
    
    List<ProfilMenuItem> selectionnerListeProfilMenuItem(String profilId);
}
