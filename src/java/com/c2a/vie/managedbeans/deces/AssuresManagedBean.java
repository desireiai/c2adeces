package com.c2a.vie.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.c2a.vie.entities.Assures;
import com.c2a.vie.service.deces.AssuresServiceBeanLocal;
import java.util.ArrayList;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "assuresManagedBean")
@ViewScoped
public class AssuresManagedBean  implements Serializable{

    @EJB
    private AssuresServiceBeanLocal assuresService;
    private Assures formAssures = new Assures();
    private Assures selectedAssures;
    private List<Assures> dataListAssures;
private Boolean desactiverBoutonSuppr = true, desactiverCode;
    private int index;
    /**
     * Creates a new instance of AssuresManagedBean
     */
    public AssuresManagedBean() {
     formAssures = new Assures();
     selectedAssures = new Assures();
    dataListAssures = new ArrayList<Assures>();
    }
    
    public void enregistrer(){
        if(selectedAssures != null){
            assuresService.modifier(formAssures);
        }else{
            assuresService.ajouter(formAssures);
        }
    }
    
    public void effacer(){
        formAssures = new Assures();
        selectedAssures = null;
    }
    
    public void supprimer(){
        if(selectedAssures != null){
            assuresService.supprimer(selectedAssures);
        }
    }

 public void rowSelected() {
        formAssures = selectedAssures;
        this.desactiverCode = true;
        this.index = this.dataListAssures.indexOf(this.selectedAssures);
        this.desactiverBoutonSuppr = false;
    }    public Assures getFormAssures() {
        return formAssures;
    }

    public void setFormAssures(Assures formAssures) {
        this.formAssures = formAssures;
    }

    public Assures getSelectedAssures() {
        return selectedAssures;
    }

    public void setSelectedAssures(Assures selectedAssures) {
        this.selectedAssures = selectedAssures;
    }

    public List<Assures> getDataListAssures() {
        return dataListAssures;
    }

    public void setDataListAssures(List<Assures> dataListAssures) {
        this.dataListAssures = dataListAssures;
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
