/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2a.vie.service.impl.deces;

import com.c2a.vie.dao.BaseDaoBeanLocal;
import com.c2a.vie.dao.deces.ParametrecoassapporteurDaoBeanLocal;
import com.c2a.vie.entities.Parametrecoassapporteur;
import com.c2a.vie.service.deces.ParametrecoassapporteurServiceBeanLocal;
import com.c2a.vie.service.impl.BaseServiceBean;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author desire.mensah
 */
@Stateless
public class ParametrecoassapporteurServiceBean extends BaseServiceBean<Parametrecoassapporteur, Integer> implements ParametrecoassapporteurServiceBeanLocal {
     
    @EJB
    private ParametrecoassapporteurDaoBeanLocal dao;

    @Override
    protected BaseDaoBeanLocal<Parametrecoassapporteur, Integer> getDAO() {
        return this.dao;
    }



  
}
