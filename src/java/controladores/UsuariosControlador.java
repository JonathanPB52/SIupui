/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Estado;
import entidades.Permiso;
import entidades.Rol;
import entidades.TipoDocumento;
import entidades.Usuario;
import facades.EstadoFacade;
import facades.RolFacade;
import facades.TipoDocumentoFacade;
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
@Named(value = "UsuariosControlador")
@SessionScoped

public class UsuariosControlador implements Serializable{

    public UsuariosControlador() {
    }
    
    @EJB
    private UsuarioFacade usuarioFacade;
    Usuario usuario;
    
    private List<Usuario> listaUsuario;
    
    
    @EJB
    private EstadoFacade estadoFacade;
    Estado estado;
    
    @EJB
    private TipoDocumentoFacade tipoDocumentoFacade;
    TipoDocumento tipoDocumento;
    
    @EJB
    private RolFacade rolFacade;
    Rol rol;
    Usuario usuarioLogueado;
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
        estado = new Estado();
        tipoDocumento = new TipoDocumento();
        rol = new Rol();
    }
    
    String asunto;
    String nombre;
    String para;
    String correos;
    
      

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

    public EstadoFacade getEstadoFacade() {
        return estadoFacade;
    }

    public void setEstadoFacade(EstadoFacade estadoFacade) {
        this.estadoFacade = estadoFacade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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

    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }
    
    // correo masivo4

    public String getCorreos() {
        return correos;
    }

    public void setCorreos(String correos) {
        this.correos = correos;
    }
    
    
    
    //Metodos
    
    public String PreRegistrar(Rol rol) {

        this.rol = rol;
        return "crear";
    }
    
    public void Registrar() {
        
        String asunto="usuario exitosamente registrado";
        int estadoU=1;
        
        try {
        
        envioCorreo correo = new envioCorreo();
        correo.enviarCorreo(para, asunto);
        
        
        usuario.setTipoDeDocumento(tipoDocumentoFacade.find(tipoDocumento.getId()));
        usuario.setEstado(estadoFacade.find(estadoU));
        usuario.setIdRol(rolFacade.find(rol.getId()));
        usuario.setCorreo(para);
        usuarioFacade.create(usuario);
        usuario = new Usuario();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El usuario a sido creado exitosamente", "exito"));
            
        } catch (Exception e) {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos se ha producido un erro, por favor verifica los datos", "Error"));
        }
        
        
        
    }

    public String Eliminar(Usuario usuario) {

        usuarioFacade.remove(usuario);
        this.usuario = new Usuario();
        return "listarYeditar";

    }

    public String PreActualizar(Usuario usuario) {

        this.usuario = usuario;
        return "Actualizar";
    }

    public String Actualizar() {
        
        int estadoU=1;
        
        usuario.setTipoDeDocumento(tipoDocumentoFacade.find(tipoDocumento.getId()));
        usuario.setEstado(estadoFacade.find(estadoU));
        usuario.setIdRol(rolFacade.find(rol.getId()));
        usuarioFacade.edit(usuario);
        this.usuario = new Usuario();
        return "listarYeditar";

    }

    public List<Usuario> ConsultarTodos() {

        return usuarioFacade.findAll();
    }
    
    public String validarLogin() {
        String redireccionar = "";
        try {
            usuarioLogueado = usuarioFacade.login(usuario);
            if (usuarioLogueado != null) {
                rol = usuarioLogueado.getIdRol();
                for (/*  */ Permiso permiso : usuarioLogueado.getIdRol().getPermisoList()){
                    System.out.println("Permisos: " + permiso.getNombre());
                }
                
                System.out.println("Usuario logueado: " + usuarioLogueado.getNombre());
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sessionLogin", usuario);
                redireccionar = "menu.xhtml?faces-redirect=true";
                }
            else{
            
                redireccionar = "login.xhtml?faces-redirect=true";
            }
        
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return redireccionar;
    }
    
    
    public List<Usuario> getListaUsuarios() {
        return listaUsuario;
    }
    
    
    public void correoMasivo() {

        try {

            envioCorreo envioCo = new envioCorreo();

            for (Usuario usuarioCorreos : this.ConsultarTodos()) {
                envioCo.enviarCorreo(usuarioCorreos.getCorreo(), asunto);
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El correo a sido enviado exitosamente", "exito"));

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos pero algo a , vuelve a intentar mas tarde", "Error"));
        }

    }
    
    public String ConsultarUNO(Usuario usuario) {

        this.usuario = usuario;
        return "ConsultarUNO";
    }
    public String ConsultarDOS(Usuario usuario) {

        this.usuario = usuario;
        return "ConsultarDOS";
    }
    
    
}
