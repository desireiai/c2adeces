package com.c2a.vie.dao.deces;

import com.c2a.vie.dao.BaseDaoBeanLocal;
import com.c2a.vie.entities.Reassureurs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface ReassureursDaoBeanLocal extends BaseDaoBeanLocal<Reassureurs, Integer>{
    List<Reassureurs> reassureurall();
    
}