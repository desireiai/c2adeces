package com.c2a.vie.service.deces;

import javax.ejb.Local;
import com.c2a.vie.entities.Contrat;
import com.c2a.vie.entities.Groupe;
import com.c2a.vie.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface ContratServiceBeanLocal extends BaseServiceBeanLocal<Contrat, Integer> {
      List<Contrat> contratall();
    List<Contrat> contratentreprise();
    List<Contrat> contratresilie();
     List<Contrat> assurecontratgroupe(Groupe gr);
     List<Contrat> autregroupe();
     List<Contrat> autredetailcontrat(int i);
     List<Contrat> contratentreprise(int i);
     public List<Contrat> contratreassurance( double capit,int idtypecontrat) ;
     List<Contrat> contratactif();
    Double sommecapitale();
    Double sommeprime();
}