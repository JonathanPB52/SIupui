/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.TipoDonacion;
import facades.TipoDonacionFacade;
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

@Named(value = "TipoDonacionControlador")
@SessionScoped

public class TipoDonacionControlador implements Serializable{

    public TipoDonacionControlador() {
        
        tipoDonacion = new TipoDonacion();
    }
    
    
    @EJB
    TipoDonacionFacade tipoDonacionFacade;
    TipoDonacion tipoDonacion;
    
    @PostConstruct
    public void init() {
        tipoDonacion = new TipoDonacion();
    }

    public TipoDonacionFacade getTipoDonacionFacade() {
        return tipoDonacionFacade;
    }

    public void setTipoDonacionFacade(TipoDonacionFacade tipoDonacionFacade) {
        this.tipoDonacionFacade = tipoDonacionFacade;
    }

    public TipoDonacion getTipoDonacion() {
        return tipoDonacion;
    }

    public void setTipoDonacion(TipoDonacion tipoDonacion) {
        this.tipoDonacion = tipoDonacion;
    }
    
    public List<TipoDonacion> ConsultarTodos() {

        return tipoDonacionFacade.findAll();
    }
        
    public String PreRegistrar() {
        
        return "crear";
    }

    public String Registrar() {
        tipoDonacionFacade.create(tipoDonacion);
        tipoDonacion = new TipoDonacion();

        return "listar";
    }

    public String Eliminar(TipoDonacion tipoDonacion) {

        tipoDonacionFacade.remove(tipoDonacion);
        this.tipoDonacion = new TipoDonacion();
        return "listar";

    }

    public String PreActualizar(TipoDonacion tipoDonacion) {

        this.tipoDonacion = tipoDonacion;
        return "editar";
    }

    public String Actualizar() {
        tipoDonacionFacade.edit(tipoDonacion);
        tipoDonacion = new TipoDonacion();
        return "listar";

    }
    
    
    
    
}
