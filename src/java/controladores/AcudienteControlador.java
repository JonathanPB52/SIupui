/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Acudiente;
import entidades.TipoDocumento;
import entidades.Tipotelefono;
import entidades.Usuario;
import facades.AcudienteFacade;
import facades.TipoDocumentoFacade;
import facades.TipotelefonoFacade;
import facades.UsuarioFacade;
import java.io.Serializable;
import java.util.List;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Jonhy
 */
@Named(value = "AcudienteControlador")
@SessionScoped
public class AcudienteControlador implements Serializable {

    public AcudienteControlador() {
    }

    @EJB
    private AcudienteFacade acudienteFacade;
    Acudiente acudiente;

    @EJB
    private TipotelefonoFacade tipoDeTelefonoFacade;
    Tipotelefono tipoTelefono;

    @EJB
    private TipoDocumentoFacade tipoDocumentoFacade;
    TipoDocumento tipoDocumento;
    
    @EJB
    private UsuarioFacade usuarioFacade;
    Usuario usuario;

    @PostConstruct
    public void init() {
        acudiente = new Acudiente();
        tipoTelefono = new Tipotelefono();
        tipoDocumento = new TipoDocumento();
        usuario = new Usuario();
    }

    //Correo
    String asunto;
    String nombre;
    String para;
    private Integer idUser;

    public AcudienteFacade getAcudienteFacade() {
        return acudienteFacade;
    }

    public void setAcudienteFacade(AcudienteFacade acudienteFacade) {
        this.acudienteFacade = acudienteFacade;
    }

    public Acudiente getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(Acudiente acudiente) {
        this.acudiente = acudiente;
    }

    public TipotelefonoFacade getTipoDeTelefonoFacade() {
        return tipoDeTelefonoFacade;
    }

    public void setTipoDeTelefonoFacade(TipotelefonoFacade tipoDeTelefonoFacade) {
        this.tipoDeTelefonoFacade = tipoDeTelefonoFacade;
    }

    public Tipotelefono getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(Tipotelefono tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
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
    //empleado responsable

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    
    
    

    //Correo
    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    //Metodos
    public void Registrar() {

        try {
            acudiente.setTipoTelefono(tipoDeTelefonoFacade.find(tipoTelefono.getId()));
            acudiente.setTipoDocumento(tipoDocumentoFacade.find(tipoDocumento.getId()));
            acudiente.setEmpleadoEncargado(usuarioFacade.find(usuario.getId()));
            acudienteFacade.create(acudiente);
            acudiente = new Acudiente();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro, fue todo un exito", "exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ha ocurrido un error", "Error"));
        }

    }

    public String Eliminar(Acudiente acudiente) {

        acudienteFacade.remove(acudiente);
        this.acudiente = new Acudiente();
        return "listarYeditarAcudiente";

    }

    public String PreActualizar(Acudiente acudiente) {

        this.acudiente = acudiente;
        return "editarAcudiente";
    }

    public String Actualizar() {

        acudiente.setTipoTelefono(tipoDeTelefonoFacade.find(tipoTelefono.getId()));
        acudiente.setTipoDocumento(tipoDocumentoFacade.find(tipoDocumento.getId()));
        acudienteFacade.edit(acudiente);
        acudiente = new Acudiente();
        return "listarYeditarAcudiente";

    }

    public List<Acudiente> ConsultarTodos() {

        return acudienteFacade.findAll();
    }
    public String Registrar2() {
            
            acudiente.setTipoTelefono(tipoDeTelefonoFacade.find(tipoTelefono.getId()));
            acudiente.setTipoDocumento(tipoDocumentoFacade.find(tipoDocumento.getId()));
            acudiente.setEmpleadoEncargado(usuarioFacade.find(usuario.getId()));
            acudienteFacade.create(acudiente);
            acudiente = new Acudiente();
            
            return "listarAcudiente";
    }

}
