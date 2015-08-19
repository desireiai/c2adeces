package com.c2a.vie.entities;

import com.c2a.vie.entities.Contrat;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-16T11:49:13")
@StaticMetamodel(Producteur.class)
public class Producteur_ { 

    public static volatile SingularAttribute<Producteur, Integer> idproducteur;
    public static volatile SingularAttribute<Producteur, String> telproducteur;
    public static volatile SingularAttribute<Producteur, String> prenproducteur;
    public static volatile SingularAttribute<Producteur, String> adrproducteur;
    public static volatile ListAttribute<Producteur, Contrat> contratList;
    public static volatile SingularAttribute<Producteur, String> nomproducteur;
    public static volatile SingularAttribute<Producteur, String> statutproducteur;

}