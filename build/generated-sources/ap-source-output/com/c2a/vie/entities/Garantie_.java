package com.c2a.vie.entities;

import com.c2a.vie.entities.Contrat;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-16T11:49:13")
@StaticMetamodel(Garantie.class)
public class Garantie_ { 

    public static volatile SingularAttribute<Garantie, String> statutgarantie;
    public static volatile SingularAttribute<Garantie, Integer> idgarantie;
    public static volatile SingularAttribute<Garantie, String> libgarantie;
    public static volatile ListAttribute<Garantie, Contrat> contratList;

}