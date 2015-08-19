package com.c2a.vie.entities;

import com.c2a.vie.entities.Apporteur;
import com.c2a.vie.entities.Assures;
import com.c2a.vie.entities.Coassurance;
import com.c2a.vie.entities.Dossiersinistre;
import com.c2a.vie.entities.Garantie;
import com.c2a.vie.entities.Groupe;
import com.c2a.vie.entities.Modepayement;
import com.c2a.vie.entities.Producteur;
import com.c2a.vie.entities.Reassurance;
import com.c2a.vie.entities.Typecontrat;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-16T11:49:13")
@StaticMetamodel(Contrat.class)
public class Contrat_ { 

    public static volatile SingularAttribute<Contrat, Integer> durecontrat;
    public static volatile SingularAttribute<Contrat, Date> datesaisie;
    public static volatile ListAttribute<Contrat, Dossiersinistre> dossiersinistreList;
    public static volatile SingularAttribute<Contrat, Garantie> idgarantie;
    public static volatile SingularAttribute<Contrat, Typecontrat> idtypecontrat;
    public static volatile SingularAttribute<Contrat, BigInteger> primres;
    public static volatile ListAttribute<Contrat, Reassurance> reassuranceList;
    public static volatile SingularAttribute<Contrat, BigInteger> capitgarantitotale;
    public static volatile SingularAttribute<Contrat, String> caracterecontrat;
    public static volatile SingularAttribute<Contrat, Double> tauxprime;
    public static volatile SingularAttribute<Contrat, Date> dateeffet;
    public static volatile ListAttribute<Contrat, Coassurance> coassuranceList;
    public static volatile SingularAttribute<Contrat, Producteur> idproducteur;
    public static volatile SingularAttribute<Contrat, Integer> numpolice;
    public static volatile SingularAttribute<Contrat, BigInteger> coutpiece;
    public static volatile SingularAttribute<Contrat, Double> tauxremise;
    public static volatile SingularAttribute<Contrat, Assures> codassure;
    public static volatile SingularAttribute<Contrat, Date> dateexp;
    public static volatile SingularAttribute<Contrat, Modepayement> idmodeayement;
    public static volatile SingularAttribute<Contrat, Groupe> idgroupe;
    public static volatile SingularAttribute<Contrat, Double> tauxsupprime;
    public static volatile SingularAttribute<Contrat, String> rapportmedical;
    public static volatile SingularAttribute<Contrat, Apporteur> codeapp;
    public static volatile SingularAttribute<Contrat, String> etatcontrat;
    public static volatile SingularAttribute<Contrat, BigInteger> primemontant;

}