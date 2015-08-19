package com.c2a.vie.entities;

import com.c2a.vie.entities.Contrat;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-16T11:49:13")
@StaticMetamodel(Typecontrat.class)
public class Typecontrat_ { 

    public static volatile SingularAttribute<Typecontrat, BigInteger> accessoires;
    public static volatile SingularAttribute<Typecontrat, String> libtypecontrat;
    public static volatile SingularAttribute<Typecontrat, Integer> idtypecontrat;
    public static volatile SingularAttribute<Typecontrat, String> statuttypecontrat;
    public static volatile ListAttribute<Typecontrat, Contrat> contratList;

}