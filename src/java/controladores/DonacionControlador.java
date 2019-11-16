/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;



import entidades.Donacion;
import entidades.Donante;
import entidades.TipoDonacion;
import facades.DonacionFacade;
import facades.DonanteFacade;
import facades.TipoDonacionFacade;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;





/**
 *
 * @author Jonhy
 */

@Named(value = "DonacionControlador")
@SessionScoped

public class DonacionControlador implements Serializable{

    public DonacionControlador() {
    }
    
    @EJB
    private DonacionFacade donacionFacade;
    Donacion donacion;
    
    
    @EJB
    private TipoDonacionFacade tipoDonacionFacade;
    TipoDonacion tipoDonacion;
    
    @EJB
    private DonanteFacade donanteFacade;
    Donante donante;    
    
    @PostConstruct
    public void init(){
    
        donacion = new Donacion();
        tipoDonacion = new TipoDonacion();
        donante = new Donante();
    }
    
    
    private String nombre1;
    private String pathReal1;
    private Part file1;
    
    

    public DonacionFacade getDonacionFacade() {
        return donacionFacade;
    }

    public void setDonacionFacade(DonacionFacade donacionFacade) {
        this.donacionFacade = donacionFacade;
    }

    public Donacion getDonacion() {
        return donacion;
    }

    public void setDonacion(Donacion donacion) {
        this.donacion = donacion;
    }

    public TipoDonacionFacade getTipoDonacionFacade() {
        return tipoDonacionFacade;
    }

    public void setTipoDonacionFacade(TipoDonacionFacade tipoDonacionFacade) {
        this.tipoDonacionFacade = tipoDonacionFacade;
    }

    public TipoDonacion getTipoDonacion() {
        return tipoDonacion;
    }

    public void setTipoDonacion(TipoDonacion tipoDonacion) {
        this.tipoDonacion = tipoDonacion;
    }

    public DonanteFacade getDonanteFacade() {
        return donanteFacade;
    }

    public void setDonanteFacade(DonanteFacade donanteFacade) {
        this.donanteFacade = donanteFacade;
    }

    public Donante getDonante() {
        return donante;
    }

    public void setDonante(Donante donante) {
        this.donante = donante;
    }
    
    //Carga de archivos

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
    
    
    
    //Metodos
    public String Registrar() {
        
        String mensaje;
        
        try {
            //reciclaje
            

            donacion.setEvidenciaDonacion(pathReal1);

            String path1 = FacesContext.getCurrentInstance().getExternalContext().getRealPath("Archivos/Donacion/");

            path1 = path1.substring(0, path1.indexOf("\\build"));
            path1 = path1 + "\\web\\Archivos\\Donacion\\";

            try {
                this.nombre1 = file1.getSubmittedFileName();
                pathReal1 = "../../Archivos/Donacion/" + nombre1;
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

            donacion.setTipoDonacion(tipoDonacionFacade.find(tipoDonacion.getId()));
            donacion.setDonante(donanteFacade.find(donante.getId()));
            donacion.setEvidenciaDonacion(pathReal1);
            donacionFacade.create(donacion);
            donacion = new Donacion();

            mensaje = "AmbosregistrosExitosos.xhtml";
        } catch (Exception e) {
            mensaje = "crearDonacion.xhtml";
        }
        
        return mensaje;
        
    }

    public String Eliminar(Donacion donacion) {

        donacionFacade.remove(donacion);
        this.donacion=new Donacion();
        return "listarYeditarDonacion";

    }

    public String PreActualizar(Donacion donacion) {

        this.donacion = donacion;
        return "editarDonacion";
    }

    public String Actualizar() {

        donacion.setTipoDonacion(tipoDonacionFacade.find(tipoDonacion.getId()));
        donacion.setDonante(donanteFacade.find(donante.getId()));
        donacionFacade.edit(donacion);
        donacion=new Donacion();
        return "listarYeditarDonacion";

    }

    public List<Donacion> ConsultarTodos() {

        return donacionFacade.findAll();
    }
    
    public String ConsultarDLE(Donacion donacion) {

        this.donacion = donacion;
        return "CDomacionLE";
    }
    
    public String ConsultarDL(Donacion donacion) {

        this.donacion = donacion;
        return "CDomacionL";
    }
    
}
