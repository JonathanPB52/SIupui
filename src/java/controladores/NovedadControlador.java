/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Comedor;
import entidades.Novedad;
import facades.ComedorFacade;
import facades.NovedadFacade;
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
import javax.servlet.http.Part;

/**
 *
 * @author Jonhy
 */
@Named(value = "NovedadControlador")
@SessionScoped

public class NovedadControlador implements Serializable {

    public NovedadControlador() {
    }

    @EJB
    private NovedadFacade novedadFacade;
    Novedad novedad;

    @EJB
    private ComedorFacade comedordFacade;
    Comedor comedor;

    @PostConstruct

    public void init() {
        novedad = new Novedad();
        comedor = new Comedor();
    }

    //carga de archivo
    private String nombre1;
    private String pathReal1;
    private Part file1;

    //get & set
    public NovedadFacade getNovedadFacade() {
        return novedadFacade;
    }

    public void setNovedadFacade(NovedadFacade novedadFacade) {
        this.novedadFacade = novedadFacade;
    }

    public Novedad getNovedad() {
        return novedad;
    }

    public void setNovedad(Novedad novedad) {
        this.novedad = novedad;
    }

    public ComedorFacade getComedordFacade() {
        return comedordFacade;
    }

    public void setComedordFacade(ComedorFacade comedordFacade) {
        this.comedordFacade = comedordFacade;
    }

    public Comedor getComedor() {
        return comedor;
    }

    public void setComedor(Comedor comedor) {
        this.comedor = comedor;
    }

    //get & set
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
    public String PreRegistrar(Comedor comedor) {
        this.comedor = comedor;
        return "crear";
    }

    public void Registrar() {
        try {
            novedad.setEvidenciaNovedad(pathReal1);

            String path1 = FacesContext.getCurrentInstance().getExternalContext().getRealPath("Archivos/Novedad/");

            path1 = path1.substring(0, path1.indexOf("\\build"));
            path1 = path1 + "\\web\\Archivos\\Novedad\\";

            try {
                this.nombre1 = file1.getSubmittedFileName();
                pathReal1 = "../../Archivos/Novedad/" + nombre1;
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

            novedad.setIdcomedor(comedordFacade.find(comedor.getId()));
            novedad.setEvidenciaNovedad(pathReal1);
            novedadFacade.create(novedad);
            novedad = new Novedad();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro, fue todo un exito", "exito"));

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ha ocurrido un problema, por favor vuelve a intentar mas tarde", "exito"));
        }
    }

    public String Eliminar(Novedad novedad) {

        novedadFacade.remove(novedad);
        this.novedad = new Novedad();

        return "listarYeditar";

    }

    public String PreActualizar(Novedad novedad) {

        this.novedad = novedad;
        return "editar";
    }

    public String Actualizar() {

        novedad.setIdcomedor(comedordFacade.find(comedor.getId()));
        novedadFacade.edit(novedad);
        novedad = new Novedad();

        return "listarYeditar";

    }

    public List<Novedad> ConsultarTodos() {

        return novedadFacade.findAll();
    }
    
    public String ConsultarL(Novedad novedad) {

        this.novedad = novedad;
        return "ConsultarL";
    }
    
    public String ConsultarLE(Novedad novedad) {

        this.novedad = novedad;
        return "ConsultarLE";
    }

}
