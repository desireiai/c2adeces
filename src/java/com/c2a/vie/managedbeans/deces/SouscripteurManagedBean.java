package com.c2a.vie.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.c2a.vie.entities.Souscripteur;
import com.c2a.vie.service.deces.SouscripteurServiceBeanLocal;
import java.util.ArrayList;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "souscripteurManagedBean")
@ViewScoped
public class SouscripteurManagedBean  implements Serializable{

    @EJB
    private SouscripteurServiceBeanLocal souscripteurService;
    private Souscripteur formSouscripteur = new Souscripteur();
    private Souscripteur selectedSouscripteur;
    private List<Souscripteur> dataListSouscripteur;
private Boolean desactiverBoutonSuppr = true, desactiverCode;
    private int index;
    /**
     * Creates a new instance of SouscripteurManagedBean
     */
    public SouscripteurManagedBean() {
     formSouscripteur = new Souscripteur();
     selectedSouscripteur = new Souscripteur();
    dataListSouscripteur = new ArrayList<Souscripteur>();
    }
    
    public void enregistrer(){
        if(selectedSouscripteur != null){
            souscripteurService.modifier(formSouscripteur);
        }else{
            souscripteurService.ajouter(formSouscripteur);
        }
    }
    
    public void effacer(){
        formSouscripteur = new Souscripteur();
        selectedSouscripteur = null;
    }
    
    public void supprimer(){
        if(selectedSouscripteur != null){
            souscripteurService.supprimer(selectedSouscripteur);
        }
    }

 public void rowSelected() {
        formSouscripteur = selectedSouscripteur;
        this.desactiverCode = true;
        this.index = this.dataListSouscripteur.indexOf(this.selectedSouscripteur);
        this.desactiverBoutonSuppr = false;
    }    public Souscripteur getFormSouscripteur() {
        return formSouscripteur;
    }

    public void setFormSouscripteur(Souscripteur formSouscripteur) {
        this.formSouscripteur = formSouscripteur;
    }

    public Souscripteur getSelectedSouscripteur() {
        return selectedSouscripteur;
    }

    public void setSelectedSouscripteur(Souscripteur selectedSouscripteur) {
        this.selectedSouscripteur = selectedSouscripteur;
    }

    public List<Souscripteur> getDataListSouscripteur() {
        return dataListSouscripteur;
    }

    public void setDataListSouscripteur(List<Souscripteur> dataListSouscripteur) {
        this.dataListSouscripteur = dataListSouscripteur;
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
