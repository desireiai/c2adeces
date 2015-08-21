package com.c2a.vie.managedbeans.deces;

import com.admin.entities.Profil;
import com.admin.services.ProfilServiceBeanLocal;
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
private Boolean desactiversuppr = true;
private String btnactiver="valider";
    private int index;
    
    @EJB
    private ProfilServiceBeanLocal profilService;
    private List<Profil> dataListProfil;
            
  
    
            
    /**
     * Creates a new instance of ProducteurManagedBean
     */
    public ProducteurManagedBean() {
     formProducteur = new Producteur();
     selectedProducteur = new Producteur();
    dataListProducteur = new ArrayList<Producteur>();
    btnactiver="valider";
    }
 public void enregistrer(){
        List<Producteur> list=producteurService.selectionnerTout();
        MessageBean m=new MessageBean();
        int i=0;
        if( formProducteur.getNomproducteur().trim().isEmpty() ||
                formProducteur.getPrenproducteur().trim().isEmpty() || formProducteur.getAdrproducteur().trim().isEmpty() || formProducteur.getTelproducteur().trim().isEmpty() ||
                formProducteur.getPosteproducteur().trim().isEmpty()){
            m.addMessageWarn("veuilllez renseigner les champs");
        }
        else{
            if(selectedProducteur != null){
                formProducteur.setStatutproducteur("actif");
           producteurService.modifier(formProducteur);
           btnactiver="valider";
           selectedProducteur=new Producteur();
           m.addMessageInfo("employe "+formProducteur.getUserPseudo()+" activé");
            
        }else{
                i = list.stream().filter((list1) -> (list1.getNomproducteur().equals(formProducteur.getNomproducteur()) && list1.getPrenproducteur().equals(formProducteur.getPrenproducteur())
                        && formProducteur.getPosteproducteur().equals(list1.getPosteproducteur()))).map((_item) -> 1).reduce(i, Integer::sum);
                      if(i==0){
            formProducteur.setStatutproducteur("actif");
            String password=formProducteur.getPrenproducteur().substring(0, 2)+formProducteur.getNomproducteur();
            formProducteur.setUserPassword(password);
           producteurService.ajouter(formProducteur);
            m.addMessageInfo("enregistré");
             this.desactiversuppr = true;
                              }
                              else{
                                  m.addMessageWarn("deja enregisrté");
                              }
        }
         formProducteur=new Producteur();
        this.desactiversuppr=true;
        }
        
        
    }
 public void reinitialiserall(){
     MessageBean m=new MessageBean();
     dataListProducteur.stream().map((dataListProducteur1) -> {
         dataListProducteur1.setUserPassword(dataListProducteur1.getPrenproducteur().substring(0, 2)+dataListProducteur1.getNomproducteur());
         return dataListProducteur1;
        }).forEach((dataListProducteur1) -> {
            producteurService.modifier(dataListProducteur1);
        });
     m.addMessageInfo(dataListProducteur.size()+" mot(s) de passe réinitiliasé(s)");
     selectedProducteur=new Producteur();
 }
     public void desactiver() {
     formProducteur.setStatutproducteur("inactif");
     producteurService.modifier(formProducteur);
      selectedProducteur=new Producteur();
      formProducteur=new Producteur();
      selectedProducteur=null;
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
    public void reinitialiser(){
        MessageBean m=new MessageBean();
        formProducteur.setUserPassword(formProducteur.getPrenproducteur().substring(0, 2)+formProducteur.getNomproducteur());
        producteurService.modifier(formProducteur);
    m.addMessageInfo("le mot de pase de "+formProducteur.getUserPseudo()+" a été bien réinitialisé");
        formProducteur=new Producteur();
        selectedProducteur=new Producteur();
         desactiversuppr=true;
    }

 public void rowSelected() {
        formProducteur = selectedProducteur;
        this.desactiverCode = true;
        this.index = this.dataListProducteur.indexOf(this.selectedProducteur);
        this.desactiversuppr = false;
        btnactiver="activer";
    } 
 public Producteur getFormProducteur() {
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
        dataListProducteur=producteurService.selectionnerTout();
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

    public ProducteurServiceBeanLocal getProducteurService() {
        return producteurService;
    }

    public void setProducteurService(ProducteurServiceBeanLocal producteurService) {
        this.producteurService = producteurService;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ProfilServiceBeanLocal getProfilService() {
        return profilService;
    }

    public void setProfilService(ProfilServiceBeanLocal profilService) {
        this.profilService = profilService;
    }

    public List<Profil> getDataListProfil() {
        return dataListProfil;
    }

    public void setDataListProfil(List<Profil> dataListProfil) {
        this.dataListProfil = dataListProfil;
    }

    public Boolean getDesactiversuppr() {
        return desactiversuppr;
    }

    public void setDesactiversuppr(Boolean desactiversuppr) {
        this.desactiversuppr = desactiversuppr;
    }

    public Boolean getDesactiverBoutonSuppr() {
        return desactiverBoutonSuppr;
    }

    public Boolean getDesactiverCode() {
        return desactiverCode;
    }

    public String getBtnactiver() {
        return btnactiver;
    }

    public void setBtnactiver(String btnactiver) {
        this.btnactiver = btnactiver;
    }
    
    
}
