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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "donante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donante.findAll", query = "SELECT d FROM Donante d")
    , @NamedQuery(name = "Donante.findById", query = "SELECT d FROM Donante d WHERE d.id = :id")
    , @NamedQuery(name = "Donante.findByNombre", query = "SELECT d FROM Donante d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Donante.findBySegundoNombre", query = "SELECT d FROM Donante d WHERE d.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "Donante.findByApellido", query = "SELECT d FROM Donante d WHERE d.apellido = :apellido")
    , @NamedQuery(name = "Donante.findBySegundoApellido", query = "SELECT d FROM Donante d WHERE d.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Donante.findByTelefono", query = "SELECT d FROM Donante d WHERE d.telefono = :telefono")})
public class Donante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "segundoNombre")
    private String segundoNombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "segundoApellido")
    private String segundoApellido;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "donante")
    private List<Donacion> donacionList;
    @JoinColumn(name = "tipoTelefono", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tipotelefono tipoTelefono;
    @JoinColumn(name = "empleadoEncargado", referencedColumnName = "Id")
    @ManyToOne
    private Usuario empleadoEncargado;

    public Donante() {
    }

    public Donante(Integer id) {
        this.id = id;
    }

    public Donante(Integer id, String nombre, String apellido, String segundoApellido, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
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

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    @JsonIgnore
    public List<Donacion> getDonacionList() {
        return donacionList;
    }

    public void setDonacionList(List<Donacion> donacionList) {
        this.donacionList = donacionList;
    }

    public Tipotelefono getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(Tipotelefono tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
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
        if (!(object instanceof Donante)) {
            return false;
        }
        Donante other = (Donante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Donante[ id=" + id + " ]";
    }
    
}
