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
@Table(name = "tb_tipo_metodo", catalog = "mydb", schema = "")

public class TbTipoMetodo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "c_tipo_metodo", nullable = false, length = 1)
    private String cTipoMetodo;
    @Column(name = "d_tipo_metodo", length = 20)
    private String dTipoMetodo;
    @Column(name = "f_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fIngreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cTipoMetodo")
    private Set<AsMetodo> asMetodoSet;

    public TbTipoMetodo() {
    }

    public TbTipoMetodo(String cTipoMetodo) {
        this.cTipoMetodo = cTipoMetodo;
    }

    public String getCTipoMetodo() {
        return cTipoMetodo;
    }

    public void setCTipoMetodo(String cTipoMetodo) {
        this.cTipoMetodo = cTipoMetodo;
    }

    public String getDTipoMetodo() {
        return dTipoMetodo;
    }

    public void setDTipoMetodo(String dTipoMetodo) {
        this.dTipoMetodo = dTipoMetodo;
    }

    public Date getFIngreso() {
        return fIngreso;
    }

    public void setFIngreso(Date fIngreso) {
        this.fIngreso = fIngreso;
    }

    public Set<AsMetodo> getAsMetodoSet() {
        return asMetodoSet;
    }

    public void setAsMetodoSet(Set<AsMetodo> asMetodoSet) {
        this.asMetodoSet = asMetodoSet;
    }

    
}
