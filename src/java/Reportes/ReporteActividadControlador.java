/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;


import EntidadesReportes.ActividadEntidadReporte;
import EntidadesReportes.UsuarioEntidadReporte;
import EntidadesReportes.VentaEntidadReporte;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
/**
 *
 * @author Jonathan
 */


@Named(value = "reporteActividadControlador")
@SessionScoped
public class ReporteActividadControlador implements Serializable{

    public ReporteActividadControlador() {
    }
    
    private String NombreCurso;

    public String getNombreCurso() {
        return NombreCurso;
    }

    public void setNombreCurso(String NombreCurso) {
        this.NombreCurso = NombreCurso;
    }
    
    public void descargarActividad() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        try {
            ActividadEntidadReporte reporteActivi = new ActividadEntidadReporte();
            

            FacesContext facesContext = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
            String ruta = servletContext.getRealPath("//Reportes//ActividadReporte.jasper");
            reporteActivi.DescargarActividad(ruta, this.NombreCurso);
            FacesContext.getCurrentInstance().getResponseComplete();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El reporte a sido generado exitosamente","exito"));

        } catch (Exception e) {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "El reporte no a sido generado","Error"));
        }

    }
    
}
