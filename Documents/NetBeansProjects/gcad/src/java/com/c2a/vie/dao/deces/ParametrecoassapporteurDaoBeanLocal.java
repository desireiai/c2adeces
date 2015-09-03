/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2a.vie.dao.deces;

import com.c2a.vie.dao.BaseDaoBeanLocal;
import com.c2a.vie.entities.Apporteur;
import com.c2a.vie.entities.Parametrecoassapporteur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author desire.mensah
 */
@Local
public interface ParametrecoassapporteurDaoBeanLocal extends BaseDaoBeanLocal<Parametrecoassapporteur, Integer>{
    List<Parametrecoassapporteur> tauxparapporteur(Apporteur app);
    
}
