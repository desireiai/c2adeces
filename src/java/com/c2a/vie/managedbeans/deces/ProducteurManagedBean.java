package com.c2a.vie.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.c2a.vie.entities.Producteur;
import com.c2a.vie.service.deces.ProducteurServiceBeanLocal;
import java.util.ArrayList;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "producteurManagedBean")
@ViewScoped
public class ProducteurManagedBean  implements Serializable{

    @EJB
    private ProducteurServiceBeanLocal producteurService;
    private Producteur formProducteur = new Producteur();
    private Producteur selectedProducteur;
    private List<Producteur> dataListProducteur;
private Boolean desactiverBoutonSuppr = true, desactiverCode;
    private int index;
    /**
     * Creates a new instance of ProducteurManagedBean
     */
    public ProducteurManagedBean() {
     formProducteur = new Producteur();
     selectedProducteur = new Producteur();
    dataListProducteur = new ArrayList<Producteur>();
    }
    
    public void enregistrer(){
        if(selectedProducteur != null){
            producteurService.modifier(formProducteur);
        }else{
            producteurService.ajouter(formProducteur);
        }
    }
    
    public void effacer(){
        formProducteur = new Producteur();
        selectedProducteur = null;
    }
    
    public void supprimer(){
        if(selectedProducteur != null){
            producteurService.supprimer(selectedProducteur);
        }
    }

 public void rowSelected() {
        formProducteur = selectedProducteur;
        this.desactiverCode = true;
        this.index = this.dataListProducteur.indexOf(this.selectedProducteur);
        this.desactiverBoutonSuppr = false;
    }    public Producteur getFormProducteur() {
        return formProducteur;
    }

    public void setFormProducteur(Producteur formProducteur) {
        this.formProducteur = formProducteur;
    }

    public Producteur getSelectedProducteur() {
        return selectedProducteur;
    }

    public void setSelectedProducteur(Producteur selectedProducteur) {
        this.selectedProducteur = selectedProducteur;
    }

    public List<Producteur> getDataListProducteur() {
        return dataListProducteur;
    }

    public void setDataListProducteur(List<Producteur> dataListProducteur) {
        this.dataListProducteur = dataListProducteur;
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
