/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dao;

import com.admin.entities.Profil;
import javax.ejb.Stateless;


/**
 *
 * @author firok
 */
@Stateless
public class ProfilDAOBean extends BaseDAOBean<Profil, Integer> implements ProfilDAOBeanLocal {

    public ProfilDAOBean() {
        super(Profil.class);
    }


}
