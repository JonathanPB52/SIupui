/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Beneficiado;
import entidades.Comedor;
import entidades.Localidad;
import entidades.TipoDocumento;
import entidades.Tipotelefono;
import facades.BeneficiadoFacade;
import facades.ComedorFacade;
import facades.LocalidadFacade;
import facades.TipoDocumentoFacade;
import facades.TipotelefonoFacade;
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
@Named(value = "BeneficiadoControlador")
@SessionScoped

public class BeneficiadoControlador implements Serializable{

    public BeneficiadoControlador() {
    }
    
    @EJB
    private BeneficiadoFacade beneficiadoFacade;
    Beneficiado beneficiado;
    
    @EJB
    private TipotelefonoFacade tipoTelefonoFacade;
    Tipotelefono tipoTelefono;
    
    @EJB
    private LocalidadFacade localidadFacade;
    Localidad localidad;
    
    @EJB
    private ComedorFacade comedorFacade;
    Comedor comedor;
    
    @EJB 
    private TipoDocumentoFacade tipoDocumentoFacade;
    TipoDocumento tipoDocumento;
    
    @PostConstruct
    public void init(){
    
        beneficiado = new Beneficiado();
        tipoTelefono = new Tipotelefono();
        localidad = new Localidad();
        comedor = new Comedor();
        tipoDocumento = new TipoDocumento();
    }
    
    private int idComedor;

    public BeneficiadoFacade getBeneficiadoFacade() {
        return beneficiadoFacade;
    }

    public void setBeneficiadoFacade(BeneficiadoFacade beneficiadoFacade) {
        this.beneficiadoFacade = beneficiadoFacade;
    }

    public Beneficiado getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(Beneficiado beneficiado) {
        this.beneficiado = beneficiado;
    }

    public TipotelefonoFacade getTipoTelefonoFacade() {
        return tipoTelefonoFacade;
    }

    public void setTipoTelefonoFacade(TipotelefonoFacade tipoTelefonoFacade) {
        this.tipoTelefonoFacade = tipoTelefonoFacade;
    }

    public Tipotelefono getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(Tipotelefono tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
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

    public int getIdComedor() {
        return idComedor;
    }

    public void setIdComedor(int idComedor) {
        this.idComedor = idComedor;
    }

    
    
    
    //Metodos
    

    

    public String Eliminar(Beneficiado beneficiado) {

        beneficiadoFacade.remove(beneficiado);
        this.beneficiado = new Beneficiado();
        return "listarYeditar";

    }

    public String PreActualizar(Beneficiado beneficiado) {

        this.beneficiado = beneficiado;
        return "editar";
    }

    public String Actualizar() {

        beneficiado.setLocalidad(localidadFacade.find(localidad.getId()));
        beneficiado.setTipoTelefono(tipoTelefonoFacade.find(tipoTelefono.getId()));
        beneficiado.setIdcomedor(comedorFacade.find(comedor.getId()));
        beneficiado.setTipoDocumento(tipoDocumentoFacade.find(tipoDocumento.getId()));
        beneficiadoFacade.edit(beneficiado);
        beneficiado = new Beneficiado();
        return "listarYeditar";

    }

    public List<Beneficiado> ConsultarTodos() {

        return beneficiadoFacade.findAll();
    }
    public String RegistrarBeneficiado(Comedor comedor) {
        this.comedor = comedor;
        return "crear";
    }
    
    public void Registrar() {

        try {
            beneficiado.setLocalidad(localidadFacade.find(comedor.getLocalidad().getId()));
            beneficiado.setTipoTelefono(tipoTelefonoFacade.find(tipoTelefono.getId()));
            beneficiado.setIdcomedor(comedorFacade.find(comedor.getId()));
            beneficiado.setTipoDocumento(tipoDocumentoFacade.find(tipoDocumento.getId()));
            beneficiadoFacade.create(beneficiado);
            beneficiado = new Beneficiado();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro, fue todo un exito", "exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ha ocurrido un error", "Error"));
        }

    }
    public String Consultar(Beneficiado beneficiado) {

        this.beneficiado = beneficiado;
        return "ConsultarID";
    }
    public String ConsultarDos(Beneficiado beneficiado) {

        this.beneficiado = beneficiado;
        return "ConsultarDos";
    }
}
