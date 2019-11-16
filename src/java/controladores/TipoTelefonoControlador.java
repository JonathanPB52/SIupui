/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Tipotelefono;
import facades.TipotelefonoFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Jonhy
 */

@Named(value = "TipoTelefonoControlador")
@SessionScoped

public class TipoTelefonoControlador implements Serializable{
    
    public TipoTelefonoControlador(){
    
        tipoDeTelefono = new Tipotelefono();
    }
    
    @EJB
    TipotelefonoFacade tipoDeTelefonoFacade;
    Tipotelefono tipoDeTelefono;
    
    @PostConstruct
    public void init() {
        tipoDeTelefono = new Tipotelefono();
    }

    public TipotelefonoFacade getTipoDeTelefonoFacade() {
        return tipoDeTelefonoFacade;
    }

    public void setTipoDeTelefonoFacade(TipotelefonoFacade tipoDeTelefonoFacade) {
        this.tipoDeTelefonoFacade = tipoDeTelefonoFacade;
    }

    public Tipotelefono getTipoDeTelefono() {
        return tipoDeTelefono;
    }

    public void setTipoDeTelefono(Tipotelefono tipoDeTelefono) {
        this.tipoDeTelefono = tipoDeTelefono;
    }
    
    public List<Tipotelefono> ConsultarTodos() {

        return tipoDeTelefonoFacade.findAll();
    }
        
    public String PreRegistrar() {
        
        return "crear";
    }

    public String Registrar() {
        tipoDeTelefonoFacade.create(tipoDeTelefono);
        tipoDeTelefono = new Tipotelefono();

        return "listar";
    }

    public String Eliminar(Tipotelefono tipoDeTelefono) {

        tipoDeTelefonoFacade.remove(tipoDeTelefono);
        this.tipoDeTelefono = new Tipotelefono();
        return "listar";

    }

    public String PreActualizar(Tipotelefono tipoDeTelefono) {

        this.tipoDeTelefono = tipoDeTelefono;
        return "editar";
    }

    public String Actualizar() {
        tipoDeTelefonoFacade.edit(tipoDeTelefono);
        this.tipoDeTelefono = new Tipotelefono();
        return "listar";

    }
    
    
}
