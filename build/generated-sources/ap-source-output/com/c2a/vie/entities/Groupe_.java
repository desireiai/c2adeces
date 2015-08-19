package com.c2a.vie.entities;

import com.c2a.vie.entities.Contrat;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-16T11:49:13")
@StaticMetamodel(Groupe.class)
public class Groupe_ { 

    public static volatile SingularAttribute<Groupe, String> libgroupe;
    public static volatile SingularAttribute<Groupe, BigInteger> primegroup;
    public static volatile SingularAttribute<Groupe, Integer> idgroupe;
    public static volatile SingularAttribute<Groupe, String> statutgroup;
    public static volatile ListAttribute<Groupe, Contrat> contratList;
    public static volatile SingularAttribute<Groupe, BigInteger> situationgroup;
    public static volatile SingularAttribute<Groupe, String> telgroup;

}