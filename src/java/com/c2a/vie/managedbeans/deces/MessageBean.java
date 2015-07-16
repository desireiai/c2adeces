package com.c2a.vie.managedbeans.deces;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public  class MessageBean implements Serializable{

// LES MESSAGES  DE CONFIRMATION DES ACTIONS EFFECTUEES     
    public void errorMessage(String summary) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erreur !", summary);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, msg);
        
    }
    
    public void addMessage(String summary) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès !", summary);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, msg);
        
    }
    
     public void addMessageWarn(String summary) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention !", summary);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, msg);
        
    }
     
      public void addMessageInfo(String summary) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info !", summary);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, msg);
        
    }
    
    public void modifMessage(String summary) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès !", summary);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, msg);
        
    }
    
    //CKEDITOR
    private String ckconfigPrint = "[['Preview','Print'],['Bold','Italic','Underline','-','RemoveFormat'],['Style','FontSize'],['Styles','Format']]";
    private String ckconfigCommment = "[['NewPage','Preview','-'],"
            + "['Cut','Copy','Paste','PasteText','PasteWord','-','Print','SpellCheck'],"
            + "['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],"
            + "['Bold','Italic','Underline','StrikeThrough','-','Subscript','Superscript'],"
            + "['OrderedList','UnorderedList','-','Outdent','Indent','Blockquote'],"
            + "['JustifyLeft','JustifyCenter','JustifyRight','JustifyFull'],"
            + "['Table','SpecialChar'],"
            + "['Style','FontFormat','FontName','FontSize']]";
    
    private String ckconfigLettre="[['NewPage','Preview','-'],"
            + "['Cut','Copy','Paste','PasteText','PasteWord','-','Print','SpellCheck'],"
            + "['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],"
            + "['Bold','Italic','Underline','StrikeThrough','-','Subscript','Superscript'],"
            + "['OrderedList','UnorderedList','-','Outdent','Indent','Blockquote'],"
            + "['JustifyLeft','JustifyCenter','JustifyRight','JustifyFull'],"
            + "['Style','FontSize'],"
            + "['Styles','Format'],['Bold','Italic','Strike','-','RemoveFormat'],"
            + "['Link','Unlink','Anchor'],"
            + "['Image','Table','Rule','Smiley','SpecialChar','PageBreak'],"            
            + "['TextColor','BGColor']]";
    
    //TEST DANS LES DATAMODEL POUR TELECHARGER DES FICHIERS LIES
    public boolean testTelecharger(String a){
        boolean n= true;        
        if(a.equalsIgnoreCase("") || a.equalsIgnoreCase(null) || a.isEmpty()){n= false;}
        if(a=="") {n= false;}        
        return n;
    }
    
    /** Creates a new instance of MessageCtrl */
    public MessageBean() {
    }
    
    public String openHelp(){
        
        return "vaSurLaide";
    }

    public String getCkconfigCommment() {
        return ckconfigCommment;
    }

    public String getCkconfigLettre() {
        return ckconfigLettre;
    }

    public String getCkconfigPrint() {
        return ckconfigPrint;
    }

    public void setCkconfigPrint(String ckconfigPrint) {
        this.ckconfigPrint = ckconfigPrint;
    }
    
    
}
