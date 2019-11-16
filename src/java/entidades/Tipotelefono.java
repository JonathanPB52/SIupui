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
@Table(name = "tipotelefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipotelefono.findAll", query = "SELECT t FROM Tipotelefono t")
    , @NamedQuery(name = "Tipotelefono.findById", query = "SELECT t FROM Tipotelefono t WHERE t.id = :id")
    , @NamedQuery(name = "Tipotelefono.findByTipoDeTelefono", query = "SELECT t FROM Tipotelefono t WHERE t.tipoDeTelefono = :tipoDeTelefono")})
public class Tipotelefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tipoDeTelefono")
    private String tipoDeTelefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoTelefono")
    private List<Acudiente> acudienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoTelefono")
    private List<Donante> donanteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoTelefono")
    private List<Beneficiado> beneficiadoList;

    public Tipotelefono() {
    }

    public Tipotelefono(Integer id) {
        this.id = id;
    }

    public Tipotelefono(Integer id, String tipoDeTelefono) {
        this.id = id;
        this.tipoDeTelefono = tipoDeTelefono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoDeTelefono() {
        return tipoDeTelefono;
    }

    public void setTipoDeTelefono(String tipoDeTelefono) {
        this.tipoDeTelefono = tipoDeTelefono;
    }

    @XmlTransient
    @JsonIgnore
    public List<Acudiente> getAcudienteList() {
        return acudienteList;
    }

    public void setAcudienteList(List<Acudiente> acudienteList) {
        this.acudienteList = acudienteList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Donante> getDonanteList() {
        return donanteList;
    }

    public void setDonanteList(List<Donante> donanteList) {
        this.donanteList = donanteList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Beneficiado> getBeneficiadoList() {
        return beneficiadoList;
    }

    public void setBeneficiadoList(List<Beneficiado> beneficiadoList) {
        this.beneficiadoList = beneficiadoList;
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
        if (!(object instanceof Tipotelefono)) {
            return false;
        }
        Tipotelefono other = (Tipotelefono) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tipotelefono[ id=" + id + " ]";
    }
    
}
