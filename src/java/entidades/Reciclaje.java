/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "reciclaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reciclaje.findAll", query = "SELECT r FROM Reciclaje r")
    , @NamedQuery(name = "Reciclaje.findById", query = "SELECT r FROM Reciclaje r WHERE r.id = :id")
    , @NamedQuery(name = "Reciclaje.findByFechaDeVenta", query = "SELECT r FROM Reciclaje r WHERE r.fechaDeVenta = :fechaDeVenta")
    , @NamedQuery(name = "Reciclaje.findByCantidad", query = "SELECT r FROM Reciclaje r WHERE r.cantidad = :cantidad")
    , @NamedQuery(name = "Reciclaje.findByValor", query = "SELECT r FROM Reciclaje r WHERE r.valor = :valor")})
public class Reciclaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fechaDeVenta")
    @Temporal(TemporalType.DATE)
    private Date fechaDeVenta;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Lob
    @Column(name = "facturaVenta")
    private String facturaVenta;
    @JoinColumn(name = "tipoDeMaterial", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private TipoDeMaterial tipoDeMaterial;
    @JoinColumn(name = "encargado", referencedColumnName = "Id")
    @ManyToOne
    private Usuario encargado;
    @JoinColumn(name = "tipo_peso", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PesoVenta tipoPeso;

    public Reciclaje() {
    }

    public Reciclaje(Integer id) {
        this.id = id;
    }

    public Reciclaje(Integer id, Date fechaDeVenta, int cantidad, double valor, String facturaVenta) {
        this.id = id;
        this.fechaDeVenta = fechaDeVenta;
        this.cantidad = cantidad;
        this.valor = valor;
        this.facturaVenta = facturaVenta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaDeVenta() {
        return fechaDeVenta;
    }

    public void setFechaDeVenta(Date fechaDeVenta) {
        this.fechaDeVenta = fechaDeVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFacturaVenta() {
        return facturaVenta;
    }

    public void setFacturaVenta(String facturaVenta) {
        this.facturaVenta = facturaVenta;
    }

    public TipoDeMaterial getTipoDeMaterial() {
        return tipoDeMaterial;
    }

    public void setTipoDeMaterial(TipoDeMaterial tipoDeMaterial) {
        this.tipoDeMaterial = tipoDeMaterial;
    }

    public Usuario getEncargado() {
        return encargado;
    }

    public void setEncargado(Usuario encargado) {
        this.encargado = encargado;
    }

    public PesoVenta getTipoPeso() {
        return tipoPeso;
    }

    public void setTipoPeso(PesoVenta tipoPeso) {
        this.tipoPeso = tipoPeso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reciclaje)) {
            return false;
        }
        Reciclaje other = (Reciclaje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Reciclaje[ id=" + id + " ]";
    }
    
}
