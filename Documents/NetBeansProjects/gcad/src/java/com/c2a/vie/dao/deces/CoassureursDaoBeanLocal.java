package com.c2a.vie.dao.deces;

import com.c2a.vie.dao.BaseDaoBeanLocal;
import com.c2a.vie.entities.Coassureurs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface CoassureursDaoBeanLocal extends BaseDaoBeanLocal<Coassureurs, Integer>{
    List<Coassureurs> coassureurall();
    
}