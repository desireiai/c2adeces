package com.c2a.vie.entities;

import com.c2a.vie.entities.Assures;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-16T11:49:13")
@StaticMetamodel(Souscripteur.class)
public class Souscripteur_ { 

    public static volatile SingularAttribute<Souscripteur, String> prensous;
    public static volatile SingularAttribute<Souscripteur, String> adrsous;
    public static volatile SingularAttribute<Souscripteur, String> statutsous;
    public static volatile SingularAttribute<Souscripteur, Integer> codsous;
    public static volatile SingularAttribute<Souscripteur, String> nomsous;
    public static volatile SingularAttribute<Souscripteur, Date> datnaissous;
    public static volatile ListAttribute<Souscripteur, Assures> assuresList;

}