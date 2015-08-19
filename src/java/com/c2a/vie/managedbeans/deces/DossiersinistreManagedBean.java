package com.c2a.vie.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.c2a.vie.entities.Dossiersinistre;
import com.c2a.vie.service.deces.DossiersinistreServiceBeanLocal;
import java.util.ArrayList;

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
private Boolean desactiverBoutonSuppr = true, desactiverCode;
    private int index;
    /**
     * Creates a new instance of DossiersinistreManagedBean
     */
    public DossiersinistreManagedBean() {
     formDossiersinistre = new Dossiersinistre();
     selectedDossiersinistre = new Dossiersinistre();
    dataListDossiersinistre = new ArrayList<Dossiersinistre>();
    }
    
    public void enregistrer(){
        if(selectedDossiersinistre != null){
            dossiersinistreService.modifier(formDossiersinistre);
        }else{
            dossiersinistreService.ajouter(formDossiersinistre);
        }
    }
    
    public void effacer(){
        formDossiersinistre = new Dossiersinistre();
        selectedDossiersinistre = null;
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
    }    public Dossiersinistre getFormDossiersinistre() {
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
