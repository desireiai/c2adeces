/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2a.vie.managedbeans.deces;

import com.c2a.vie.entities.Contrat;
import com.c2a.vie.service.deces.ContratServiceBeanLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author desire.mensah
 */
@ManagedBean
@ViewScoped
public class ListecontratManageadBean implements Serializable{
    @EJB
    private ContratServiceBeanLocal  contratService;
    private List<Contrat> contratactifs;
    private List<Contrat> contratresilie;
    private List<Contrat> contratexpire;
    private Contrat selectContratactif;
    private Contrat formContratactif;
    private Contrat selectContratresilie;
    private Contrat formContratresilie;
    private Contrat selectContratexpire;
    private Contrat formContratexpire;
    private Date datedebut;
    private Date datefin;
    
    
    
    public ListecontratManageadBean() {
        selectContratactif=new Contrat();
        selectContratexpire=new Contrat();
        formContratexpire=new Contrat();
        contratexpire=new ArrayList<>();
        formContratresilie=new Contrat();
        contratresilie=new ArrayList<>();
        selectContratresilie=new Contrat();
        contratactifs=new ArrayList<>();
        formContratactif=new Contrat();
        selectContratactif.setTauxremise(Float.valueOf(0));
        
    }
    @PostConstruct
    public void init(){
        contratactifs=new ArrayList<>();
                contratactifs=contratService.contratactif();
                contratexpire=contratService.contratexpire();
                contratresilie=contratService.contratresilie();

    }
    public void validercontraactif(){
      contratactifs=contratService.contratactifall(datedebut, datefin,formContratactif.getIdtypecontrat());
    }
    public void validercontratexpire(){
      contratexpire=contratService.contratexpireall(datedebut, datefin,formContratexpire.getIdtypecontrat());
    }
    public void validercontratresilie(){
        contratresilie=contratService.contraresilieall(datedebut, datefin, formContratresilie.getIdtypecontrat());
    }
    public void effaceractif(){
        formContratactif=new Contrat();
        selectContratactif=new Contrat();
        selectContratactif=null;
    }
    public void effacerexpire(){
        formContratexpire=new Contrat();
        selectContratexpire=new Contrat();
        selectContratexpire=null;
    }
    public void effacerresilie(){
        formContratresilie=new Contrat();
        selectContratresilie=new Contrat();
        selectContratresilie=null;
    }

    public ContratServiceBeanLocal getContratService() {
        return contratService;
    }

    public void setContratService(ContratServiceBeanLocal contratService) {
        this.contratService = contratService;
    }

    public List<Contrat> getContratactifs() {
       
        return contratactifs;
    }

    public void setContratactifs(List<Contrat> contratactifs) {
        this.contratactifs = contratactifs;
    }

    public Contrat getSelectContratactif() {
        return selectContratactif;
    }

    public void setSelectContratactif(Contrat selectContratactif) {
        this.selectContratactif = selectContratactif;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public Contrat getFormContratactif() {
        return formContratactif;
    }

    public void setFormContratactif(Contrat formContratactif) {
        this.formContratactif = formContratactif;
    }

    public List<Contrat> getContratresilie() {
        return contratresilie;
    }

    public void setContratresilie(List<Contrat> contratresilie) {
        this.contratresilie = contratresilie;
    }

    public List<Contrat> getContratexpire() {
        return contratexpire;
    }

    public void setContratexpire(List<Contrat> contratexpire) {
        this.contratexpire = contratexpire;
    }

    public Contrat getSelectContratresilie() {
        return selectContratresilie;
    }

    public void setSelectContratresilie(Contrat selectContratresilie) {
        this.selectContratresilie = selectContratresilie;
    }

    public Contrat getFormContratresilie() {
        return formContratresilie;
    }

    public void setFormContratresilie(Contrat formContratresilie) {
        this.formContratresilie = formContratresilie;
    }

    public Contrat getSelectContratexpire() {
        return selectContratexpire;
    }

    public void setSelectContratexpire(Contrat selectContratexpire) {
        this.selectContratexpire = selectContratexpire;
    }

    public Contrat getFormContratexpire() {
        return formContratexpire;
    }

    public void setFormContratexpire(Contrat formContratexpire) {
        this.formContratexpire = formContratexpire;
    }
    
    
    
}
