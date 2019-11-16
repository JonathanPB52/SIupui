/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Curso;
import entidades.Usuario;
import facades.CursoFacade;
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
@Named(value = "CursoControlador")
@SessionScoped

public class CursoControlador implements Serializable{
    public CursoControlador(){
    
        curso = new Curso();
    }
    
    @EJB
    private CursoFacade cursoFacade;
    Curso curso;
    
    @EJB
    private UsuarioFacade usuarioFacade;
    Usuario usuario;
    
    @PostConstruct
    public void init() {
        curso = new Curso();
        usuario = new Usuario();
    }

    public CursoFacade getCursoFacade() {
        return cursoFacade;
    }

    public void setCursoFacade(CursoFacade cursoFacade) {
        this.cursoFacade = cursoFacade;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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
            curso.setEncargado(usuarioFacade.find(usuario.getId()));
            cursoFacade.create(curso);
            curso = new Curso();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro, fue todo un exito", "exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ha ocurrido un error", "Error"));
        }

    }

    public String Eliminar(Curso curso) {

        cursoFacade.remove(curso);
        this.curso = new Curso();
        return "listarYeditar";

    }

    public String PreActualizar(Curso curso) {

        this.curso = curso;
        return "editar";
    }

    public String Actualizar() {
        curso.setEncargado(usuarioFacade.find(usuario.getId()));
        cursoFacade.edit(curso);
        this.curso = new Curso();
        return "listarYeditar";

    }
    public List<Curso> ConsultarTodos() {

        return cursoFacade.findAll();
    }
    
    
}
