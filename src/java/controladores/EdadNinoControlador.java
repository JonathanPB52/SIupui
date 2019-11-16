/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.EdadNino;
import facades.EdadNinoFacade;
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

@Named(value = "EdadNinoControlador")
@SessionScoped

public class EdadNinoControlador implements Serializable{
    public EdadNinoControlador(){
    
        edadNino = new EdadNino();
    }
    
    @EJB
    EdadNinoFacade edadNinoFacade;
    EdadNino edadNino;
    
    @PostConstruct
    public void init() {
        edadNino = new EdadNino();
    }

    public EdadNinoFacade getEdadNinoFacade() {
        return edadNinoFacade;
    }

    public void setEdadNinoFacade(EdadNinoFacade edadNinoFacade) {
        this.edadNinoFacade = edadNinoFacade;
    }

    public EdadNino getEdadNino() {
        return edadNino;
    }

    public void setEdadNino(EdadNino edadNino) {
        this.edadNino = edadNino;
    }
    
    //Metodos
    public List<EdadNino> ConsultarTodos() {

        return edadNinoFacade.findAll();
    }
        
    public String PreRegistrar() {
        
        return "crear";
    }

    public String Registrar() {
        edadNinoFacade.create(edadNino);
        edadNino = new EdadNino();

        return "listar";
    }

    public String Eliminar(EdadNino edadNino) {

        edadNinoFacade.remove(edadNino);
        this.edadNino = new EdadNino();
        return "listar";

    }

    public String PreActualizar(EdadNino edadNino) {
        
        this.edadNino = edadNino;
        return "editar";
    }

    public String Actualizar() {
        edadNinoFacade.edit(edadNino);
        this.edadNino = new EdadNino();
        return "listar";

    }
    
}
