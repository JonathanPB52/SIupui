/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

/**
 *
 * @author Jonhy
 */
import entidades.Actividad;
import entidades.Curso;
import facades.ActividadFacade;
import facades.CursoFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "ActividadControlador")
@SessionScoped

public class ActividadControlador implements Serializable {

    public ActividadControlador() {

    }
    @EJB
    private ActividadFacade actividadFacade;
    Actividad actividad;

    @EJB
    private CursoFacade cursoFacade;
    Curso curso;

    @PostConstruct
    public void init() {
        actividad = new Actividad();
        curso = new Curso();
    }

    public ActividadFacade getActividadFacade() {
        return actividadFacade;
    }

    public void setActividadFacade(ActividadFacade actividadFacade) {
        this.actividadFacade = actividadFacade;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
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

    //Metodos
    
    public String PreRegistrar(Curso curso) {

        this.curso = curso;
        return "RegistrarActividad";
    }
    
    public String Registrar() {

        String mensaje;

        try {

            actividad.setCurso(cursoFacade.find(curso.getId()));
            actividadFacade.create(actividad);
            actividad = new Actividad();

            mensaje = "RegistroExitoso";
        } catch (Exception e) {
            mensaje = "RegistroError";
        }

        return mensaje;

    }

    public String Eliminar(Actividad actividad) {

        actividadFacade.remove(actividad);
        this.actividad = new Actividad();
        return "listarYeditar";

    }

    public String PreActualizar(Actividad actividad) {

        this.actividad = actividad;
        return "editar";
    }
    
    public String Actualizar() {
        actividad.setCurso(cursoFacade.find(curso.getId()));
        actividadFacade.edit(actividad);
        this.actividad = new Actividad();
        return "listarYeditar";
    }
       
    
    public List<Actividad> ConsultarTodos() {

        return actividadFacade.findAll();
    }
    public String Consultar(Actividad actividad) {

        this.actividad = actividad;
        return "ConsultaID";
    }
    public String ConsultarDos(Actividad actividad) {

        this.actividad = actividad;
        return "ConsultaDos";
    }

}
