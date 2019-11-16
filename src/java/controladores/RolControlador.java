/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Rol;
import facades.RolFacade;
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

@Named(value = "RolControlador")
@SessionScoped


public class RolControlador implements Serializable{
    
    public RolControlador(){
    
        rol = new Rol();
    }
    
    @EJB
    RolFacade rolFacade;
    Rol rol;
    
    
    
    @PostConstruct
    public void init() {
    
        rol = new Rol();
    }

    public RolFacade getRolFacade() {
        return rolFacade;
    }

    public void setRolFacade(RolFacade rolFacade) {
        this.rolFacade = rolFacade;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    

    
    
    
    //Metodos
    public List<Rol> ConsultarTodos() {

        return rolFacade.findAll();
    }
        
    public String PreRegistrar() {
        
        return "crear";
    }

    public String Registrar() {
        rolFacade.create(rol);
        rol = new Rol();

        return "listar";
    }

    public String Eliminar(Rol rol) {

        rolFacade.remove(rol);
        this.rol = new Rol();
        return "listar";

    }

    public String PreActualizar(Rol rol) {

        this.rol = rol;
        return "editar";
    }

    public String Actualizar() {
        rolFacade.edit(rol);
        this.rol = new Rol();
        return "listar";

    }

    
}
