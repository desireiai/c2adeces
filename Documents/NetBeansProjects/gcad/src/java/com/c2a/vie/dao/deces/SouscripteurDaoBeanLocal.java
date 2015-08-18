package com.c2a.vie.dao.deces;

import com.c2a.vie.dao.BaseDaoBeanLocal;
import com.c2a.vie.entities.Souscripteur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface SouscripteurDaoBeanLocal extends BaseDaoBeanLocal<Souscripteur, Integer>{
    List<Souscripteur> souscripteurall();
    
}