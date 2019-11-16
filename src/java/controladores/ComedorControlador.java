/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Comedor;
import entidades.Localidad;
import entidades.Usuario;
import facades.ComedorFacade;
import facades.LocalidadFacade;
import facades.UsuarioFacade;
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
@Named(value = "ComedorControlador")
@SessionScoped

public class ComedorControlador implements Serializable{
    public ComedorControlador(){
        comedor = new Comedor();
    }
    
    @EJB
    private ComedorFacade comedorFacade;
    Comedor comedor;
    
    @EJB
    private LocalidadFacade localidadFacade;
    Localidad localidad;
    
    @EJB
    private UsuarioFacade usuarioFacade;
    Usuario usuario;
        
    @PostConstruct
    public void init() {
        comedor = new Comedor();
        localidad = new Localidad();
        usuario = new Usuario();
    }

    public ComedorFacade getComedorFacade() {
        return comedorFacade;
    }

    public void setComedorFacade(ComedorFacade comedorFacade) {
        this.comedorFacade = comedorFacade;
    }

    public Comedor getComedor() {
        return comedor;
    }

    public void setComedor(Comedor comedor) {
        this.comedor = comedor;
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

    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    

    //Metodos

    public void Registrar() {

        try {
            comedor.setLocalidad(localidadFacade.find(localidad.getId()));
            comedor.setEncargado(usuarioFacade.find(usuario.getId()));
            comedorFacade.create(comedor);
            comedor = new Comedor();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro, fue todo un exito", "exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ha ocurrido un error", "Error"));
        }

    }

    public String Eliminar(Comedor comedor) {

        comedorFacade.remove(comedor);
        this.comedor = new Comedor();
        return "listarYeditar";

    }

    public String PreActualizar(Comedor comedor) {

        this.comedor = comedor;
        return "editar";
    }

    public String Actualizar() {
        comedor.setLocalidad(localidadFacade.find(localidad.getId()));
        comedor.setEncargado(usuarioFacade.find(usuario.getId()));
        comedorFacade.edit(comedor);
        this.comedor = new Comedor();
        return "listarYeditar";

    }
    public List<Comedor> ConsultarTodos() {
        return comedorFacade.findAll();
    }
    
    public String ConsultarL(Comedor comedor) {

        this.comedor = comedor;
        return "ConsultarL";
    }
    
    public String ConsultarLE(Comedor comedor) {

        this.comedor = comedor;
        return "ConsultarLE";
    }
}
