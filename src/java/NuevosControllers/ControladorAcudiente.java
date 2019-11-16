/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NuevosControllers;

import controladores.envioCorreo;
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
@Named(value = "ControladorAcudiente")
@SessionScoped

public class ControladorAcudiente implements Serializable {

    public ControladorAcudiente() {
    }

    @EJB
    AcudienteFacade acudienteFacade;
    private Acudiente acudiente;

    @EJB
    TipoDocumentoFacade tipoDocumentoFacade;
    private TipoDocumento tipoDocumento;

    @EJB
    TipotelefonoFacade tipoTelefonoFacade;
    private Tipotelefono tipoTelefonno;

    @EJB
    UsuarioFacade usuarioFacade;
    private Usuario usuario;

    @PostConstruct
    public void init() {
        acudiente = new Acudiente();
        tipoTelefonno = new Tipotelefono();
        tipoDocumento = new TipoDocumento();
        usuario = new Usuario();
    }
    //Correo
    String asunto;
    String nombre;
    String para;
    
    //Empleado responsable
    
    int empleadoResponsable;

    //getter & setter
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

    public TipotelefonoFacade getTipoTelefonoFacade() {
        return tipoTelefonoFacade;
    }

    public void setTipoTelefonoFacade(TipotelefonoFacade tipoTelefonoFacade) {
        this.tipoTelefonoFacade = tipoTelefonoFacade;
    }

    public Tipotelefono getTipoTelefonno() {
        return tipoTelefonno;
    }

    public void setTipoTelefonno(Tipotelefono tipoTelefonno) {
        this.tipoTelefonno = tipoTelefonno;
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
    
    //Empleado responsable

    public int getEmpleadoResponsable() {
        return empleadoResponsable;
    }

    public void setEmpleadoResponsable(int empleadoResponsable) {
        this.empleadoResponsable = empleadoResponsable;
    }

    //Metodos
    public String Registrar() {
        
        String asunto="Haz sido registrado como acudiente";
        String mensaje;

            empleadoResponsable = 1;
            
            try {
            
        

            envioCorreo correo = new envioCorreo();
            correo.enviarCorreo(para, asunto);

            acudiente.setTipoTelefono(tipoTelefonoFacade.find(tipoTelefonno.getId()));
            acudiente.setTipoDocumento(tipoDocumentoFacade.find(tipoDocumento.getId()));
            acudiente.setCorreoAcudiente(para);
            acudiente.setEmpleadoEncargado(usuarioFacade.find(empleadoResponsable));
            acudienteFacade.create(acudiente);
            acudiente = new Acudiente();
            
            mensaje = "RegistroExitoso";
            
            } catch (Exception e) {
            
                mensaje = "RegistroErrorAcudiente";

                
        }
        return mensaje;

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

        acudiente.setTipoTelefono(tipoTelefonoFacade.find(tipoTelefonno.getId()));
        acudiente.setTipoDocumento(tipoDocumentoFacade.find(tipoDocumento.getId()));
        acudienteFacade.edit(acudiente);
        acudiente = new Acudiente();
        return "listarYeditarAcudiente";

    }

    public List<Acudiente> ConsultarTodos() {

        return acudienteFacade.findAll();
    }
    
    public void correoMasivo() {

        try {

            envioCorreo envioCo = new envioCorreo();

            for (Acudiente AcudienteCorreos : this.ConsultarTodos()) {
                envioCo.enviarCorreo(AcudienteCorreos.getCorreoAcudiente(), asunto);
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El correo a sido enviado exitosamente", "exito"));

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos pero algo a , vuelve a intentar mas tarde", "Error"));
        }

    }
    public String ConsultarUNO(Acudiente acudiente) {

        this.acudiente = acudiente;
        return "ConsultarAcuUNO";
    }
    public String ConsultarDOS(Acudiente acudiente) {

        this.acudiente = acudiente;
        return "ConsultarAcuDOS";
    }

}
