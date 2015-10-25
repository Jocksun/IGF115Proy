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
@Table(name = "tb_aplicativo", catalog = "mydb", schema = "")

public class TbAplicativo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "c_aplicativo", nullable = false, length = 5)
    private String cAplicativo;
    @Column(name = "d_aplicativo", length = 100)
    private String dAplicativo;
    @Column(name = "f_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fIngreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cAplicativo")
    private Set<AsClase> asClaseSet;

    public TbAplicativo() {
    }

    public TbAplicativo(String cAplicativo) {
        this.cAplicativo = cAplicativo;
    }

    public String getCAplicativo() {
        return cAplicativo;
    }

    public void setCAplicativo(String cAplicativo) {
        this.cAplicativo = cAplicativo;
    }

    public String getDAplicativo() {
        return dAplicativo;
    }

    public void setDAplicativo(String dAplicativo) {
        this.dAplicativo = dAplicativo;
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
