package com.c2a.vie.entities;

import com.c2a.vie.entities.Coassurance;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-16T11:49:13")
@StaticMetamodel(Coassureurs.class)
public class Coassureurs_ { 

    public static volatile SingularAttribute<Coassureurs, Integer> codecoass;
    public static volatile SingularAttribute<Coassureurs, String> nomcoass;
    public static volatile SingularAttribute<Coassureurs, String> emailcoass;
    public static volatile SingularAttribute<Coassureurs, String> telcoass;
    public static volatile SingularAttribute<Coassureurs, String> adressecoass;
    public static volatile SingularAttribute<Coassureurs, String> statutcoass;
    public static volatile ListAttribute<Coassureurs, Coassurance> coassuranceList;

}