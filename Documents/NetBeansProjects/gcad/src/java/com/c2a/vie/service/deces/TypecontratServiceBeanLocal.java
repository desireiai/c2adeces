package com.c2a.vie.service.deces;

import javax.ejb.Local;
import com.c2a.vie.entities.Typecontrat;
import com.c2a.vie.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface TypecontratServiceBeanLocal extends BaseServiceBeanLocal<Typecontrat, Integer> {
    List<Typecontrat> typecontratall();
    List<Typecontrat> autretypecontrat();
}