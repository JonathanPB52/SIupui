/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.TipoDocumento;
import facades.TipoDocumentoFacade;
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

@Named(value = "TipoDocumentoControlador")
@SessionScoped

public class TipoDocumentoControlador implements Serializable{
    
    public TipoDocumentoControlador() {
        tipoDocumento = new TipoDocumento();
    }
    
    @EJB
    TipoDocumentoFacade tipoDocumentoFacade;
    TipoDocumento tipoDocumento;
    
    @PostConstruct
    public void init() {
        tipoDocumento = new TipoDocumento();
    }

    public TipoDocumentoFacade getTipoDocumentoFacade() {
        return tipoDocumentoFacade;
    }

    public void setTipoDocumentoFacade(TipoDocumentoFacade tipoDocumentoFacade) {
        this.tipoDocumentoFacade = tipoDocumentoFacade;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
    //Metodos para vistas
    
    public List<TipoDocumento> ConsultarTodos() {

        return tipoDocumentoFacade.findAll();
    }
        
    public String PreRegistrar() {
        
        return "crear";
    }

    public String Registrar() {
        tipoDocumentoFacade.create(tipoDocumento);
        tipoDocumento = new TipoDocumento();

        return "listar";
    }

    public String Eliminar(TipoDocumento tipoDocumento) {

        tipoDocumentoFacade.remove(tipoDocumento);
        this.tipoDocumento = new TipoDocumento();
        return "listar";

    }

    public String PreActualizar(TipoDocumento tipoDocumento) {

        this.tipoDocumento = tipoDocumento;
        return "editar";
    }

    public String Actualizar() {
        tipoDocumentoFacade.edit(tipoDocumento);
        tipoDocumento = new TipoDocumento();
        return "listar";

    }
    
}
