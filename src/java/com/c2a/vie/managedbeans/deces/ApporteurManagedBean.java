package com.c2a.vie.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.c2a.vie.entities.Apporteur;
import com.c2a.vie.entities.Typeapporteur;
import com.c2a.vie.entities.Typecontrat;
import com.c2a.vie.service.deces.ApporteurServiceBeanLocal;
import com.c2a.vie.service.deces.TypeapporteurServiceBeanLocal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "apporteurManagedBean")
@ViewScoped
public class ApporteurManagedBean  implements Serializable{

    @EJB
    private ApporteurServiceBeanLocal apporteurService;
    private Apporteur formApporteur = new Apporteur();
    private Apporteur selectedApporteur;
    private List<Apporteur> dataListApporteur;
 
    
    @EJB
    private TypeapporteurServiceBeanLocal typeapporteurService;
    private List<Typeapporteur> datalisttype;
 
    private Integer idtypeaporteur;
    
private String keyWord;   
private Boolean desactiversuppr = true, desactiverCode;
    private int index;
    /**
     * Creates a new instance of ApporteurManagedBean
     */
    public ApporteurManagedBean() {
     formApporteur = new Apporteur();
     selectedApporteur = new Apporteur();
    dataListApporteur = new ArrayList<Apporteur>();
    }
    public  void  init(){
        datalisttype=typeapporteurService.typeapporteurall();
    }
    
    
     public void search() {
        if (keyWord == null || keyWord.length() == 0) {
            FacesContext.getCurrentInstance().addMessage("notif", new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention: ", "Veuillez saisir un mot-clé à rechercher!"));
        } else {
            try {
                dataListApporteur = apporteurService.recherchenom(keyWord);
                FacesContext.getCurrentInstance().addMessage("notif", new FacesMessage(FacesMessage.SEVERITY_INFO, "Recherche Terminée: ", dataListApporteur.size() + " ligne(s) trouvée(s)."));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage("notif", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Recherche Echouée: ", e.getMessage()));
            }
        }
    }
    
         
    private void gridloadDB(){
        selectedApporteur=null;
        try{
            dataListApporteur=apporteurService.apporteurall();
            datalisttype=typeapporteurService.typeapporteurall();
            
          FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chargement OK: ", dataListApporteur.size() + " enregistrements chargés. (timestamp = "+(new SimpleDateFormat("dd/MM/yy kk:mm:ss")).format(new Date())+")");
          FacesContext.getCurrentInstance().addMessage("notif", msg);
        }
        catch(Exception e){
          FacesContext.getCurrentInstance().addMessage("notification", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chargement échoué: ", e.getMessage()));
            Logger.getLogger(Typecontrat.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Raffraîchit la grille depuis la BD
     */
    public void refreshGrid() {
        gridloadDB();
    }
    public void enregistrer(){
        if(selectedApporteur != null){
            apporteurService.modifier(formApporteur);
        }else{
            formApporteur.setIdtypeapporteur(typeapporteurService.selectionner(idtypeaporteur));
            formApporteur.setStatutapp("actif");
            formApporteur.setMontantapp(BigInteger.ZERO);
            apporteurService.ajouter(formApporteur);
             this.desactiversuppr = true;
        }
         formApporteur=new Apporteur();
        this.desactiversuppr=true;
    }
    
       public void desactiver(){
        if(selectedApporteur!=null){
            selectedApporteur.setStatutapp("inactif");
           apporteurService.modifier(selectedApporteur);
        }
        this.formApporteur=new Apporteur();
    }
    
    public void effacer(){
        formApporteur = new Apporteur();
        selectedApporteur = null;
    }
    
    public void supprimer(){
        if(selectedApporteur != null){
            apporteurService.supprimer(selectedApporteur);
        }
    }

 public void rowSelected() {
        formApporteur = selectedApporteur;
        this.desactiverCode = true;
        this.index = this.dataListApporteur.indexOf(this.selectedApporteur);
        this.desactiversuppr = false;
    }    public Apporteur getFormApporteur() {
        return formApporteur;
    }

    public void setFormApporteur(Apporteur formApporteur) {
        this.formApporteur = formApporteur;
    }

    public Apporteur getSelectedApporteur() {
        return selectedApporteur;
    }

    public void setSelectedApporteur(Apporteur selectedApporteur) {
        this.selectedApporteur = selectedApporteur;
    }

    public List<Apporteur> getDataListApporteur() {
        dataListApporteur=apporteurService.apporteurall();
        return dataListApporteur;
    }

    public void setDataListApporteur(List<Apporteur> dataListApporteur) {
        this.dataListApporteur = dataListApporteur;
    }

    public ApporteurServiceBeanLocal getApporteurService() {
        return apporteurService;
    }

    public void setApporteurService(ApporteurServiceBeanLocal apporteurService) {
        this.apporteurService = apporteurService;
    }

    public Boolean getDesactiversuppr() {
        return desactiversuppr;
    }

    public void setDesactiversuppr(Boolean desactiversuppr) {
        this.desactiversuppr = desactiversuppr;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    


    public Boolean isDesactiverCode() {
        return desactiverCode;
    }

    public void setDesactiverCode(Boolean desactiverCode) {
        this.desactiverCode = desactiverCode;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public TypeapporteurServiceBeanLocal getTypeapporteurService() {
        return typeapporteurService;
    }

    public void setTypeapporteurService(TypeapporteurServiceBeanLocal typeapporteurService) {
        this.typeapporteurService = typeapporteurService;
    }



    public Integer getIdtypeaporteur() {
        return idtypeaporteur;
    }

    public void setIdtypeaporteur(Integer idtypeaporteur) {
        this.idtypeaporteur = idtypeaporteur;
    }

    public List<Typeapporteur> getDatalisttype() {
        datalisttype=typeapporteurService.selectionnerTout();
        return datalisttype;
    }

    public void setDatalisttype(List<Typeapporteur> datalisttype) {
        this.datalisttype = datalisttype;
    }

  
    
    
    
}
