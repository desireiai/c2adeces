package com.c2a.vie.managedbeans.deces;

import com.c2a.vie.entities.Contrat;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.c2a.vie.entities.Reassurance;
import com.c2a.vie.entities.Typecontrat;
import com.c2a.vie.service.deces.ContratServiceBeanLocal;
import com.c2a.vie.service.deces.ReassuranceServiceBeanLocal;
import java.util.ArrayList;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "reassuranceManagedBean")
@ViewScoped
public class ReassuranceManagedBean  implements Serializable{

    @EJB
    private ReassuranceServiceBeanLocal reassuranceService;
    private Reassurance formReassurance = new Reassurance();
    private Reassurance selectedReassurance;
    private List<Reassurance> dataListReassurance;
    private Integer idtypecontratreass;
    private Double montantmaxi;
private Boolean desactiverBoutonSuppr = true, desactiverCode;

    @EJB
    private ContratServiceBeanLocal  contratService;
    private List<Contrat> reacontrat;
    private Contrat selectreassucontrat;
    private Typecontrat selecttypecontrat;
    private int index;
    /**
     * Creates a new instance of ReassuranceManagedBean
     */
    public ReassuranceManagedBean() {
     formReassurance = new Reassurance();
     selectedReassurance = new Reassurance();
    dataListReassurance = new ArrayList<Reassurance>();
    montantmaxi=0.0;
    }
    
    public void enregistrer(){
        if(selectedReassurance != null){
            reassuranceService.modifier(formReassurance);
        }else{
            reassuranceService.ajouter(formReassurance);
        }
    }
    
    public void executerreass(){
        MessageBean m=new MessageBean();
        try{
            idtypecontratreass=selecttypecontrat.getIdtypecontrat();
        reacontrat=contratService.contratreassurance(montantmaxi, idtypecontratreass);
         m.addMessage("cool");}
       
        catch(Exception e){
           m.addMessageWarn("erreur lors de l'execution");
        }
        
    }
    
    public void effacer(){
        formReassurance = new Reassurance();
        selectedReassurance = null;
    }
    
    public void supprimer(){
        if(selectedReassurance != null){
            reassuranceService.supprimer(selectedReassurance);
        }
    }

 public void rowSelected() {
        formReassurance = selectedReassurance;
        this.desactiverCode = true;
        this.index = this.dataListReassurance.indexOf(this.selectedReassurance);
        this.desactiverBoutonSuppr = false;
    }    public Reassurance getFormReassurance() {
        return formReassurance;
    }

    public void setFormReassurance(Reassurance formReassurance) {
        this.formReassurance = formReassurance;
    }

    public Reassurance getSelectedReassurance() {
        return selectedReassurance;
    }

    public void setSelectedReassurance(Reassurance selectedReassurance) {
        this.selectedReassurance = selectedReassurance;
    }

    public List<Reassurance> getDataListReassurance() {
        return dataListReassurance;
    }

    public void setDataListReassurance(List<Reassurance> dataListReassurance) {
        this.dataListReassurance = dataListReassurance;
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

    public ReassuranceServiceBeanLocal getReassuranceService() {
        return reassuranceService;
    }

    public void setReassuranceService(ReassuranceServiceBeanLocal reassuranceService) {
        this.reassuranceService = reassuranceService;
    }

    public ContratServiceBeanLocal getContratService() {
        return contratService;
    }

    public void setContratService(ContratServiceBeanLocal contratService) {
        this.contratService = contratService;
    }

    public List<Contrat> getReacontrat() {
        return reacontrat;
    }

    public void setReacontrat(List<Contrat> reacontrat) {
        this.reacontrat = reacontrat;
    }

    public Contrat getSelectreassucontrat() {
        return selectreassucontrat;
    }

    public void setSelectreassucontrat(Contrat selectreassucontrat) {
        this.selectreassucontrat = selectreassucontrat;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Integer getIdtypecontratreass() {
        return idtypecontratreass;
    }

    public void setIdtypecontratreass(Integer idtypecontratreass) {
        this.idtypecontratreass = idtypecontratreass;
    }

    public Double getMontantmaxi() {
        return montantmaxi;
    }

    public void setMontantmaxi(Double montantmaxi) {
        this.montantmaxi = montantmaxi;
    }

    public Typecontrat getSelecttypecontrat() {
        return selecttypecontrat;
    }

    public void setSelecttypecontrat(Typecontrat selecttypecontrat) {
        this.selecttypecontrat = selecttypecontrat;
    }
    
    
}
