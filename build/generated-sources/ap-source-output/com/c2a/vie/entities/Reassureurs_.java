package com.c2a.vie.entities;

import com.c2a.vie.entities.Reassurance;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-16T11:49:13")
@StaticMetamodel(Reassureurs.class)
public class Reassureurs_ { 

    public static volatile SingularAttribute<Reassureurs, String> statutreass;
    public static volatile SingularAttribute<Reassureurs, String> nomreass;
    public static volatile ListAttribute<Reassureurs, Reassurance> reassuranceList;
    public static volatile SingularAttribute<Reassureurs, String> categorireass;
    public static volatile SingularAttribute<Reassureurs, Integer> idreass;
    public static volatile SingularAttribute<Reassureurs, String> emailreass;
    public static volatile SingularAttribute<Reassureurs, String> telreass;
    public static volatile SingularAttribute<Reassureurs, String> adressreass;

}