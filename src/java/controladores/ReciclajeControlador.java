/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.PesoVenta;
import entidades.Reciclaje;
import entidades.TipoDeMaterial;
import entidades.Usuario;
import facades.PesoVentaFacade;
import facades.ReciclajeFacade;
import facades.TipoDeMaterialFacade;
import facades.UsuarioFacade;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author Jonhy
 */
@Named(value = "ReciclajeControlador")
@SessionScoped

public class ReciclajeControlador implements Serializable {

    public ReciclajeControlador() {
    }

    @EJB
    private ReciclajeFacade reciclajeFacade;
    Reciclaje reciclaje;

    @EJB
    private TipoDeMaterialFacade tipoDeMaterialFacade;
    TipoDeMaterial tipoDeMaterial;

    @EJB
    private UsuarioFacade usuarioFacade;
    Usuario usuario;

    @EJB
    private PesoVentaFacade pesoVentaFacade;
    PesoVenta pesoVenta;

    @PostConstruct
    public void init() {
        tipoDeMaterial = new TipoDeMaterial();
        reciclaje = new Reciclaje();
        usuario = new Usuario();
        pesoVenta = new PesoVenta();
    }

    private String nombre1;
    private String pathReal1;
    private Part file1;

    public ReciclajeFacade getReciclajeFacade() {
        return reciclajeFacade;
    }

    public void setReciclajeFacade(ReciclajeFacade reciclajeFacade) {
        this.reciclajeFacade = reciclajeFacade;
    }

    public Reciclaje getReciclaje() {
        return reciclaje;
    }

    public void setReciclaje(Reciclaje reciclaje) {
        this.reciclaje = reciclaje;
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

    //carga
    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getPathReal1() {
        return pathReal1;
    }

    public void setPathReal1(String pathReal1) {
        this.pathReal1 = pathReal1;
    }

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public PesoVentaFacade getPesoVentaFacade() {
        return pesoVentaFacade;
    }

    public void setPesoVentaFacade(PesoVentaFacade pesoVentaFacade) {
        this.pesoVentaFacade = pesoVentaFacade;
    }

    public PesoVenta getPesoVenta() {
        return pesoVenta;
    }

    public void setPesoVenta(PesoVenta pesoVenta) {
        this.pesoVenta = pesoVenta;
    }

    //Metodos
    public String Registrar() {
        
        String mensaje;

        try {
            //carga

            reciclaje.setFacturaVenta(pathReal1);

            String path1 = FacesContext.getCurrentInstance().getExternalContext().getRealPath("Archivos/Reciclaje/");

            path1 = path1.substring(0, path1.indexOf("\\build"));
            path1 = path1 + "\\web\\Archivos\\Reciclaje\\";

            try {
                this.nombre1 = file1.getSubmittedFileName();
                pathReal1 = "../../Archivos/Reciclaje/" + nombre1;
                path1 = path1 + this.nombre1;
                InputStream in1 = file1.getInputStream();
                byte[] data = new byte[in1.available()];
                in1.read(data);
                FileOutputStream out = new FileOutputStream(new File(path1));
                out.write(data);
                in1.close();
                out.close();

            } catch (Exception e) {
            }

            reciclaje.setTipoDeMaterial(tipoDeMaterialFacade.find(tipoDeMaterial.getId()));
            reciclaje.setEncargado(usuarioFacade.find(usuario.getId()));
            reciclaje.setTipoPeso(pesoVentaFacade.find(pesoVenta.getId()));
            reciclaje.setFacturaVenta(pathReal1);
            reciclajeFacade.create(reciclaje);
            reciclaje = new Reciclaje();

            mensaje = "VentaExitosa.xhtml";
        } catch (Exception e) {
            mensaje = "crear.xhtml";
        }
        return mensaje;
    }

    public String Eliminar(Reciclaje reciclaje) {

        reciclajeFacade.remove(reciclaje);
        this.reciclaje = new Reciclaje();
        return "listarYeditar";

    }

    public String PreActualizar(Reciclaje reciclaje) {

        this.reciclaje = reciclaje;
        return "editar";
    }

    public String Actualizar() {

        reciclaje.setTipoDeMaterial(tipoDeMaterialFacade.find(tipoDeMaterial.getId()));
        reciclaje.setEncargado(usuarioFacade.find(usuario.getId()));
        reciclajeFacade.edit(reciclaje);
        reciclaje = new Reciclaje();
        return "listarYeditar";

    }

    public List<Reciclaje> ConsultarTodos() {

        return reciclajeFacade.findAll();
    }
    public String ConsultarLE(Reciclaje reciclaje) {

        this.reciclaje = reciclaje;
        return "ConsultarLE";
    }
    public String ConsultarL(Reciclaje reciclaje) {

        this.reciclaje = reciclaje;
        return "ConsultarL";
    }
    
    
    

}
