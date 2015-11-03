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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "as_interface", catalog = "mydb", schema = "")
@NamedQueries({
	@NamedQuery(name = "As_interface.findAll", query = "SELECT d FROM As_interface d"),
	@NamedQuery(name = "As_interface.findByIdDep", query = "SELECT d FROM As_interface d WHERE d.c_interface = :c_interface"),
	@NamedQuery(name = "As_interface.findByNombreDep", query = "SELECT d FROM As_interface d WHERE d.c_interface = :c_interface") })

public class AsInterface implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_interface", nullable = false)
    private Integer cInterface;
    @Column(name = "d_interface", length = 50)
    private String dInterface;
    @Column(name = "c_usuario", length = 30)
    private String cUsuario;
    @Column(name = "f_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fIngreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cInterface")
    private Set<AsClaseInterface> asClaseInterfaceSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cInterfacePadre")
    private Set<AsInterfaceImplementa> asInterfaceImplementaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cInterfaceHijo")
    private Set<AsInterfaceImplementa> asInterfaceImplementaSet1;

    public AsInterface() {
    }

    public AsInterface(Integer cInterface, String dInterface, String cUsuario, Date fIngreso) {
        this.cInterface = cInterface;
        this.dInterface = dInterface;
        this.cUsuario = cUsuario;
        this.fIngreso = fIngreso;
    }

    public Integer getCInterface() {
        return cInterface;
    }

    public void setCInterface(Integer cInterface) {
        this.cInterface = cInterface;
    }

    public String getDInterface() {
        return dInterface;
    }

    public void setDInterface(String dInterface) {
        this.dInterface = dInterface;
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

    public Set<AsInterfaceImplementa> getAsInterfaceImplementaSet() {
        return asInterfaceImplementaSet;
    }

    public void setAsInterfaceImplementaSet(Set<AsInterfaceImplementa> asInterfaceImplementaSet) {
        this.asInterfaceImplementaSet = asInterfaceImplementaSet;
    }

    public Set<AsInterfaceImplementa> getAsInterfaceImplementaSet1() {
        return asInterfaceImplementaSet1;
    }

    public void setAsInterfaceImplementaSet1(Set<AsInterfaceImplementa> asInterfaceImplementaSet1) {
        this.asInterfaceImplementaSet1 = asInterfaceImplementaSet1;
    }

   
}
