/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import EntidadesReportes.ActividadEntidadReporte;
import EntidadesReportes.DonacionEntidadReporte;
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

@Named(value = "reporteDonacionControlador")
@SessionScoped
public class ReporteDonacionControlador implements Serializable{

    public ReporteDonacionControlador() {
    }
    
    private String TipoDeDonacion;

    public String getTipoDeDonacion() {
        return TipoDeDonacion;
    }

    public void setTipoDeDonacion(String TipoDeDonacion) {
        this.TipoDeDonacion = TipoDeDonacion;
    }
    
    public void descargarDonacion() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        try {
            DonacionEntidadReporte reporteDonacion = new DonacionEntidadReporte();
            

            FacesContext facesContext = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
            String ruta = servletContext.getRealPath("//Reportes//DonacionReporte.jasper");
            reporteDonacion.DescargarDonacion(ruta, this.TipoDeDonacion);
            FacesContext.getCurrentInstance().getResponseComplete();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El reporte a sido generado exitosamente","exito"));

        } catch (Exception e) {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "El reporte no a sido generado","Error"));
        }

    }
    
}
