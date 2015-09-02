/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2a.vie.dao.impl.deces;

import com.c2a.vie.dao.deces.ParametrecoassapporteurDaoBeanLocal;
import com.c2a.vie.dao.impl.BaseDaoBean;
import com.c2a.vie.entities.Parametrecoassapporteur;
import javax.ejb.Stateless;

/**
 *
 * @author desire.mensah
 */
@Stateless
public class ParametrecoassapporteurDaoBean extends BaseDaoBean<Parametrecoassapporteur, Integer> implements ParametrecoassapporteurDaoBeanLocal {

    public ParametrecoassapporteurDaoBean() {
        super(Parametrecoassapporteur.class);
    }

   

   
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
