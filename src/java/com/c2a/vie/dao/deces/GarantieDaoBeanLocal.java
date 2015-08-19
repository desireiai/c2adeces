package com.c2a.vie.dao.deces;

import com.c2a.vie.dao.BaseDaoBeanLocal;
import com.c2a.vie.entities.Garantie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface GarantieDaoBeanLocal extends BaseDaoBeanLocal<Garantie, Integer>{
    List<Garantie> garantieall();
    
}