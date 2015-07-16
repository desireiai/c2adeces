package com.c2a.vie.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.c2a.vie.entities.Coassureurs;
import com.c2a.vie.service.deces.CoassureursServiceBeanLocal;
import java.util.ArrayList;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "coassureursManagedBean")
@ViewScoped
public class CoassureursManagedBean  implements Serializable{

    @EJB
    private CoassureursServiceBeanLocal coassureursService;
    private Coassureurs formCoassureurs = new Coassureurs();
    private Coassureurs selectedCoassureurs;
    private List<Coassureurs> dataListCoassureurs;
private Boolean desactiverBoutonSuppr = true, desactiverCode;
    private int index;
    /**
     * Creates a new instance of CoassureursManagedBean
     */
    public CoassureursManagedBean() {
     formCoassureurs = new Coassureurs();
     selectedCoassureurs = new Coassureurs();
    dataListCoassureurs = new ArrayList<Coassureurs>();
    }
    
    public void enregistrer(){
        if(selectedCoassureurs != null){
            coassureursService.modifier(formCoassureurs);
        }else{
            coassureursService.ajouter(formCoassureurs);
        }
    }
    
    public void effacer(){
        formCoassureurs = new Coassureurs();
        selectedCoassureurs = null;
    }
    
    public void supprimer(){
        if(selectedCoassureurs != null){
            coassureursService.supprimer(selectedCoassureurs);
        }
    }

 public void rowSelected() {
        formCoassureurs = selectedCoassureurs;
        this.desactiverCode = true;
        this.index = this.dataListCoassureurs.indexOf(this.selectedCoassureurs);
        this.desactiverBoutonSuppr = false;
    }    public Coassureurs getFormCoassureurs() {
        return formCoassureurs;
    }

    public void setFormCoassureurs(Coassureurs formCoassureurs) {
        this.formCoassureurs = formCoassureurs;
    }

    public Coassureurs getSelectedCoassureurs() {
        return selectedCoassureurs;
    }

    public void setSelectedCoassureurs(Coassureurs selectedCoassureurs) {
        this.selectedCoassureurs = selectedCoassureurs;
    }

    public List<Coassureurs> getDataListCoassureurs() {
        return dataListCoassureurs;
    }

    public void setDataListCoassureurs(List<Coassureurs> dataListCoassureurs) {
        this.dataListCoassureurs = dataListCoassureurs;
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
