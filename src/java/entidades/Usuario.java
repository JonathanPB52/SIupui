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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findBySegundoNombre", query = "SELECT u FROM Usuario u WHERE u.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "Usuario.findByApellido", query = "SELECT u FROM Usuario u WHERE u.apellido = :apellido")
    , @NamedQuery(name = "Usuario.findBySegundoApellido", query = "SELECT u FROM Usuario u WHERE u.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Usuario.findByDocumento", query = "SELECT u FROM Usuario u WHERE u.documento = :documento")
    , @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuario.findByPass", query = "SELECT u FROM Usuario u WHERE u.pass = :pass")})
public class Usuario implements Serializable {

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
    @Column(name = "segundoApellido")
    private String segundoApellido;
    @Basic(optional = false)
    @Column(name = "documento")
    private String documento;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "pass")
    private String pass;
    @OneToMany(mappedBy = "empleadoEncargado")
    private List<Donacion> donacionList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "encargado")
    private Curso curso;
    @OneToMany(mappedBy = "empleadoEncargado")
    private List<Acudiente> acudienteList;
    @OneToMany(mappedBy = "empleadoEncargado")
    private List<Nino> ninoList;
    @OneToMany(mappedBy = "idUsuario")
    private List<Actividad> actividadList;
    @JoinColumn(name = "id_rol", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Rol idRol;
    @JoinColumn(name = "tipoDeDocumento", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private TipoDocumento tipoDeDocumento;
    @JoinColumn(name = "estado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estado estado;
    @OneToMany(mappedBy = "encargado")
    private List<Reciclaje> reciclajeList;
    @OneToMany(mappedBy = "empleadoEncargado")
    private List<Novedad> novedadList;
    @OneToMany(mappedBy = "empleadoEncargado")
    private List<Donante> donanteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "encargado")
    private List<Comedor> comedorList;
    @OneToMany(mappedBy = "empleadoEncargado")
    private List<Beneficiado> beneficiadoList;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String nombre, String apellido, String documento, String correo, String pass) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.correo = correo;
        this.pass = pass;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @XmlTransient
    @JsonIgnore
    public List<Donacion> getDonacionList() {
        return donacionList;
    }

    public void setDonacionList(List<Donacion> donacionList) {
        this.donacionList = donacionList;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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
    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    public TipoDocumento getTipoDeDocumento() {
        return tipoDeDocumento;
    }

    public void setTipoDeDocumento(TipoDocumento tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @XmlTransient
    @JsonIgnore
    public List<Reciclaje> getReciclajeList() {
        return reciclajeList;
    }

    public void setReciclajeList(List<Reciclaje> reciclajeList) {
        this.reciclajeList = reciclajeList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Novedad> getNovedadList() {
        return novedadList;
    }

    public void setNovedadList(List<Novedad> novedadList) {
        this.novedadList = novedadList;
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
    public List<Comedor> getComedorList() {
        return comedorList;
    }

    public void setComedorList(List<Comedor> comedorList) {
        this.comedorList = comedorList;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Usuario[ id=" + id + " ]";
    }
    
}
