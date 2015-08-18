package com.c2a.vie.dao.deces;

import com.c2a.vie.dao.BaseDaoBeanLocal;
import com.c2a.vie.entities.Typecontrat;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface TypecontratDaoBeanLocal extends BaseDaoBeanLocal<Typecontrat, Integer>{
    List<Typecontrat> typecontratall();
    List<Typecontrat> autretypecontrat();
}