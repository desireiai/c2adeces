package com.c2a.vie.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.c2a.vie.entities.Contrat;
import com.c2a.vie.service.deces.ContratServiceBeanLocal;
import java.util.ArrayList;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "contratManagedBean")
@ViewScoped
public class ContratManagedBean  implements Serializable{

    @EJB
    private ContratServiceBeanLocal contratService;
    private Contrat formContrat = new Contrat();
    private Contrat selectedContrat;
    private List<Contrat> dataListContrat;
private Boolean desactiverBoutonSuppr = true, desactiverCode;
    private int index;
    /**
     * Creates a new instance of ContratManagedBean
     */
    public ContratManagedBean() {
     formContrat = new Contrat();
     selectedContrat = new Contrat();
    dataListContrat = new ArrayList<Contrat>();
    }
    
    public void enregistrer(){
        if(selectedContrat != null){
            contratService.modifier(formContrat);
        }else{
            contratService.ajouter(formContrat);
        }
    }
    
    public void effacer(){
        formContrat = new Contrat();
        selectedContrat = null;
    }
    
    public void supprimer(){
        if(selectedContrat != null){
            contratService.supprimer(selectedContrat);
        }
    }

 public void rowSelected() {
        formContrat = selectedContrat;
        this.desactiverCode = true;
        this.index = this.dataListContrat.indexOf(this.selectedContrat);
        this.desactiverBoutonSuppr = false;
    }    public Contrat getFormContrat() {
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
