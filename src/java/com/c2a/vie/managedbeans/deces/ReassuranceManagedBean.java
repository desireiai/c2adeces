package com.c2a.vie.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.c2a.vie.entities.Reassurance;
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
private Boolean desactiverBoutonSuppr = true, desactiverCode;
    private int index;
    /**
     * Creates a new instance of ReassuranceManagedBean
     */
    public ReassuranceManagedBean() {
     formReassurance = new Reassurance();
     selectedReassurance = new Reassurance();
    dataListReassurance = new ArrayList<Reassurance>();
    }
    
    public void enregistrer(){
        if(selectedReassurance != null){
            reassuranceService.modifier(formReassurance);
        }else{
            reassuranceService.ajouter(formReassurance);
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
}
