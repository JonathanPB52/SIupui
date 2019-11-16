/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import EntidadesReportes.UsuarioEntidadReporte;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author Jonhy
 */
@Named(value = "reporteUsuarioControlador")
@SessionScoped
public class ReporteUsuarioControlador implements Serializable {

    /**
     * Creates a new instance of ReporteUsuarioControlador
     */
    public ReporteUsuarioControlador() {
    }

    private String Rol;

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public void descargarUsuarios() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        try {
            UsuarioEntidadReporte reporteUser = new UsuarioEntidadReporte();

            FacesContext facesContext = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
            String ruta = servletContext.getRealPath("//Reportes//UsuarioReporte.jasper");
            reporteUser.DescargarUsuarios(ruta, this.Rol);
            FacesContext.getCurrentInstance().getResponseComplete();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El reporte a sido generado exitosamente","exito"));

        } catch (Exception e) {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "El reporte no a sido generado","Error"));
        }

    }

}
