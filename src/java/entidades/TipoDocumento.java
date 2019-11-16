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
@Table(name = "tipo_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t")
    , @NamedQuery(name = "TipoDocumento.findById", query = "SELECT t FROM TipoDocumento t WHERE t.id = :id")
    , @NamedQuery(name = "TipoDocumento.findByNombre", query = "SELECT t FROM TipoDocumento t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoDocumento.findByCodDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.codDocumento = :codDocumento")})
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "codDocumento")
    private String codDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumento")
    private List<Acudiente> acudienteList;
    @OneToMany(mappedBy = "tipoDocumento")
    private List<Nino> ninoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDeDocumento")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumento")
    private List<Beneficiado> beneficiadoList;

    public TipoDocumento() {
    }

    public TipoDocumento(Integer id) {
        this.id = id;
    }

    public TipoDocumento(Integer id, String nombre, String codDocumento) {
        this.id = id;
        this.nombre = nombre;
        this.codDocumento = codDocumento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodDocumento() {
        return codDocumento;
    }

    public void setCodDocumento(String codDocumento) {
        this.codDocumento = codDocumento;
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
    public List<Nino> getNinoList() {
        return ninoList;
    }

    public void setNinoList(List<Nino> ninoList) {
        this.ninoList = ninoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
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
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoDocumento[ id=" + id + " ]";
    }
    
}
