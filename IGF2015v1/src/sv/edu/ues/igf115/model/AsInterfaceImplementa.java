/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.igf115.model;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 *
 * @author Joao
 */
@Entity
@Table(name = "as_interface_implementa", catalog = "mydb", schema = "")
public class AsInterfaceImplementa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
   
    @Column(name = "c_interface_implementa", nullable = false)
    private Integer cInterfaceImplementa;
    @Basic(optional = false)
    
    @Column(name = "c_interface_hijo", nullable = false)
    private int cInterfaceHijo;
    @Basic(optional = false)
    
    @Column(name = "c_interface_padre", nullable = false)
    private int cInterfacePadre;

    public AsInterfaceImplementa() {
    }

    public AsInterfaceImplementa(Integer cInterfaceImplementa) {
        this.cInterfaceImplementa = cInterfaceImplementa;
    }

    public AsInterfaceImplementa(Integer cInterfaceImplementa, int cInterfaceHijo, int cInterfacePadre) {
        this.cInterfaceImplementa = cInterfaceImplementa;
        this.cInterfaceHijo = cInterfaceHijo;
        this.cInterfacePadre = cInterfacePadre;
    }

    public Integer getCInterfaceImplementa() {
        return cInterfaceImplementa;
    }

    public void setCInterfaceImplementa(Integer cInterfaceImplementa) {
        this.cInterfaceImplementa = cInterfaceImplementa;
    }

    public int getCInterfaceHijo() {
        return cInterfaceHijo;
    }

    public void setCInterfaceHijo(int cInterfaceHijo) {
        this.cInterfaceHijo = cInterfaceHijo;
    }

    public int getCInterfacePadre() {
        return cInterfacePadre;
    }

    public void setCInterfacePadre(int cInterfacePadre) {
        this.cInterfacePadre = cInterfacePadre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cInterfaceImplementa != null ? cInterfaceImplementa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsInterfaceImplementa)) {
            return false;
        }
        AsInterfaceImplementa other = (AsInterfaceImplementa) object;
        if ((this.cInterfaceImplementa == null && other.cInterfaceImplementa != null) || (this.cInterfaceImplementa != null && !this.cInterfaceImplementa.equals(other.cInterfaceImplementa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AsInterfaceImplementa[ cInterfaceImplementa=" + cInterfaceImplementa + " ]";
    }
    
}
