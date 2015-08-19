package com.c2a.vie.entities;

import com.c2a.vie.entities.Contrat;
import com.c2a.vie.entities.Reassureurs;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-16T11:49:13")
@StaticMetamodel(Reassurance.class)
public class Reassurance_ { 

    public static volatile SingularAttribute<Reassurance, Double> tauxcommisreas;
    public static volatile SingularAttribute<Reassurance, Contrat> numpolice;
    public static volatile SingularAttribute<Reassurance, Integer> idreassur;
    public static volatile SingularAttribute<Reassurance, Double> tauxreass;
    public static volatile SingularAttribute<Reassurance, Reassureurs> idreass;

}