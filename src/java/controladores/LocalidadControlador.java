/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import entidades.Localidad;
import facades.LocalidadFacade;
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

@Named(value = "LocalidadControlador")
@SessionScoped

public class LocalidadControlador implements Serializable{
    
    public LocalidadControlador(){
    
        localidad = new Localidad();
    }
    
    @EJB
    LocalidadFacade localidadFacade;
    Localidad localidad;
    
    @PostConstruct
    public void init() {
        localidad = new Localidad();
    }

    public LocalidadFacade getLocalidadFacade() {
        return localidadFacade;
    }

    public void setLocalidadFacade(LocalidadFacade localidadFacade) {
        this.localidadFacade = localidadFacade;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    
     //Metodos
    public List<Localidad> ConsultarTodos() {

        return localidadFacade.findAll();
    }
        
    public String PreRegistrar() {
        
        return "crear";
    }

    public String Registrar() {
        localidadFacade.create(localidad);
        localidad = new Localidad();

        return "listar";
    }

    public String Eliminar(Localidad localidad) {

        localidadFacade.remove(localidad);
        this.localidad = new Localidad();
        return "listar";

    }

    public String PreActualizar(Localidad localidad) {
        this.localidad = localidad;
        return "editar";
    }

    public String Actualizar() {
        localidadFacade.edit(localidad);
        this.localidad = new Localidad();
        return "listar";

    }
    
}
