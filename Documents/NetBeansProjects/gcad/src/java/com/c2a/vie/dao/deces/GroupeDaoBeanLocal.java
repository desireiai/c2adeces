package com.c2a.vie.dao.deces;

import com.c2a.vie.dao.BaseDaoBeanLocal;
import com.c2a.vie.entities.Groupe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface GroupeDaoBeanLocal extends BaseDaoBeanLocal<Groupe, Integer>{
    List<Groupe> groupeall();
     
}