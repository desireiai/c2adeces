package com.c2a.vie.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author  K.M.A.
 * @param <T>
 * @param <K>
 */
@Local
public interface BaseDaoBeanLocal<T extends Serializable, K> {
  
    List<T>  selectionnerTout();
    
    T selectionner(K k);
    
    void ajouter(final T t);
    
    void modifier(final T t);
    
    void supprimer(final K k);
    
    void supprimer(final T t);
    
    void supprimerTout();
    
    int compter();
    
    void ajouter(final Collection<T> ts);
    
    T selectionner(String propriete,String valeur);
    
    T selectionmigrer(String id,String prop,String val);
    
    T selectionMirgerIt(String id,String prop,Integer val);
   
    List<T> selectionnerParLettre(String propriete);
    
    List<T> selectionnerTouts(String objet,String propriete,String valeur);
    
    List<T> selectionnerToutregle(String objet,String propriete,float valeur);
    
    List<T> selectionnerrecherche(String propriete,String valeur);
}
