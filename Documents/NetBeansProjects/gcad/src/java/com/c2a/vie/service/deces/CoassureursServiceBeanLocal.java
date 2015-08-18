package com.c2a.vie.service.deces;

import javax.ejb.Local;
import com.c2a.vie.entities.Coassureurs;
import com.c2a.vie.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface CoassureursServiceBeanLocal extends BaseServiceBeanLocal<Coassureurs, Integer> {
    List<Coassureurs> coassureurall();
}