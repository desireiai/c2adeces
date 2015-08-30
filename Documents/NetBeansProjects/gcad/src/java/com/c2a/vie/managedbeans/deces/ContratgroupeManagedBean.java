/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2a.vie.managedbeans.deces;

import com.c2a.vie.entities.Apporteur;
import com.c2a.vie.entities.Assures;
import com.c2a.vie.entities.Contrat;
import com.c2a.vie.entities.Groupe;
import com.c2a.vie.entities.Modepayement;
import com.c2a.vie.entities.Typecontrat;
import com.c2a.vie.service.deces.AssuresServiceBeanLocal;
import com.c2a.vie.service.deces.ContratServiceBeanLocal;
import com.c2a.vie.service.deces.GroupeServiceBeanLocal;
import com.c2a.vie.service.deces.TypecontratServiceBeanLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.joda.time.LocalDate;
import org.joda.time.Months;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/**
 *
 * @author desire.mensah
 */
@ManagedBean
@ViewScoped
public class ContratgroupeManagedBean  implements Serializable{

    @EJB
    private ContratServiceBeanLocal contratService;
    private Contrat formContrat = new Contrat();
    private Contrat selectedContrat;
    private List<Contrat> dataListContrat;
    private List<Contrat> datalistefiltre;
    private List<Contrat> datalistefiltreassurerech;
    private Contrat retirercontrat;
    private Date datesais = new Date();
    private Boolean desactiver = false;
    private Boolean nouveauactif = true;
    private List<Contrat> rnouvelmentcontrat;
    private Contrat selectrnouvelmentcontrat;
    private Contrat formrenvlmntcontrat;
    private List<Contrat> tamponcontrat = new ArrayList<>();
    private List<Contrat> policegrouprech;
    private List<Contrat> contratparassuregroupe;
    private Contrat selectpolicerech;
    private String selectoneradio;
    private Boolean desactiverenreg = false;
    private int index;
    private Groupe selresiliegroupe;

    @EJB
    private GroupeServiceBeanLocal groupeService;
    private Groupe selectgroup;
    private Groupe formgroupe;
    private List<Groupe> listgroupe;
    private Groupe selctrechgroupe;
    private int totalassure;
    private boolean readonly=true;
    @EJB
    private AssuresServiceBeanLocal assuresService;
    private Assures formassurepret;
    private List<Assures> listassurepret;
    private Assures selectassurepret;
   

    @EJB
    private TypecontratServiceBeanLocal typecontratService;
    private Typecontrat typecontrat;
    private List<Typecontrat> typecontrats;

    /**
     * Creates a new instance of Contratgroupe
     */
    public ContratgroupeManagedBean() {
        selectedContrat = new Contrat();
        dataListContrat = new ArrayList<Contrat>();
        formContrat.setDatesaisie(new Date());
        formContrat.setDurecontrat(0);
        formContrat = new Contrat();
        formassurepret = new Assures();
        listassurepret = new ArrayList<>();
        selectassurepret = new Assures();
        selectgroup = new Groupe();
        formrenvlmntcontrat = new Contrat();
        rnouvelmentcontrat = new ArrayList<>();
        formgroupe = new Groupe();
        formgroupe.setPrimegroup(0.0);
        formgroupe.setSituationgroup(0.0);
        formgroupe.setTauxremisegroupe(Float.valueOf(0));
        typecontrat = new Typecontrat();
        selectrnouvelmentcontrat = new Contrat();
        selectgroup.setPrimettcgroupe(0.0);
        desactiverenreg = false;
        formassurepret=new Assures();
        formassurepret.setAgeassur(0);
    
 

    }

    public void enregistrertampon() {
        MessageBean m = new MessageBean();
        List<Typecontrat> listtypec = new ArrayList<>();
        listtypec = typecontratService.typecontratall();
        int numpolicetampon = contratService.compter() + 1;
        if (formContrat.getTauxsupprime() == null) {
            formContrat.setTauxsupprime(Float.valueOf(0));
        }
        String error = null;
        
        for (Contrat test : tamponcontrat) {
            if (test.getIdgarantie().equals(formContrat.getIdgarantie())) {
                error = "deja enregistré";
            }
        }
        if (error != null) {
            m.addMessageWarn(error);
        } else {
            formContrat.setPolicestring("GPENT" + (numpolicetampon+tamponcontrat.size()) + formContrat.getCodeapp().getNomapp().substring(0, 3));
            formContrat.setPrimemontant(prime());
            formContrat.setDurecontrat(dureecontrat());
            tamponcontrat.add(formContrat);
            Groupe test1 = formContrat.getIdgroupe();
            Apporteur app = formContrat.getCodeapp();
            Modepayement modpaye = formContrat.getIdmodeayement();
            Date Date1 = formContrat.getDateeffet();
            Date Date2 = formContrat.getDateexp();
            int dure = formContrat.getDurecontrat();
            formContrat = new Contrat();
            formContrat.setIdgroupe(test1);
            formContrat.setCodeapp(app);
            formContrat.setIdmodeayement(modpaye);
            formContrat.setDateeffet(Date1);
            formContrat.setDateexp(Date2);
            formContrat.setDurecontrat(dure);
            desactiverenreg = true;

        }

        
    }
    public void retirer(){
     
            tamponcontrat.remove(retirercontrat);
        
    }
    public void enregistrercontrat(){
        MessageBean m=new MessageBean();
        String verif=null;
        Integer dur=dureecontrat();
        Integer idtypecontrat = null;
        List<Typecontrat> typecontrats=typecontratService.typecontratall();
       
 
                selectgroup=groupeService.selectionner(formContrat.getIdgroupe().getIdgroupe());

        for(Typecontrat type:typecontrats){
            if("groupe entreprise".equals(type.getLibtypecontrat())){
                idtypecontrat=type.getIdtypecontrat();
            }
        }
        Integer id = selectassurepret.getCodassure();
        
        for (Contrat tmp  : tamponcontrat) {
            tmp.setCodassure(assuresService.selectionner(id));
            tmp.setEtatcontrat("actif");
            tmp.setDurecontrat(dur);
            tmp.setPrimres(0.0);
            tmp.setCoutpiece(0.0);
            tmp.setCaracterecontrat("constante");
            tmp.setIdtypecontrat(typecontratService.selectionner(idtypecontrat));
            contratService.ajouter(tmp);
            verif="contrat de Mr(me) "+formassurepret.getNomasusure()+" enregistré"; 
       double primenettegrpe = selectgroup.getPrimegroup()+tmp.getPrimemontant();
        selectgroup.setPrimegroup(primenettegrpe);
        selectgroup.setPrimettcgroupe(0.0);
        selectgroup.setSituationgroup(0.0);
        groupeService.modifier(selectgroup);
        //tamponcontrat.clear();
            
        }
        if(verif!=null){
           m.addMessageInfo(verif);
        }
        else{
            m.addMessageWarn("erreur d'enregistrement");
        }
     tamponcontrat.clear();
    }

    public void nouveaucontrat() {
        formContrat = new Contrat();
        formassurepret = new Assures();
        selectassurepret = null;
        desactiverenreg=false;
    }
   

    public int ageassure() {
        Calendar calendar = new GregorianCalendar();
        LocalDate aujourdui = new LocalDate();
        calendar.setTime(selectassurepret.getDatnaisassure());
        int annee = calendar.get(Calendar.YEAR);
        int mois = calendar.get(Calendar.MONTH);
        int jours = calendar.get(Calendar.DAY_OF_MONTH);
        LocalDate naissance = new LocalDate(annee, mois, jours);
        Period p = new Period(naissance, aujourdui, PeriodType.yearMonthDay());
        return p.getYears();
    }

    public int ageassureren() {
        Calendar calendar = new GregorianCalendar();
        LocalDate aujourdui = new LocalDate();
        calendar.setTime(selectrnouvelmentcontrat.getCodassure().getDatnaisassure());
        int annee = calendar.get(Calendar.YEAR);
        int mois = calendar.get(Calendar.MONTH);
        int jours = calendar.get(Calendar.DAY_OF_MONTH);
        LocalDate naissance = new LocalDate(annee, mois, jours);
        Period p = new Period(naissance, aujourdui, PeriodType.yearMonthDay());
        return p.getYears();
    }

    public void enregistrerassure() {
        MessageBean m = new MessageBean();
        List<Assures> list = assuresService.assureall();
        int i = 0;
        if (formassurepret.getNomasusure().trim().isEmpty() || formassurepret.getPrenassure().trim().isEmpty() || formassurepret.getDatnaisassure() == null) {
            m.addMessageWarn("veuillez renseigner les champs");
        } else {
            if (formassurepret.getEmailassure().trim().isEmpty()) {
                formassurepret.setEmailassure("pas d'email");
            }
            if (formassurepret.getTelassure().trim().isEmpty()) {
                formassurepret.setTelassure("pas de telephone");
            }
            for (Assures list1 : list) {
                if (list1.getNomasusure().equals(formassurepret.getNomasusure()) && list1.getPrenassure().equals(formassurepret.getPrenassure()) && formassurepret.getDatnaisassure() == list1.getDatnaisassure()
                        && list1.getTelassure().equals(formassurepret.getTelassure())) {
                    i = i + 1;
                }
            }
            if (i == 0) {
                
                formassurepret.setTelassure("numero de la societe");
                formassurepret.setGentreprise("oui");
                formassurepret.setStatutassur("actif");
                assuresService.ajouter(formassurepret);
                listassurepret.add(0, formassurepret);
               formassurepret = new Assures();
            } else {
                m.addMessageWarn("assuré deja enregistré");

            }
        }

    }
  

    public int dureecontrat() {
        LocalDate dateeffet = new LocalDate(formContrat.getDateeffet().getTime());
        LocalDate datefin = new LocalDate(formContrat.getDateexp().getTime());
        return (Months.monthsBetween(dateeffet, datefin).getMonths());
    }

    public int dureecontratren() {
        LocalDate dateeffet = new LocalDate(formrenvlmntcontrat.getDateeffet().getTime());
        LocalDate datefin = new LocalDate(formrenvlmntcontrat.getDateexp().getTime());
        return (Months.monthsBetween(dateeffet, datefin).getMonths());
    }

    private double prime() {
        double capitini = formContrat.getCapitgarantitotale() / 100;
        float toprime = formContrat.getTauxprime();
        float tosupprime = 1 + formContrat.getTauxsupprime();
        double primetot = capitini * toprime * tosupprime;
        return primetot;
    }

    private double primeren() {
        double capitini = formrenvlmntcontrat.getCapitgarantitotale() / 100;
        float toprime = formrenvlmntcontrat.getTauxprime();
        float tosupprime = 1 + formrenvlmntcontrat.getTauxsupprime();
        double primetot = capitini * toprime * tosupprime;
        return primetot;
    }

    public void rowSelectedassure() {

        formassurepret = selectassurepret;
        this.index = this.listassurepret.indexOf(this.selectassurepret);
        this.desactiver = true;
        formassurepret.setAgeassur(ageassure());
    }

    public void rowselectedcontrate() {
        formgroupe = selectrnouvelmentcontrat.getIdgroupe();
        selectrnouvelmentcontrat.getCodassure().setAgeassur(ageassureren());
        formrenvlmntcontrat = selectrnouvelmentcontrat;
        this.index = this.rnouvelmentcontrat.indexOf(this.selectrnouvelmentcontrat);

    }

    public void rowselectcontratresilie() {
        selectrnouvelmentcontrat.getCodassure().setAgeassur(ageassureren());
        formrenvlmntcontrat = selectrnouvelmentcontrat;
        this.index = this.rnouvelmentcontrat.indexOf(this.selectrnouvelmentcontrat);
    }

    public void selectedgroupe() {
        rnouvelmentcontrat = contratService.assurecontratgroupe(formContrat.getIdgroupe());
    }

    public void renouveler() {
        MessageBean m = new MessageBean();
        formgroupe = groupeService.selectionner(formContrat.getIdgroupe().getIdgroupe());
        if (selectrnouvelmentcontrat != null) {
            formrenvlmntcontrat.setDurecontrat(dureecontratren());
            formrenvlmntcontrat.setPrimemontant(primeren());
            formrenvlmntcontrat.setPrimres(0.0);
            contratService.modifier(formrenvlmntcontrat);
            double primenettegrpe = formgroupe.getPrimegroup() + selectrnouvelmentcontrat.getPrimemontant();
            formgroupe.setPrimegroup(primenettegrpe);
            groupeService.modifier(formgroupe);
            m.addMessageInfo("contrat renouvelé");
        } else {
            m.addMessageWarn("erreur lors du renouvellement");
        }

    }

    public void calculgrouperen() {
        MessageBean m = new MessageBean();
        double ttc;
        double tot;
        double taxetot;
        double remise;
        int idtypecontrat;
        double accessoir = 0;
        float taxe = 0;
        typecontrats = new ArrayList<>();
        typecontrats = typecontratService.typecontratall();
        for (Typecontrat list : typecontrats) {
            if ("groupe entreprise".equals(list.getLibtypecontrat())) {
                idtypecontrat = list.getIdtypecontrat();
                accessoir = list.getAccessoires();
                taxe = list.getTaxe();
            }
        }
        if (formgroupe != null) {
            remise = (formgroupe.getTauxremisegroupe()/100) * formgroupe.getPrimegroup();
            tot = (formgroupe.getPrimegroup() + accessoir) - remise;
            taxetot = taxe / 100 * tot;
            ttc = tot + taxetot + formgroupe.getSituationgroup();
            formgroupe.setPrimettcgroupe(ttc);
            formgroupe.setSituationgroup(0.0);
            groupeService.modifier(formgroupe);
            m.addMessageInfo("contrats Groupe" + formgroupe.getLibgroupe() + "renouvelés avec succès");
        } else {
            m.addMessageWarn("erreur");
        }

    }

    public void calculgroupe() {
        MessageBean m = new MessageBean();
        double ttc;
        double tot;
        double taxetot;
        double remise;
        double accessoir = 0;
        float taxe = 0;
        typecontrats = new ArrayList<>();
        typecontrats = typecontratService.typecontratall();
        for (Typecontrat list : typecontrats) {
            if ("groupe entreprise".equals(list.getLibtypecontrat())) {
                accessoir = list.getAccessoires();
                taxe = list.getTaxe();
            }
        }
        if (selectgroup != null) {
            remise = selectgroup.getTauxremisegroupe()/100 * selectgroup.getPrimegroup();
            tot = (selectgroup.getPrimegroup() + accessoir) - remise;
            taxetot = taxe / 100 * tot;
            ttc = tot + taxetot + selectgroup.getSituationgroup();
            selectgroup.setPrimettcgroupe(ttc);
            groupeService.modifier(selectgroup);
            m.addMessageInfo("contrats Groupe   " + selectgroup.getLibgroupe() + "  enregistrés avec succès");
        } else {
            m.addMessageWarn("erreur");
        }

    }
      public  void  rowselectassurerech(){
          int i=0;
         this.policegrouprech=contratService.contratentreprise(selctrechgroupe.getIdgroupe());
          for (Contrat dataListContrat1 : policegrouprech) {
              i++;
          }
          totalassure=i;
     }
      public void resilier(){
          MessageBean m=new MessageBean();
          double primerind=0.0;
          int durecontrat=0;
          int durerestant=0;
          double montantristourne;
          primerind=formrenvlmntcontrat.getPrimemontant();
          durecontrat=formrenvlmntcontrat.getDurecontrat();
          durerestant=dureristourne();
             montantristourne=(primerind*durerestant)/durecontrat;
          formrenvlmntcontrat.setPrimres(montantristourne);
          formrenvlmntcontrat.setEtatcontrat("inactif");
          contratService.modifier(formrenvlmntcontrat);
          selresiliegroupe=groupeService.selectionner(formrenvlmntcontrat.getIdgroupe().getIdgroupe());
          selresiliegroupe.setSituationgroup(selresiliegroupe.getSituationgroup()-formrenvlmntcontrat.getPrimres());
          formrenvlmntcontrat.getIdgroupe().setSituationgroup(selresiliegroupe.getSituationgroup());
          groupeService.modifier(selresiliegroupe);
          m.addMessageInfo("contrat "+formrenvlmntcontrat.getIdgarantie().getLibgarantie()+" de Mr(me)"+formrenvlmntcontrat.getCodassure().getNomasusure()+"a été résilié");
      
        }
        public int  dureristourne(){
   
        LocalDate dateeffet=new LocalDate(new Date().getTime());
        LocalDate datefin=new LocalDate(formrenvlmntcontrat.getDateexp().getTime());
        return (Months.monthsBetween(dateeffet, datefin).getMonths());  

     }

    public ContratServiceBeanLocal getContratService() {
        return contratService;
    }

    public void setContratService(ContratServiceBeanLocal contratService) {
        this.contratService = contratService;
    }

    public Contrat getFormContrat() {
        return formContrat;
    }

    public void setFormContrat(Contrat formContrat) {
        this.formContrat = formContrat;
    }

    public Contrat getSelectedContrat() {
        return selectedContrat;
    }

    public void setSelectedContrat(Contrat selectedContrat) {
        this.selectedContrat = selectedContrat;
    }

    public List<Contrat> getDataListContrat() {
        dataListContrat = contratService.contratall();
        return dataListContrat;
    }

    public void setDataListContrat(List<Contrat> dataListContrat) {
        this.dataListContrat = dataListContrat;
    }

    public Date getDatesais() {
        datesais = new Date();
        return datesais;
    }

    public void setDatesais(Date datesais) {
        this.datesais = datesais;
    }

    public Boolean getDesactiver() {
        return desactiver;
    }

    public void setDesactiver(Boolean desactiver) {
        this.desactiver = desactiver;
    }

    public Boolean getNouveauactif() {
        return nouveauactif;
    }

    public void setNouveauactif(Boolean nouveauactif) {
        this.nouveauactif = nouveauactif;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public GroupeServiceBeanLocal getGroupeService() {
        return groupeService;
    }

    public void setGroupeService(GroupeServiceBeanLocal groupeService) {
        this.groupeService = groupeService;
    }

    public AssuresServiceBeanLocal getAssuresService() {
        return assuresService;
    }

    public void setAssuresService(AssuresServiceBeanLocal assuresService) {
        this.assuresService = assuresService;
    }

    public Assures getFormassurepret() {
        return formassurepret;
    }

    public void setFormassurepret(Assures formassurepret) {
        this.formassurepret = formassurepret;
    }

    public List<Assures> getListassurepret() {
        listassurepret = assuresService.assureentreprise();
        return listassurepret;
    }

    public void setListassurepret(List<Assures> listassurepret) {
        this.listassurepret = listassurepret;
    }

    public Assures getSelectassurepret() {
        return selectassurepret;
    }

    public void setSelectassurepret(Assures selectassurepret) {
        this.selectassurepret = selectassurepret;
    }

    public Groupe getSelectgroup() {
        return selectgroup;
    }

    public void setSelectgroup(Groupe selectgroup) {
        this.selectgroup = selectgroup;
    }

    public List<Contrat> getRnouvelmentcontrat() {
        rnouvelmentcontrat = contratService.assurecontratgroupe(formContrat.getIdgroupe());
        return rnouvelmentcontrat;
    }

    public void setRnouvelmentcontrat(List<Contrat> rnouvelmentcontrat) {

        this.rnouvelmentcontrat = rnouvelmentcontrat;
    }

    public Groupe getFormgroupe() {
        return formgroupe;
    }

    public void setFormgroupe(Groupe formgroupe) {
        this.formgroupe = formgroupe;
    }

    public Contrat getSelectrnouvelmentcontrat() {
        return selectrnouvelmentcontrat;
    }

    public void setSelectrnouvelmentcontrat(Contrat selectrnouvelmentcontrat) {
        this.selectrnouvelmentcontrat = selectrnouvelmentcontrat;
    }

    public Contrat getFormrenvlmntcontrat() {
        return formrenvlmntcontrat;
    }

    public void setFormrenvlmntcontrat(Contrat formrenvlmntcontrat) {
        this.formrenvlmntcontrat = formrenvlmntcontrat;
    }

    public TypecontratServiceBeanLocal getTypecontratService() {
        return typecontratService;
    }

    public void setTypecontratService(TypecontratServiceBeanLocal typecontratService) {
        this.typecontratService = typecontratService;
    }

    public Typecontrat getTypecontrat() {
        return typecontrat;
    }

    public void setTypecontrat(Typecontrat typecontrat) {
        this.typecontrat = typecontrat;
    }

    public List<Typecontrat> getTypecontrats() {
        typecontrats = typecontratService.typecontratall();
        return typecontrats;
    }

    public void setTypecontrats(List<Typecontrat> typecontrats) {
        this.typecontrats = typecontrats;
    }

    public String getSelectoneradio() {
        return selectoneradio;
    }

    public void setSelectoneradio(String selectoneradio) {
        this.selectoneradio = selectoneradio;
    }

    public List<Contrat> getDatalistefiltre() {
        return datalistefiltre;
    }

    public void setDatalistefiltre(List<Contrat> datalistefiltre) {
        this.datalistefiltre = datalistefiltre;
    }

    public List<Contrat> getTamponcontrat() {
        return tamponcontrat;
    }

    public void setTamponcontrat(List<Contrat> tamponcontrat) {
        this.tamponcontrat = tamponcontrat;
    }

    public Boolean getDesactiverenreg() {
        return desactiverenreg;
    }

    public void setDesactiverenreg(Boolean desactiverenreg) {
        this.desactiverenreg = desactiverenreg;
    }

    public Contrat getRetirercontrat() {
        return retirercontrat;
    }

    public void setRetirercontrat(Contrat retirercontrat) {
        this.retirercontrat = retirercontrat;
    }

    public List<Groupe> getListgroupe() {
        listgroupe=groupeService.groupeall();
        return listgroupe;
    }

    public void setListgroupe(List<Groupe> listgroupe) {
        this.listgroupe = listgroupe;
    }

    public Groupe getSelctrechgroupe() {
        return selctrechgroupe;
    }

    public void setSelctrechgroupe(Groupe selctrechgroupe) {
        this.selctrechgroupe = selctrechgroupe;
    }

    public List<Contrat> getPolicegrouprech() {
        return policegrouprech;
    }

    public void setPolicegrouprech(List<Contrat> policegrouprech) {
        this.policegrouprech = policegrouprech;
    }

    public Contrat getSelectpolicerech() {
        return selectpolicerech;
    }

    public void setSelectpolicerech(Contrat selectpolicerech) {
        this.selectpolicerech = selectpolicerech;
    }

    public List<Contrat> getDatalistefiltreassurerech() {
        return datalistefiltreassurerech;
    }

    public void setDatalistefiltreassurerech(List<Contrat> datalistefiltreassurerech) {
        this.datalistefiltreassurerech = datalistefiltreassurerech;
    }

    public int getTotalassure() {
       
        return totalassure;
    }

    public void setTotalassure(int totalassure) {
        this.totalassure = totalassure;
    }

    public boolean isReadonly() {
        return readonly;
    }

    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
    }

    public Groupe getSelresiliegroupe() {
        return selresiliegroupe;
    }

    public void setSelresiliegroupe(Groupe selresiliegroupe) {
        this.selresiliegroupe = selresiliegroupe;
    }

    public List<Contrat> getContratparassuregroupe() {
        return contratparassuregroupe;
    }

    public void setContratparassuregroupe(List<Contrat> contratparassuregroupe) {
        this.contratparassuregroupe = contratparassuregroupe;
    }


  
    
    
    
}
