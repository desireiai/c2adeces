package com.c2a.vie.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.c2a.vie.entities.Groupe;
import com.c2a.vie.service.deces.GroupeServiceBeanLocal;
import java.util.ArrayList;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "groupeManagedBean")
@ViewScoped
public class GroupeManagedBean  implements Serializable{

    @EJB
    private GroupeServiceBeanLocal groupeService;
    private Groupe formGroupe = new Groupe();
    private Groupe selectedGroupe;
    private List<Groupe> dataListGroupe;
private Boolean desactiverBoutonSuppr = true, desactiverCode;
    private int index;
    /**
     * Creates a new instance of GroupeManagedBean
     */
    public GroupeManagedBean() {
     formGroupe = new Groupe();
     selectedGroupe = new Groupe();
    dataListGroupe = new ArrayList<Groupe>();
    }
    
    public void enregistrer(){
        if(selectedGroupe != null){
            groupeService.modifier(formGroupe);
        }else{
            groupeService.ajouter(formGroupe);
        }
    }
    
    public void effacer(){
        formGroupe = new Groupe();
        selectedGroupe = null;
    }
    
    public void supprimer(){
        if(selectedGroupe != null){
            groupeService.supprimer(selectedGroupe);
        }
    }

 public void rowSelected() {
        formGroupe = selectedGroupe;
        this.desactiverCode = true;
        this.index = this.dataListGroupe.indexOf(this.selectedGroupe);
        this.desactiverBoutonSuppr = false;
    }    public Groupe getFormGroupe() {
        return formGroupe;
    }

    public void setFormGroupe(Groupe formGroupe) {
        this.formGroupe = formGroupe;
    }

    public Groupe getSelectedGroupe() {
        return selectedGroupe;
    }

    public void setSelectedGroupe(Groupe selectedGroupe) {
        this.selectedGroupe = selectedGroupe;
    }

    public List<Groupe> getDataListGroupe() {
        return dataListGroupe;
    }

    public void setDataListGroupe(List<Groupe> dataListGroupe) {
        this.dataListGroupe = dataListGroupe;
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
