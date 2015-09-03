package com.c2a.vie.dao.deces;

import com.c2a.vie.dao.BaseDaoBeanLocal;
import com.c2a.vie.entities.Apporteur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface ApporteurDaoBeanLocal extends BaseDaoBeanLocal<Apporteur, Integer>{
    List<Apporteur> apporteurall();
    List<Apporteur> recherchenom(String nom);
    List<Apporteur> apporteurentreprise();
    
}