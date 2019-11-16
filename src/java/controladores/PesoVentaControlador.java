/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.PesoVenta;
import facades.PesoVentaFacade;
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

@Named(value = "PesoVentaControlador")
@SessionScoped

public class PesoVentaControlador implements Serializable{

    public PesoVentaControlador() {
    }
    
    @EJB
    private PesoVentaFacade persoVentaFacade;
    PesoVenta pesoVenta;
    
    @PostConstruct
    public void init(){
        pesoVenta = new PesoVenta();
    }

    public PesoVentaFacade getPersoVentaFacade() {
        return persoVentaFacade;
    }

    public void setPersoVentaFacade(PesoVentaFacade persoVentaFacade) {
        this.persoVentaFacade = persoVentaFacade;
    }

    public PesoVenta getPesoVenta() {
        return pesoVenta;
    }

    public void setPesoVenta(PesoVenta pesoVenta) {
        this.pesoVenta = pesoVenta;
    }
    
    //Metodos
    
    public List<PesoVenta> ConsultarTodos() {

        return persoVentaFacade.findAll();
    }
    
}
