/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import EntidadesReportes.ActividadEntidadReporte;
import EntidadesReportes.BeneficiadoEntidadReporte;
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

@Named(value = "reporteBeneficiadoControlador")
@SessionScoped
public class ReporteBeneficiadoControlador implements Serializable{

    public ReporteBeneficiadoControlador() {
    }
    
    private int comedor;

    public int getComedor() {
        return comedor;
    }

    public void setComedor(int comedor) {
        this.comedor = comedor;
    }
    
    public void descargarBeneficiado() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        try {
            BeneficiadoEntidadReporte reporteBenefi = new BeneficiadoEntidadReporte();
            

            FacesContext facesContext = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
            String ruta = servletContext.getRealPath("//Reportes//BeneficiadoReporte.jasper");
            reporteBenefi.DescargarBeneficiado(ruta, this.comedor);
            FacesContext.getCurrentInstance().getResponseComplete();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El reporte a sido generado exitosamente","exito"));

        } catch (Exception e) {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "El reporte no a sido generado","Error"));
        }

    }
    
}
