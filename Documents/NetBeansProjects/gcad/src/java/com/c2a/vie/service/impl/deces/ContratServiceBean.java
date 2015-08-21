package com.c2a.vie.service.impl.deces;

import com.c2a.vie.service.impl.BaseServiceBean;
import com.c2a.vie.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.c2a.vie.service.deces.ContratServiceBeanLocal;
import com.c2a.vie.dao.deces.ContratDaoBeanLocal;
import com.c2a.vie.entities.Contrat;
import com.c2a.vie.entities.Groupe;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Stateless
public class ContratServiceBean extends BaseServiceBean<Contrat,Integer> implements ContratServiceBeanLocal {

@EJB
private ContratDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Contrat, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public List<Contrat> contratall() {
return this.dao.contratall();
    }

    @Override
    public List<Contrat> contratentreprise() {
        return this.dao.contratentreprise();
    }

    @Override
    public List<Contrat> contratresilie() {
        return this.dao.contratresilie();
    }

    @Override
    public Double sommecapitale() {
        return this.dao.sommecapitale();
    }

    @Override
    public Double sommeprime() {
        return this.dao.sommeprime();
    }

    @Override
    public List<Contrat> assurecontratgroupe(Groupe gr) {
        return this.dao.assurecontratgroupe(gr);
    }

    @Override
    public List<Contrat> autregroupe() {
        return this.dao.autregroupe();
    }

    @Override
    public List<Contrat> autredetailcontrat(int i) {
        return this.dao.autredetailcontrat(i);
    }

    @Override
public List<Contrat> contratreassurance( double capit,int idtypecontrat)  {
        return this.dao.contratreassurance(capit, idtypecontrat);
    }

    @Override
    public List<Contrat> contratactif() {
        return this.dao.contratactif();
    }
    
}