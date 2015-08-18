
package com.c2a.vie.managedbeans.deces;

import com.c2a.vie.entities.Assures;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import com.c2a.vie.entities.Contrat;
import com.c2a.vie.service.deces.AssuresServiceBeanLocal;
import com.c2a.vie.service.deces.ContratServiceBeanLocal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.faces.bean.RequestScoped;
import org.joda.time.LocalDate;
import org.joda.time.Months;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "contratManagedBean")
@RequestScoped
public class ContratManagedBean implements Serializable {

    @EJB
    private ContratServiceBeanLocal contratService;
    private Contrat formContrat = new Contrat();
    private Contrat selectedContrat;
    private Contrat selectpolice;
    private Contrat formContratresilie;
    private List<Contrat> dataListContrat;
    private List<Contrat> contratautre;
    private List<Contrat> datalistfiltre;
    private List<Contrat> policelist;
    private List<Contrat> reasscontrat;
    private List<Contrat> contratactif;
    
    private Date datesais = new Date();
    private Boolean desactiver = false;
    private Boolean nouveauactif=true;
    private Boolean actifreference = false;
    private Float tauxpen;
    private int index;
    
    
    @EJB
    private AssuresServiceBeanLocal assuresService;
    private Assures formassurepret;
    private List<Assures> listassurepret;
    private List<Assures> assurerech;
    private List<Assures> filtrerechercheassure;
    private Assures selectrechassure;
    private Assures selectassurepret;
  

    public ContratManagedBean() {
        formContrat = new Contrat();
        formassurepret = new Assures();
        selectassurepret = new Assures();
        selectedContrat = new Contrat();
        dataListContrat = new ArrayList<Contrat>();
        policelist=new ArrayList<>();
        filtrerechercheassure=new ArrayList<>();
       selectrechassure=new Assures();
        reasscontrat=new ArrayList<>();
        formContrat.setDatesaisie(new Date());
        formContrat.setDurecontrat(0);
        formassurepret.setAgeassur(0);
        formContratresilie=new Contrat();
        formContratresilie.setTauxpenalite(Float.valueOf(0));
        formContratresilie.setPrimres(0.0);
        tauxpen=Float.valueOf(0);
        selectpolice=new Contrat();
        
       
    }
    public  void nouveaucontrat(){
        formContrat=new Contrat();
        formassurepret=new Assures();
        selectassurepret=null;
    }
    
   public int ageassure(){
     Calendar calendar = new GregorianCalendar();
     LocalDate aujourdui=new LocalDate();
     calendar.setTime(selectassurepret.getDatnaisassure());
     int annee=calendar.get(Calendar.YEAR);
     int mois=calendar.get(Calendar.MONTH);
     int jours=calendar.get(Calendar.DAY_OF_MONTH);
     LocalDate naissance=new LocalDate(annee, mois, jours);
     Period p=new  Period(naissance,aujourdui,PeriodType.yearMonthDay());
     return p.getYears();  
    }
   
    public void enregistrercontrat(){
        MessageBean m=new MessageBean();
        int id;       
        double accessoir=0.0;
        double taux=0.0;
        if(formContrat.getTauxsupprime()==null){
            
            formContrat.setTauxsupprime(Float.valueOf(0));
        }
        if(formContrat.getTauxremise()==null){
            formContrat.setTauxremise(Float.valueOf(0));
        }
        if(formContrat.getReferencepret()==null){
            formContrat.setReferencepret("pas de reference");
        }
        if(formContrat.getCapitgarantitotale().intValue()==0 || formContrat.getTauxprime().intValue()==0 || formContrat.getDateexp().toString().trim().isEmpty() || formContrat.getDateeffet().toString().trim().isEmpty() || formContrat.getIdtypecontrat()==null
                || formContrat.getCodeapp()==null || formContrat.getIdgarantie()==null || formContrat.getIdmodeayement()==null || formContrat.getCaracterecontrat().isEmpty() || formContrat.getRapportmedical().isEmpty()){
            m.addMessageWarn("veuillez verifier les champs");
        }
        else{
            if(formContrat.getDateeffet().getTime()>formContrat.getDateexp().getTime() || formContrat.getDateeffet().getTime()==formContrat.getDateexp().getTime() ){
                m.addMessageWarn("incompatibilité des dates du contrat");
            }
            else{
                if(formassurepret!=null){
      accessoir=formContrat.getIdtypecontrat().getAccessoires();
        taux=formContrat.getIdtypecontrat().getTaxe()/100*(prime()+accessoir);
        formContrat.setCoutpiece(0.0);
        formContrat.setEtatcontrat("actif");
        formContrat.setDurecontrat(dureecontrat());
        formContrat.setPrimemontant(prime());
        formContrat.setPrimeTTC(taux+accessoir+prime());
        formContrat.setPrimres(0.0);
        id=selectassurepret.getCodassure();
       formContrat.setCodassure(assuresService.selectionner(id));
       contratService.ajouter(formContrat);
       m.addMessageInfo("enregistré");}
        else{
            m.addMessageWarn("erreur");
        }  
            }
          
        }
        
    }
    public int dureecontrat(){
        LocalDate dateeffet=new LocalDate(formContrat.getDateeffet().getTime());
        LocalDate datefin=new LocalDate(formContrat.getDateexp().getTime());
       return (Months.monthsBetween(dateeffet, datefin).getMonths());  
    }
      
    private double prime(){
        double capitini =formContrat.getCapitgarantitotale()/100;
        float toprime=formContrat.getTauxprime();
        float tosupprime=1+formContrat.getTauxsupprime();
        float toremise =1-formContrat.getTauxremise();
        double primetot=capitini*toprime*tosupprime*toremise;
        return primetot;
    }
    public void activereference(){
        if("groupe pret".equals(formContrat.getIdtypecontrat().getLibtypecontrat())){
          this.actifreference=true;   
        }
        else{
            this.actifreference=false;
        }
       
    }
    
  
     public  void newassure(){
         formassurepret=new Assures();
         selectassurepret=null;
         this.desactiver=false;
     }
     public void rowSelectedassure() {
        formassurepret = selectassurepret;
        this.index = this.listassurepret.indexOf(this.selectassurepret);
         this.desactiver=true;
         formassurepret.setAgeassur(ageassure());
    }
     public  void rowselectresilier(){
         formContratresilie=selectedContrat;
         this.index=this.contratautre.indexOf(this.selectedContrat);
         
     }
     public void resilier(){
         int durecontrat;
         int dureristourne;
         float tauxcommi;
         float tauxremise;
         float tauxtaxe;
         double r1;
         double r2;
         double accessoir;
         double penalitemontant;
         double reduction;
         double montantaxe;
         double primeristourne;
         int idcontrat;
         idcontrat=selectedContrat.getNumpolice();
         formContratresilie=contratService.selectionner(idcontrat);
         durecontrat=formContratresilie.getDurecontrat();
         dureristourne=dureristourne();
         tauxcommi=(100-formContratresilie.getCodeapp().getCommissionapp())/100;
         tauxremise=formContratresilie.getTauxremise();
         r1=(formContratresilie.getPrimemontant()*tauxcommi*dureristourne)/durecontrat;
         penalitemontant=r1*(tauxpen/100);
         r2=r1-penalitemontant;
         reduction=r2*tauxremise;
         accessoir=formContratresilie.getIdtypecontrat().getAccessoires();
         tauxtaxe=formContratresilie.getIdtypecontrat().getTaxe()/100;
         montantaxe=((r2-reduction)+accessoir)*tauxtaxe;
         primeristourne=(r2-reduction-accessoir)+montantaxe;
         formContratresilie.setPrimres(primeristourne);  
         formContratresilie.setEtatcontrat("inactif");
         contratService.modifier(formContratresilie);
     }
     public int  dureristourne(){
   
        LocalDate dateeffet=new LocalDate(new Date().getTime());
        LocalDate datefin=new LocalDate(formContratresilie.getDateexp().getTime());
        return (Months.monthsBetween(dateeffet, datefin).getMonths());  

     }
     public  void  rowselectassurerech(){
         this.policelist=contratService.autredetailcontrat(selectrechassure.getCodassure());
     }
     
     public void charger(){
         
     }
             
     
       public void activenouveau(){
        this.nouveauactif=false;
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
        return dataListContrat;
    }

    public void setDataListContrat(List<Contrat> dataListContrat) {
        this.dataListContrat = dataListContrat;
    }

    public Date getDatesais() {
        datesais=new Date();
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Assures getFormassurepret() {
        return formassurepret;
    }

    public void setFormassurepret(Assures formassurepret) {
        this.formassurepret = formassurepret;
    }

    public List<Assures> getListassurepret() {
        listassurepret=assuresService.assureall();
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

    public AssuresServiceBeanLocal getAssuresService() {
        return assuresService;
    }

    public void setAssuresService(AssuresServiceBeanLocal assuresService) {
        this.assuresService = assuresService;
    }

    public Boolean getNouveauactif() {
        return nouveauactif;
    }

    public void setNouveauactif(Boolean nouveauactif) {
        this.nouveauactif = nouveauactif;
    }

    public List<Contrat> getContratautre() {
        contratautre=contratService.autregroupe();
        return contratautre;
    }

    public void setContratautre(List<Contrat> contratautre) {
        this.contratautre = contratautre;
    }

    public List<Contrat> getDatalistfiltre() {
        return datalistfiltre;
    }

    public void setDatalistfiltre(List<Contrat> datalistfiltre) {
        this.datalistfiltre = datalistfiltre;
    }

    public Contrat getFormContratresilie() {
        return formContratresilie;
    }

    public void setFormContratresilie(Contrat formContratresilie) {
        this.formContratresilie = formContratresilie;
    }

    public Float getTauxpen() {
        return tauxpen;
    }

    public void setTauxpen(Float tauxpen) {
        this.tauxpen = tauxpen;
    }

    public Boolean getActifreference() {
        return actifreference;
    }

    public void setActifreference(Boolean actifreference) {
        this.actifreference = actifreference;
    }

    public List<Contrat> getPolicelist() {
        return policelist;
    }

    public void setPolicelist(List<Contrat> policelist) {
      
        this.policelist = policelist;
    }

    public Contrat getSelectpolice() {
        return selectpolice;
    }

    public void setSelectpolice(Contrat selectpolice) {
        this.selectpolice = selectpolice;
    }


    public List<Contrat> getReasscontrat() {
        return reasscontrat;
    }

    public void setReasscontrat(List<Contrat> reasscontrat) {
        this.reasscontrat = reasscontrat;
    }

    public List<Assures> getAssurerech() {
        assurerech=assuresService.assurepartypecontrat();
        return assurerech;
    }

    public void setAssurerech(List<Assures> assurerech) {
        this.assurerech = assurerech;
    }

    public Assures getSelectrechassure() {
        return selectrechassure;
    }

    public void setSelectrechassure(Assures selectrechassure) {
        this.selectrechassure = selectrechassure;
    }

    public List<Assures> getFiltrerechercheassure() {
        return filtrerechercheassure;
    }

    public void setFiltrerechercheassure(List<Assures> filtrerechercheassure) {
        this.filtrerechercheassure = filtrerechercheassure;
    }

    public List<Contrat> getContratactif() {
        contratactif=contratService.contratactif();
        return contratactif;
    }

    public void setContratactif(List<Contrat> contratactif) {
        this.contratactif = contratactif;
    }
    
    
    
     /**
     * Creates a new instance of ContratManagedBean
     */
}
