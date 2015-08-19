/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.services;

import com.admin.entities.ProfilMenuItem;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author firok
 */
@Local
public interface ProfilMenuItemServiceBeanLocal extends BaseServiceBeanLocal<ProfilMenuItem, Integer> {
    List<ProfilMenuItem> selectionnerListeProfilMenuItem(String profilId);
}
