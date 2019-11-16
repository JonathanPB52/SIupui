/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.TipoDeMaterial;
import facades.TipoDeMaterialFacade;
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

@Named(value = "TipoMaterialControlador")
@SessionScoped

public class TipoMaterialControlador implements Serializable{
    
    public TipoMaterialControlador(){
    
        tipoDeMaterial = new TipoDeMaterial();
    }
    
    @EJB
    TipoDeMaterialFacade tipoDeMaterialFacade;
    TipoDeMaterial tipoDeMaterial;
    
    @PostConstruct
    public void init() {
        tipoDeMaterial = new TipoDeMaterial();
    }

    public TipoDeMaterialFacade getTipoDeMaterialFacade() {
        return tipoDeMaterialFacade;
    }

    public void setTipoDeMaterialFacade(TipoDeMaterialFacade tipoDeMaterialFacade) {
        this.tipoDeMaterialFacade = tipoDeMaterialFacade;
    }

    public TipoDeMaterial getTipoDeMaterial() {
        return tipoDeMaterial;
    }

    public void setTipoDeMaterial(TipoDeMaterial tipoDeMaterial) {
        this.tipoDeMaterial = tipoDeMaterial;
    }

    public List<TipoDeMaterial> ConsultarTodos() {

        return tipoDeMaterialFacade.findAll();
    }
        
    public String PreRegistrar() {
        
        return "crear";
    }

    public String Registrar() {
        tipoDeMaterialFacade.create(tipoDeMaterial);
        tipoDeMaterial = new TipoDeMaterial();

        return "listar";
    }

    public String Eliminar(TipoDeMaterial tipoDeMaterial) {

        tipoDeMaterialFacade.remove(tipoDeMaterial);
        this.tipoDeMaterial = new TipoDeMaterial();
        return "listar";

    }

    public String PreActualizar(TipoDeMaterial tipoDeMaterial) {

        this.tipoDeMaterial = tipoDeMaterial;
        return "editar";
    }

    public String Actualizar() {
        tipoDeMaterialFacade.edit(tipoDeMaterial);
        tipoDeMaterial = new TipoDeMaterial();
        return "listar";

    }
}
