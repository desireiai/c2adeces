package com.c2a.vie.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.c2a.vie.entities.Coassurance;
import com.c2a.vie.service.deces.CoassuranceServiceBeanLocal;
import java.util.ArrayList;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "coassuranceManagedBean")
@ViewScoped
public class CoassuranceManagedBean  implements Serializable{

    @EJB
    private CoassuranceServiceBeanLocal coassuranceService;
    private Coassurance formCoassurance = new Coassurance();
    private Coassurance selectedCoassurance;
    private List<Coassurance> dataListCoassurance;
private Boolean desactiverBoutonSuppr = true, desactiverCode;
    private int index;
    /**
     * Creates a new instance of CoassuranceManagedBean
     */
    public CoassuranceManagedBean() {
     formCoassurance = new Coassurance();
     selectedCoassurance = new Coassurance();
    dataListCoassurance = new ArrayList<Coassurance>();
    }
    
    public void enregistrer(){
        if(selectedCoassurance != null){
            coassuranceService.modifier(formCoassurance);
        }else{
            coassuranceService.ajouter(formCoassurance);
        }
    }
    
    public void effacer(){
        formCoassurance = new Coassurance();
        selectedCoassurance = null;
    }
    
    public void supprimer(){
        if(selectedCoassurance != null){
            coassuranceService.supprimer(selectedCoassurance);
        }
    }

 public void rowSelected() {
        formCoassurance = selectedCoassurance;
        this.desactiverCode = true;
        this.index = this.dataListCoassurance.indexOf(this.selectedCoassurance);
        this.desactiverBoutonSuppr = false;
    }    public Coassurance getFormCoassurance() {
        return formCoassurance;
    }

    public void setFormCoassurance(Coassurance formCoassurance) {
        this.formCoassurance = formCoassurance;
    }

    public Coassurance getSelectedCoassurance() {
        return selectedCoassurance;
    }

    public void setSelectedCoassurance(Coassurance selectedCoassurance) {
        this.selectedCoassurance = selectedCoassurance;
    }

    public List<Coassurance> getDataListCoassurance() {
        return dataListCoassurance;
    }

    public void setDataListCoassurance(List<Coassurance> dataListCoassurance) {
        this.dataListCoassurance = dataListCoassurance;
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
