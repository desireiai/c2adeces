package com.c2a.vie.entities;

import com.c2a.vie.entities.Coassureurs;
import com.c2a.vie.entities.Contrat;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-16T11:49:13")
@StaticMetamodel(Coassurance.class)
public class Coassurance_ { 

    public static volatile SingularAttribute<Coassurance, Integer> idcoassur;
    public static volatile SingularAttribute<Coassurance, Coassureurs> codecoass;
    public static volatile SingularAttribute<Coassurance, Contrat> numpolice;
    public static volatile SingularAttribute<Coassurance, Double> tauxcoass;

}