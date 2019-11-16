/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos;

import java.io.Serializable;
 
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
/**
 *
 * @author Jonathan
 */
@ManagedBean
public class ControladorGrafico implements Serializable {
    private static final long serialVersionUID = 6401166601481931346L;
	
	private CartesianChartModel viviendas;  
 
	public CartesianChartModel getViviendas() {
		return viviendas;
	}
 
	@PostConstruct
	public void init(){
		viviendas = new CartesianChartModel();
		
		final ChartSeries venta  = new ChartSeries("Venta");
		venta.set("2008", 800);
		venta.set("2009", 1300);
		venta.set("2010", 700);
		venta.set("2011", 500);
		
		final ChartSeries alquiler  = new ChartSeries("Alquiler");
		alquiler.set("2008", 1200);
		alquiler.set("2009", 1100);
		alquiler.set("2010", 1700);
		alquiler.set("2011", 1900);
		
		viviendas.addSeries(venta);
		viviendas.addSeries(alquiler);
 
	}
}
