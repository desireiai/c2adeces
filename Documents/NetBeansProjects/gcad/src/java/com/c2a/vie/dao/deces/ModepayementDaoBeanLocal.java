package com.c2a.vie.dao.deces;

import com.c2a.vie.dao.BaseDaoBeanLocal;
import com.c2a.vie.entities.Modepayement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface ModepayementDaoBeanLocal extends BaseDaoBeanLocal<Modepayement, Integer>{
    List<Modepayement> listmodepayementall();
}