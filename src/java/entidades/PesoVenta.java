/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "peso_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PesoVenta.findAll", query = "SELECT p FROM PesoVenta p")
    , @NamedQuery(name = "PesoVenta.findById", query = "SELECT p FROM PesoVenta p WHERE p.id = :id")
    , @NamedQuery(name = "PesoVenta.findByPeso", query = "SELECT p FROM PesoVenta p WHERE p.peso = :peso")})
public class PesoVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "peso")
    private String peso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPeso")
    private List<Reciclaje> reciclajeList;

    public PesoVenta() {
    }

    public PesoVenta(Integer id) {
        this.id = id;
    }

    public PesoVenta(Integer id, String peso) {
        this.id = id;
        this.peso = peso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    @XmlTransient
    @JsonIgnore
    public List<Reciclaje> getReciclajeList() {
        return reciclajeList;
    }

    public void setReciclajeList(List<Reciclaje> reciclajeList) {
        this.reciclajeList = reciclajeList;
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
        if (!(object instanceof PesoVenta)) {
            return false;
        }
        PesoVenta other = (PesoVenta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PesoVenta[ id=" + id + " ]";
    }
    
}
