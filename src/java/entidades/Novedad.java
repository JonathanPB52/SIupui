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
@Table(name = "novedad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Novedad.findAll", query = "SELECT n FROM Novedad n")
    , @NamedQuery(name = "Novedad.findById", query = "SELECT n FROM Novedad n WHERE n.id = :id")
    , @NamedQuery(name = "Novedad.findByFechaDeNovedad", query = "SELECT n FROM Novedad n WHERE n.fechaDeNovedad = :fechaDeNovedad")
    , @NamedQuery(name = "Novedad.findByDescripcion", query = "SELECT n FROM Novedad n WHERE n.descripcion = :descripcion")})
public class Novedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fechaDeNovedad")
    @Temporal(TemporalType.DATE)
    private Date fechaDeNovedad;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Lob
    @Column(name = "evidenciaNovedad")
    private String evidenciaNovedad;
    @JoinColumn(name = "idcomedor", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Comedor idcomedor;
    @JoinColumn(name = "empleadoEncargado", referencedColumnName = "Id")
    @ManyToOne
    private Usuario empleadoEncargado;

    public Novedad() {
    }

    public Novedad(Integer id) {
        this.id = id;
    }

    public Novedad(Integer id, Date fechaDeNovedad, String descripcion, String evidenciaNovedad) {
        this.id = id;
        this.fechaDeNovedad = fechaDeNovedad;
        this.descripcion = descripcion;
        this.evidenciaNovedad = evidenciaNovedad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaDeNovedad() {
        return fechaDeNovedad;
    }

    public void setFechaDeNovedad(Date fechaDeNovedad) {
        this.fechaDeNovedad = fechaDeNovedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEvidenciaNovedad() {
        return evidenciaNovedad;
    }

    public void setEvidenciaNovedad(String evidenciaNovedad) {
        this.evidenciaNovedad = evidenciaNovedad;
    }

    public Comedor getIdcomedor() {
        return idcomedor;
    }

    public void setIdcomedor(Comedor idcomedor) {
        this.idcomedor = idcomedor;
    }

    public Usuario getEmpleadoEncargado() {
        return empleadoEncargado;
    }

    public void setEmpleadoEncargado(Usuario empleadoEncargado) {
        this.empleadoEncargado = empleadoEncargado;
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
        if (!(object instanceof Novedad)) {
            return false;
        }
        Novedad other = (Novedad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Novedad[ id=" + id + " ]";
    }
    
}
