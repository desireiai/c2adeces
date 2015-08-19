package com.c2a.vie.entities;

import com.c2a.vie.entities.Contrat;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-16T11:49:13")
@StaticMetamodel(Dossiersinistre.class)
public class Dossiersinistre_ { 

    public static volatile SingularAttribute<Dossiersinistre, BigInteger> partcoass;
    public static volatile SingularAttribute<Dossiersinistre, Date> dateemisschec;
    public static volatile SingularAttribute<Dossiersinistre, Contrat> numpolice;
    public static volatile SingularAttribute<Dossiersinistre, Date> datedeclarsin;
    public static volatile SingularAttribute<Dossiersinistre, String> motifsin;
    public static volatile SingularAttribute<Dossiersinistre, Date> datedecessin;
    public static volatile SingularAttribute<Dossiersinistre, String> saisipar;
    public static volatile SingularAttribute<Dossiersinistre, Double> montantsin;
    public static volatile SingularAttribute<Dossiersinistre, BigInteger> partreass;
    public static volatile SingularAttribute<Dossiersinistre, Integer> numdossiersin;
    public static volatile SingularAttribute<Dossiersinistre, String> etatdossiersin;

}