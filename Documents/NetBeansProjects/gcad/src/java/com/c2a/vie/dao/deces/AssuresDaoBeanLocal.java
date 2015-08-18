package com.c2a.vie.dao.deces;

import com.c2a.vie.dao.BaseDaoBeanLocal;
import com.c2a.vie.entities.Assures;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface AssuresDaoBeanLocal extends BaseDaoBeanLocal<Assures, Integer>{
    List<Assures> assureall();
    List<Assures> assureentreprise();
    Integer moyenneage();
    List<Assures> assurepartypecontrat();
    
}