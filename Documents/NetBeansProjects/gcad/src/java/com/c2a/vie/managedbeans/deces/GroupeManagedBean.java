package com.c2a.vie.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.c2a.vie.entities.Groupe;
import com.c2a.vie.entities.Typecontrat;
import com.c2a.vie.service.deces.GroupeServiceBeanLocal;
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
@ManagedBean(name = "groupeManagedBean")
@ViewScoped
public class GroupeManagedBean  implements Serializable{

    @EJB
    private GroupeServiceBeanLocal groupeService;
    private Groupe formGroupe = new Groupe();
    private Groupe selectedGroupe;
    private List<Groupe> dataListGroupe;
    
private Boolean desactiversuppr=true;
    private int index;
    /**
     * Creates a new instance of GroupeManagedBean
     */
    public GroupeManagedBean() {
     formGroupe = new Groupe();
     selectedGroupe = new Groupe();
    dataListGroupe = new ArrayList<Groupe>();
    }
    
      private void gridloadDB(){
        selectedGroupe=null;
        try{
            dataListGroupe=groupeService.groupeall();
        }
        catch(Exception e){
            
            FacesContext.getCurrentInstance().addMessage("notification", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chargement échoué: ", e.getMessage()));
            Logger.getLogger(Typecontrat.class.getName()).log(Level.SEVERE, null, e);
        }
          FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chargement OK: ", dataListGroupe.size() + " enregistrements chargés. (timestamp = "+(new SimpleDateFormat("dd/MM/yy kk:mm:ss")).format(new Date())+")");
        FacesContext.getCurrentInstance().addMessage("notif", msg);
    }
    
    /**
     * Raffraîchit la grille depuis la BD
     */
    public void refreshGrid() {
        
    }
        public void desactiver(){
        if(selectedGroupe!=null){
            selectedGroupe.setStatutgroup("inactif");
            groupeService.modifier(selectedGroupe);
        }
        this.formGroupe=new Groupe();
    }
    
    public void enregistrer(){
        MessageBean m=new MessageBean();
        int i=0;
        List<Groupe> list=groupeService.groupeall();
        if(formGroupe.getLibgroupe().trim().isEmpty() || formGroupe.getTelgroup().trim().isEmpty()){
            m.addMessageWarn("erreur verifier les champs");
        }
        else{
              if(selectedGroupe != null){
            groupeService.modifier(formGroupe);
            m.addMessageInfo("modifié");
            formGroupe=new Groupe();
            this.desactiversuppr=true;
        }else{
     i = list.stream().filter((list1) -> (list1.getLibgroupe().equals(formGroupe.getLibgroupe()))).map((_item) -> 1).reduce(i, Integer::sum);

                  if(i==0){
                      formGroupe.setPrimegroup(0.0);
            formGroupe.setPrimettcgroupe(0.0);
            formGroupe.setTauxremisegroupe(Float.valueOf(0));
            formGroupe.setSituationgroup(0.0);
            formGroupe.setStatutgroup("actif");
            groupeService.ajouter(formGroupe);
            m.addMessageInfo("enregistré");
            formGroupe=new Groupe();
            this.desactiversuppr=true;   
                  }
                  else{
                   m.addMessageWarn("deja enregistré");

                  }
            
        } 
        }
     
    }
    
    public void effacer(){
        formGroupe = new Groupe();
        selectedGroupe = null;
        selectedGroupe=new Groupe();
    }
    
    public void supprimer(){
        if(selectedGroupe != null){
            groupeService.supprimer(selectedGroupe);
        }
    }

 public void rowSelected() {
        formGroupe = selectedGroupe;
      this.index = this.dataListGroupe.indexOf(this.selectedGroupe);
        this.desactiversuppr=false;
    }
 public Groupe getFormGroupe() {
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
        dataListGroupe=groupeService.groupeall();
        return dataListGroupe;
    }

    public void setDataListGroupe(List<Groupe> dataListGroupe) {
        this.dataListGroupe = dataListGroupe;
    }

    public GroupeServiceBeanLocal getGroupeService() {
        return groupeService;
    }

    public void setGroupeService(GroupeServiceBeanLocal groupeService) {
        this.groupeService = groupeService;
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


