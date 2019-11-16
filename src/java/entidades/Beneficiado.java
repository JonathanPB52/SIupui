/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "beneficiados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Beneficiado.findAll", query = "SELECT b FROM Beneficiado b")
    , @NamedQuery(name = "Beneficiado.findById", query = "SELECT b FROM Beneficiado b WHERE b.id = :id")
    , @NamedQuery(name = "Beneficiado.findByNombre", query = "SELECT b FROM Beneficiado b WHERE b.nombre = :nombre")
    , @NamedQuery(name = "Beneficiado.findBySegundoNombre", query = "SELECT b FROM Beneficiado b WHERE b.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "Beneficiado.findByApellido", query = "SELECT b FROM Beneficiado b WHERE b.apellido = :apellido")
    , @NamedQuery(name = "Beneficiado.findBySegundoApellido", query = "SELECT b FROM Beneficiado b WHERE b.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Beneficiado.findByDireccion", query = "SELECT b FROM Beneficiado b WHERE b.direccion = :direccion")
    , @NamedQuery(name = "Beneficiado.findByTelefono", query = "SELECT b FROM Beneficiado b WHERE b.telefono = :telefono")
    , @NamedQuery(name = "Beneficiado.findByDocumento", query = "SELECT b FROM Beneficiado b WHERE b.documento = :documento")})
public class Beneficiado implements Serializable {

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
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "documento")
    private String documento;
    @JoinColumn(name = "idcomedor", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Comedor idcomedor;
    @JoinColumn(name = "tipoTelefono", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tipotelefono tipoTelefono;
    @JoinColumn(name = "localidad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Localidad localidad;
    @JoinColumn(name = "tipo_documento", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private TipoDocumento tipoDocumento;
    @JoinColumn(name = "empleadoEncargado", referencedColumnName = "Id")
    @ManyToOne
    private Usuario empleadoEncargado;

    public Beneficiado() {
    }

    public Beneficiado(Integer id) {
        this.id = id;
    }

    public Beneficiado(Integer id, String nombre, String apellido, String segundoApellido, String direccion, String telefono, String documento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.segundoApellido = segundoApellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.documento = documento;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Comedor getIdcomedor() {
        return idcomedor;
    }

    public void setIdcomedor(Comedor idcomedor) {
        this.idcomedor = idcomedor;
    }

    public Tipotelefono getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(Tipotelefono tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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
        if (!(object instanceof Beneficiado)) {
            return false;
        }
        Beneficiado other = (Beneficiado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Beneficiado[ id=" + id + " ]";
    }
    
}
