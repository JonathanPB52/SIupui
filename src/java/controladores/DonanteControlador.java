/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Donante;
import entidades.Tipotelefono;
import facades.DonanteFacade;
import facades.TipotelefonoFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Jonhy
 */

@Named(value = "DonanteControlador")
@SessionScoped


public class DonanteControlador implements Serializable{

    public DonanteControlador() {
    }
    
    @EJB
    private DonanteFacade donanteFacade;
    Donante donante;
    
    @EJB
    private TipotelefonoFacade tipoDeTelefonoFacade;
    Tipotelefono tipoTelefono;
    
    @PostConstruct
    
    public void init(){
        donante = new Donante();
        tipoTelefono = new Tipotelefono();
    }

    public DonanteFacade getDonanteFacade() {
        return donanteFacade;
    }

    public void setDonanteFacade(DonanteFacade donanteFacade) {
        this.donanteFacade = donanteFacade;
    }

    public Donante getDonante() {
        return donante;
    }

    public void setDonante(Donante donante) {
        this.donante = donante;
    }

    public TipotelefonoFacade getTipoDeTelefonoFacade() {
        return tipoDeTelefonoFacade;
    }

    public void setTipoDeTelefonoFacade(TipotelefonoFacade tipoDeTelefonoFacade) {
        this.tipoDeTelefonoFacade = tipoDeTelefonoFacade;
    }

    public Tipotelefono getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(Tipotelefono tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }
    
    //Metodos
    
    
    public String Registrar() {
        
        String mensaje;
        
        try {
            donante.setTipoTelefono(tipoDeTelefonoFacade.find(tipoTelefono.getId()));
        donanteFacade.create(donante);
        donante=new Donante();
        
        mensaje = "ExitoDonanteRegistrado.xhtml";
        } catch (Exception e) {
            mensaje = "crearDonante.xhtml";
        }
        
        return mensaje;
        
        
        
    }

    public String Eliminar(Donante donante) {

        donanteFacade.remove(donante);
        this.donante = new Donante();
        
        return "listarYeditarDonante";

    }

    public String PreActualizar(Donante donante) {

        this.donante = donante;
        
        return "editarDonante";
    }

    public String Actualizar() {

        donante.setTipoTelefono(tipoDeTelefonoFacade.find(tipoTelefono.getId()));
        donanteFacade.edit(donante);
        donante=new Donante();
        
        return "listarYeditarDonante";

    }

    public List<Donante> ConsultarTodos() {

        return donanteFacade.findAll();
    }
    public String ConsultarLE(Donante donante) {

        this.donante = donante;
        
        return "ConsultarDLE";
    }
    public String ConsultarL(Donante donante) {

        this.donante = donante;
        
        return "ConsultarDL";
    }
    
}
