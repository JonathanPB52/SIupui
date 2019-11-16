/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Estado;
import facades.EstadoFacade;
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

@Named(value = "EstadoControlador")
@SessionScoped

public class EstadoControlador implements Serializable{
    public EstadoControlador(){
    
        estado = new Estado();
    }
    
    @EJB
    EstadoFacade estadoFacade;
    Estado estado;
    
    @PostConstruct
    public void init() {
        estado = new Estado();
    }

    public EstadoFacade getEstadoFacade() {
        return estadoFacade;
    }

    public void setEstadoFacade(EstadoFacade estadoFacade) {
        this.estadoFacade = estadoFacade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    //Metodos
    public List<Estado> ConsultarTodos() {

        return estadoFacade.findAll();
    }
        
    public String PreRegistrar() {
        
        return "crear";
    }

    public String Registrar() {
        estadoFacade.create(estado);
        estado = new Estado();

        return "listar";
    }

    public String Eliminar(Estado estado) {

        estadoFacade.remove(estado);
        this.estado = new Estado();
        return "listar";

    }

    public String PreActualizar(Estado estado) {
        this.estado = estado;
        return "editar";
    }

    public String Actualizar() {
        estadoFacade.edit(estado);
        this.estado = new Estado();
        return "listar";

    }
}
