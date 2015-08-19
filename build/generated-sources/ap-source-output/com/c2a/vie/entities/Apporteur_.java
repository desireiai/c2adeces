package com.c2a.vie.entities;

import com.c2a.vie.entities.Contrat;
import com.c2a.vie.entities.Typeapporteur;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-16T11:49:13")
@StaticMetamodel(Apporteur.class)
public class Apporteur_ { 

    public static volatile SingularAttribute<Apporteur, String> nomapp;
    public static volatile SingularAttribute<Apporteur, String> telapp;
    public static volatile SingularAttribute<Apporteur, String> statutapp;
    public static volatile SingularAttribute<Apporteur, Integer> codeapp;
    public static volatile SingularAttribute<Apporteur, String> adresseapp;
    public static volatile SingularAttribute<Apporteur, Typeapporteur> idtypeapporteur;
    public static volatile SingularAttribute<Apporteur, BigInteger> montantapp;
    public static volatile ListAttribute<Apporteur, Contrat> contratList;
    public static volatile SingularAttribute<Apporteur, Double> commissionapp;

}