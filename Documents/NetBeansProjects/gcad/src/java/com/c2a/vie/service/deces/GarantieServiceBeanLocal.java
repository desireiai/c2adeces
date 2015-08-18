package com.c2a.vie.service.deces;

import javax.ejb.Local;
import com.c2a.vie.entities.Garantie;
import com.c2a.vie.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface GarantieServiceBeanLocal extends BaseServiceBeanLocal<Garantie, Integer> {
      List<Garantie> garantieall();
}