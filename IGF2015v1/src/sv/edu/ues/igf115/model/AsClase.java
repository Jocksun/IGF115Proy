/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.igf115.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "as_clase", catalog = "mydb", schema = "")

  
public class AsClase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_clase", nullable = false)
    private Integer cClase;
    @Basic(optional = false)
    @Column(name = "d_clase", nullable = false, length = 50)
    private String dClase;
    @Column(name = "c_usuario", length = 30)
    private String cUsuario;
    @Basic(optional = false)
    @Column(name = "f_ingreso", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fIngreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cClase")
    private Set<AsClaseInterface> asClaseInterfaceSet;
    @JoinColumn(name = "c_tipo_clase", referencedColumnName = "c_tipo_clase", nullable = false)
    @ManyToOne(optional = false)
    private TbTipoClase cTipoClase;
    @OneToMany(mappedBy = "cClasePadre")
    private Set<AsClase> asClaseSet;
    @JoinColumn(name = "c_clase_padre", referencedColumnName = "c_clase")
    @ManyToOne
    private AsClase cClasePadre;
    @JoinColumn(name = "c_aplicativo", referencedColumnName = "c_aplicativo", nullable = false)
    @ManyToOne(optional = false)
    private TbAplicativo cAplicativo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asClase")
    private Set<AsMetodo> asMetodoSet;

    public AsClase() {
    }

    public AsClase(Integer cClase) {
        this.cClase = cClase;
    }

    public AsClase(Integer cClase, String dClase, Date fIngreso) {
        this.cClase = cClase;
        this.dClase = dClase;
        this.fIngreso = fIngreso;
    }

    public Integer getCClase() {
        return cClase;
    }

    public void setCClase(Integer cClase) {
        this.cClase = cClase;
    }

    public String getDClase() {
        return dClase;
    }

    public void setDClase(String dClase) {
        this.dClase = dClase;
    }

    public String getCUsuario() {
        return cUsuario;
    }

    public void setCUsuario(String cUsuario) {
        this.cUsuario = cUsuario;
    }

    public Date getFIngreso() {
        return fIngreso;
    }

    public void setFIngreso(Date fIngreso) {
        this.fIngreso = fIngreso;
    }

    public Set<AsClaseInterface> getAsClaseInterfaceSet() {
        return asClaseInterfaceSet;
    }

    public void setAsClaseInterfaceSet(Set<AsClaseInterface> asClaseInterfaceSet) {
        this.asClaseInterfaceSet = asClaseInterfaceSet;
    }

    public TbTipoClase getCTipoClase() {
        return cTipoClase;
    }

    public void setCTipoClase(TbTipoClase cTipoClase) {
        this.cTipoClase = cTipoClase;
    }

    public Set<AsClase> getAsClaseSet() {
        return asClaseSet;
    }

    public void setAsClaseSet(Set<AsClase> asClaseSet) {
        this.asClaseSet = asClaseSet;
    }

    public AsClase getCClasePadre() {
        return cClasePadre;
    }

    public void setCClasePadre(AsClase cClasePadre) {
        this.cClasePadre = cClasePadre;
    }

    public TbAplicativo getCAplicativo() {
        return cAplicativo;
    }

    public void setCAplicativo(TbAplicativo cAplicativo) {
        this.cAplicativo = cAplicativo;
    }

    public Set<AsMetodo> getAsMetodoSet() {
        return asMetodoSet;
    }

    public void setAsMetodoSet(Set<AsMetodo> asMetodoSet) {
        this.asMetodoSet = asMetodoSet;
    }

       
}
