package com.c2a.vie.managedbeans.deces;

import com.c2a.vie.entities.Apporteur;
import com.c2a.vie.entities.Contrat;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.c2a.vie.entities.Dossiersinistre;
import com.c2a.vie.entities.Souscripteur;
import com.c2a.vie.entities.Typecontrat;
import com.c2a.vie.service.deces.ContratServiceBeanLocal;
import com.c2a.vie.service.deces.DossiersinistreServiceBeanLocal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "dossiersinistreManagedBean")
@ViewScoped
public class DossiersinistreManagedBean  implements Serializable{

    @EJB
    private DossiersinistreServiceBeanLocal dossiersinistreService;
    private Dossiersinistre formDossiersinistre = new Dossiersinistre();
    private Dossiersinistre selectedDossiersinistre;
    private List<Dossiersinistre> dataListDossiersinistre; 
    private List<Dossiersinistre> dossierTraité;
    private List<Dossiersinistre> filtre;
private Boolean desactiverBoutonSuppr = true, desactiverCode;
    private int index;
    private Date ojourdui = new Date();
    private Date ojourdui2 = new Date();
    
    @EJB
    private ContratServiceBeanLocal contratService;
    private List<Contrat> datalistecontrasinistre;
    private Integer idcontra;
    private Contrat selectccontrat;
    private Contrat formcontrat;
    private List<Contrat> datalistefiltre;
    private Boolean mtn = false;
    
    /**
     * Creates a new instance of DossiersinistreManagedBean
     */
    public DossiersinistreManagedBean() {
     formDossiersinistre = new Dossiersinistre();
     selectedDossiersinistre = new Dossiersinistre();
     formDossiersinistre.setDatedeclarsin(new Date());
    dataListDossiersinistre = new ArrayList<Dossiersinistre>();
    formcontrat = new  Contrat();
    selectccontrat = new Contrat();
    }
    
    public void gridload(){
        selectedDossiersinistre = null;
        try{
            dataListDossiersinistre = dossiersinistreService.dossiernontraite();
            
          FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chargement OK: ", dataListDossiersinistre.size() + " enregistrements chargés. (timestamp = "+(new SimpleDateFormat("dd/MM/yy kk:mm:ss")).format(new Date())+")");
          FacesContext.getCurrentInstance().addMessage("notif", msg);
           
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("notification", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chargement échoué: ", e.getMessage()));
            Logger.getLogger(Typecontrat.class.getName()).log(Level.SEVERE, null, e);
       
        }
    }
    
    public void enregistrer(){
         
        MessageBean m=new MessageBean();
       
     if( formDossiersinistre.getMotifsin().trim().isEmpty() ||
             formDossiersinistre.getMontantsin().intValue()==0 ){
          m.addMessageWarn("veuilllez renseigner les champs");
       }
       
      else{
         if(formDossiersinistre.getMontantsin()>formcontrat.getCapitgarantitotale()){
              m.addMessageWarn("le monttant doit être inférieur au capitale garentie");
         }
         else{
             if(formDossiersinistre.getDatedecessin().getTime()> ojourdui.getTime()){
                 m.addMessageWarn("la date décès doit être inférieur à la date du jour");
             }
         
         else{
         if(formcontrat!=null){
            formDossiersinistre.setEtatdossiersin("actif");
            formDossiersinistre.setNumpolice(formcontrat);         
            dossiersinistreService.ajouter(formDossiersinistre);
             m.addMessageInfo("dossier enregistré");
             formcontrat.setEtatcontrat("inactif");  
             contratService.modifier(formcontrat);
             formcontrat = new Contrat();
             formDossiersinistre.setMontantsin(0.0);
             formDossiersinistre.setMotifsin("");
                 }
         else{
                    m.addMessageInfo("erreur");  
                     }
             } 
         }
       }
    }
    
    public void mdifier(){
        MessageBean m = new MessageBean();
        if(selectedDossiersinistre.getDateemisschec().getTime()> ojourdui2.getTime()){
             m.addMessageWarn("la date démission de chèque doit être inférieur à la date du jour");
        }
        else{
        if(selectedDossiersinistre != null){ 
            dossiersinistreService.modifier(selectedDossiersinistre);
            m.addMessageInfo("effectué");
            formDossiersinistre=new Dossiersinistre();
            selectedDossiersinistre = null;  
        }
        }
    }
    
    public void montan(){
        if(formDossiersinistre.getNumpolice().getCaracterecontrat().equals("variable")){
            this.mtn=true;
        }
            else{
                    this.mtn=false;
                    }
    }
    
    public void effacer(){
        formDossiersinistre = new Dossiersinistre();
        selectedDossiersinistre = null;
        selectccontrat = null;
        formcontrat = new Contrat();
    }
    
    public void supprimer(){
        if(selectedDossiersinistre != null){
            dossiersinistreService.supprimer(selectedDossiersinistre);
        }
    }

 public void rowSelected() {
        formDossiersinistre = selectedDossiersinistre;
        this.desactiverCode = true;
        this.index = this.dataListDossiersinistre.indexOf(this.selectedDossiersinistre);
        this.desactiverBoutonSuppr = false;
         
    }    
 
 
 public void rowSelctedContrat(){
      formcontrat = selectccontrat;  
        this.index = this.datalistecontrasinistre.indexOf(this.selectccontrat);
        
        if(formcontrat.getCaracterecontrat().equals("variable")){
           this.mtn=false;
           formDossiersinistre.setMontantsin(0.0);
        }
       
        else{
            if(formcontrat.getCaracterecontrat().equals("constante")){
               formDossiersinistre.setMontantsin(formcontrat.getCapitgarantitotale());
               this.mtn=true;
           }
        }
       
    }

    public DossiersinistreServiceBeanLocal getDossiersinistreService() {
        return dossiersinistreService;
    }

    public Boolean getDesactiverBoutonSuppr() {
        return desactiverBoutonSuppr;
    }

    public Boolean getDesactiverCode() {
        return desactiverCode;
    }

    public int getIndex() {
        return index;
    }

    public Boolean getMtn() {
        return mtn;
    }

    public void setMtn(Boolean mtn) {
        this.mtn = mtn;
    }

    
    public ContratServiceBeanLocal getContratService() {
        return contratService;
    }

    public List<Contrat> getDatalistecontrasinistre() {
        datalistecontrasinistre = contratService.contratall();
        return datalistecontrasinistre;
    }

    public void setDossierTraité(List<Dossiersinistre> dossierTraité) {
        this.dossierTraité = dossierTraité;
    }

    public List<Dossiersinistre> getDossierTraité() {
        dossierTraité = dossiersinistreService.dossiertraite();
        return dossierTraité;
    }

    public void setDatalistefiltre(List<Contrat> datalistefiltre) {
        this.datalistefiltre = datalistefiltre;
    }

    public List<Contrat> getDatalistefiltre() {
        return datalistefiltre;
    }

    public Integer getIdcontra() {
        return idcontra;
    }

    public Contrat getSelectccontrat() {
        return selectccontrat;
    }

    public Contrat getFormcontrat() {
        return formcontrat;
    }

    public void setDossiersinistreService(DossiersinistreServiceBeanLocal dossiersinistreService) {
        this.dossiersinistreService = dossiersinistreService;
    }

    public void setFiltre(List<Dossiersinistre> filtre) {
        this.filtre = filtre;
    }

    public List<Dossiersinistre> getFiltre() {
        return filtre;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setContratService(ContratServiceBeanLocal contratService) {
        this.contratService = contratService;
    }

    public void setDatalistecontrasinistre(List<Contrat> datalistecontrasinistre) {
        this.datalistecontrasinistre = datalistecontrasinistre;
    }

    public void setIdcontra(Integer idcontra) {
        this.idcontra = idcontra;
    }

    public void setSelectccontrat(Contrat selectccontrat) {
        this.selectccontrat = selectccontrat;
    }

    public void setFormcontrat(Contrat formcontrat) {
        this.formcontrat = formcontrat;
    }
 
 
 
 public Dossiersinistre getFormDossiersinistre() {
        return formDossiersinistre;
    }

    public void setFormDossiersinistre(Dossiersinistre formDossiersinistre) {
        this.formDossiersinistre = formDossiersinistre;
    }

    public Dossiersinistre getSelectedDossiersinistre() {
        return selectedDossiersinistre;
    }

    public void setSelectedDossiersinistre(Dossiersinistre selectedDossiersinistre) {
        this.selectedDossiersinistre = selectedDossiersinistre;
    }

    public List<Dossiersinistre> getDataListDossiersinistre() {
        dataListDossiersinistre= dossiersinistreService.dossiernontraite();
         return dataListDossiersinistre;
    }

    public void setDataListDossiersinistre(List<Dossiersinistre> dataListDossiersinistre) {
        this.dataListDossiersinistre = dataListDossiersinistre;
    }
    
 public Boolean isDesactiverBoutonSuppr() {
        return desactiverBoutonSuppr;
    }

    public void setDesactiverBoutonSuppr(Boolean desactiverBoutonSuppr) {
        this.desactiverBoutonSuppr = desactiverBoutonSuppr;
    }

    public Boolean isDesactiverCode() {
        return desactiverCode;
    }

    public void setDesactiverCode(Boolean desactiverCode) {
        this.desactiverCode = desactiverCode;
    }
}
