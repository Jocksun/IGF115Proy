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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_tipo_clase", catalog = "mydb", schema = "")

public class TbTipoClase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "c_tipo_clase", nullable = false, length = 5)
    private String cTipoClase;
    @Column(name = "d_tipo_clase", length = 50)
    private String dTipoClase;
    @Column(name = "f_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fIngreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cTipoClase")
    private Set<AsClase> asClaseSet;

    public TbTipoClase() {
    }

    public TbTipoClase(String cTipoClase) {
        this.cTipoClase = cTipoClase;
    }

    public String getCTipoClase() {
        return cTipoClase;
    }

    public void setCTipoClase(String cTipoClase) {
        this.cTipoClase = cTipoClase;
    }

    public String getDTipoClase() {
        return dTipoClase;
    }

    public void setDTipoClase(String dTipoClase) {
        this.dTipoClase = dTipoClase;
    }

    public Date getFIngreso() {
        return fIngreso;
    }

    public void setFIngreso(Date fIngreso) {
        this.fIngreso = fIngreso;
    }

    public Set<AsClase> getAsClaseSet() {
        return asClaseSet;
    }

    public void setAsClaseSet(Set<AsClase> asClaseSet) {
        this.asClaseSet = asClaseSet;
    }

  
}
