package com.c2a.vie.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.c2a.vie.entities.Garantie;
import com.c2a.vie.entities.Typecontrat;
import com.c2a.vie.service.deces.GarantieServiceBeanLocal;
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
@ManagedBean(name = "garantieManagedBean")
@ViewScoped
public class GarantieManagedBean  implements Serializable{

    @EJB
    private GarantieServiceBeanLocal garantieService;
    private Garantie formGarantie = new Garantie();
    private Garantie selectedGarantie;
    private Boolean desactiversuppr=true;
    private List<Garantie> dataListGarantie;
private Boolean desactiverBoutonSuppr = true, desactiverCode;
    private int index;
    /**
     * Creates a new instance of GarantieManagedBean
     */
    public GarantieManagedBean() {
     formGarantie = new Garantie();
     selectedGarantie = new Garantie();
    dataListGarantie = new ArrayList<Garantie>();
    }
    
      private void gridloadDB(){
        selectedGarantie=null;
        try{
            dataListGarantie=garantieService.garantieall();
        }
        catch(Exception e){
            
            FacesContext.getCurrentInstance().addMessage("notification", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chargement échoué: ", e.getMessage()));
            Logger.getLogger(Typecontrat.class.getName()).log(Level.SEVERE, null, e);
        }
          FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chargement OK: ", dataListGarantie.size() + " enregistrements chargés. (timestamp = "+(new SimpleDateFormat("dd/MM/yy kk:mm:ss")).format(new Date())+")");
        FacesContext.getCurrentInstance().addMessage("notif", msg);
    }
    
    /**
     * Raffraîchit la grille depuis la BD
     */
    public void refreshGrid() {
        gridloadDB();
    }
    
    public void enregistrer(){
        List<Garantie> list=garantieService.garantieall();
        int i=0;
        MessageBean m=new MessageBean();
                
        if(selectedGarantie != null){
            garantieService.modifier(formGarantie);
        }else{
            i = list.stream().filter((list1) -> (list1.getLibgarantie().equals(formGarantie.getLibgarantie()))).map((_item) -> 1).reduce(i, Integer::sum);
            if(i==0){
                formGarantie.setStatutgarantie("actif");
                garantieService.ajouter(formGarantie); 
                m.addMessageInfo("enregistré");
            }
            else{
               m.addMessageWarn("garantie deja existante");
            }
           
        }
            formGarantie=new Garantie();
        this.desactiversuppr=true;
    }
    
    public void effacer(){
        formGarantie = new Garantie();
        selectedGarantie = null;
    }
    
    public void supprimer(){
        if(selectedGarantie != null){
            garantieService.supprimer(selectedGarantie);
        }
    }
    
         public void desactiver(){
        if(selectedGarantie!=null){
            selectedGarantie.setStatutgarantie("inactif");
            garantieService.modifier(selectedGarantie);
        }
        this.formGarantie=new Garantie();
    }

 public void rowSelected() {
        formGarantie = selectedGarantie;
        this.desactiverCode = true;
        this.index = this.dataListGarantie.indexOf(this.selectedGarantie);
     this.desactiversuppr=false;
    }
 public Garantie getFormGarantie() {
        return formGarantie;
    }

    public void setFormGarantie(Garantie formGarantie) {
        this.formGarantie = formGarantie;
    }

    public Garantie getSelectedGarantie() {
        return selectedGarantie;
    }

    public void setSelectedGarantie(Garantie selectedGarantie) {
        this.selectedGarantie = selectedGarantie;
    }

    public List<Garantie> getDataListGarantie() {
        dataListGarantie=garantieService.garantieall();
        return dataListGarantie;
    }

    public void setDataListGarantie(List<Garantie> dataListGarantie) {
        this.dataListGarantie = dataListGarantie;
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

    public GarantieServiceBeanLocal getGarantieService() {
        return garantieService;
    }

    public void setGarantieService(GarantieServiceBeanLocal garantieService) {
        this.garantieService = garantieService;
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
    
}
