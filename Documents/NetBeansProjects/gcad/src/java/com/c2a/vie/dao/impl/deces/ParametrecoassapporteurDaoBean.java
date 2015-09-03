/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2a.vie.dao.impl.deces;

import com.c2a.vie.dao.deces.ParametrecoassapporteurDaoBeanLocal;
import com.c2a.vie.dao.impl.BaseDaoBean;
import com.c2a.vie.entities.Apporteur;
import com.c2a.vie.entities.Parametrecoassapporteur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

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

    @Override
    public List<Parametrecoassapporteur> tauxparapporteur(Apporteur app) {
        Query q=this.em.createQuery("SELECT P FROM Parametrecoassapporteur P WHERE P.codeapp=:valeur");
        q.setParameter("valeur", app);
        return q.getResultList();
    }
}
