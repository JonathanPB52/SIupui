/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.AfiliacionMedica;
import facades.AfiliacionMedicaFacade;
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
@Named(value = "AfiliacionMedicaControlador")
@SessionScoped


public class AfiliacionMedicaControlador implements Serializable{
    public AfiliacionMedicaControlador(){
    
        afiliacionMedica = new AfiliacionMedica();
    }
    
    @EJB
    AfiliacionMedicaFacade afiliacionMedicaFacade;
    AfiliacionMedica afiliacionMedica;
    
    @PostConstruct
    public void init() {
        afiliacionMedica = new AfiliacionMedica();
    }

    public AfiliacionMedicaFacade getAfiliacionMedicaFacade() {
        return afiliacionMedicaFacade;
    }

    public void setAfiliacionMedicaFacade(AfiliacionMedicaFacade afiliacionMedicaFacade) {
        this.afiliacionMedicaFacade = afiliacionMedicaFacade;
    }

    public AfiliacionMedica getAfiliacionMedica() {
        return afiliacionMedica;
    }

    public void setAfiliacionMedica(AfiliacionMedica afiliacionMedica) {
        this.afiliacionMedica = afiliacionMedica;
    }
    
    //Metodos
    public List<AfiliacionMedica> ConsultarTodos() {

        return afiliacionMedicaFacade.findAll();
    }
    

    public String Registrar() {
        afiliacionMedicaFacade.create(afiliacionMedica);
        afiliacionMedica = new AfiliacionMedica();

        return "listar";
    }

    public String Eliminar(AfiliacionMedica afiliacionMedica) {

        afiliacionMedicaFacade.remove(afiliacionMedica);
        this.afiliacionMedica = new AfiliacionMedica();
        return "listar";

    }

    public String PreActualizar(AfiliacionMedica afiliacionMedica) {

        this.afiliacionMedica = afiliacionMedica;
        return "editar";
    }

    public String Actualizar() {
        afiliacionMedicaFacade.edit(afiliacionMedica);
        this.afiliacionMedica = new AfiliacionMedica();
        return "listar";

    }
    
}
