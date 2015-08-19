package com.c2a.vie.entities;

import com.c2a.vie.entities.Contrat;
import com.c2a.vie.entities.Souscripteur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-16T11:49:13")
@StaticMetamodel(Assures.class)
public class Assures_ { 

    public static volatile SingularAttribute<Assures, Integer> ageassur;
    public static volatile SingularAttribute<Assures, Integer> codassure;
    public static volatile SingularAttribute<Assures, String> nomasusure;
    public static volatile SingularAttribute<Assures, String> telassure;
    public static volatile SingularAttribute<Assures, String> statutassur;
    public static volatile SingularAttribute<Assures, Souscripteur> codsous;
    public static volatile SingularAttribute<Assures, String> prenassure;
    public static volatile ListAttribute<Assures, Contrat> contratList;
    public static volatile SingularAttribute<Assures, Date> datnaisassure;

}