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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "as_metodo", catalog = "mydb", schema = "")

public class AsMetodo implements Serializable {
    private static final long serialVersionUID = 1L;
   
    
    @Id
    @Basic(optional = false)
    @Column(name = "c_metodo", nullable = false)
    private int cMetodo;
    
    @Basic(optional = false)
    @Column(name = "c_clase", nullable = false)
    private int cClase;
    
    @Column(name = "d_metodo", length = 50)
    private String dMetodo;
    @Column(name = "d_tipo_retorno", length = 50)
    private String dTipoRetorno;
    @Column(name = "c_usuario", length = 30)
    private String cUsuario;
    @Column(name = "f_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fIngreso;
    @Column(name = "b_activo")
    private Integer bActivo;
    @Column(name = "n_parametros")
    private Integer nParametros;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asMetodo")
    private Set<AsParametro> asParametroSet;
    @JoinColumn(name = "c_tipo_metodo", referencedColumnName = "c_tipo_metodo", nullable = false)
    @ManyToOne(optional = false)
    private TbTipoMetodo cTipoMetodo;
    @JoinColumn(name = "c_clase", referencedColumnName = "c_clase", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AsClase asClase;

    public AsMetodo() {
    }

   

    public int getcClase() {
		return cClase;
	}



	public void setcClase(int cClase) {
		this.cClase = cClase;
	}



	public int getcMetodo() {
		return cMetodo;
	}



	public void setcMetodo(int cMetodo) {
		this.cMetodo = cMetodo;
	}



	public String getDMetodo() {
        return dMetodo;
    }

    public void setDMetodo(String dMetodo) {
        this.dMetodo = dMetodo;
    }

    public String getDTipoRetorno() {
        return dTipoRetorno;
    }

    public void setDTipoRetorno(String dTipoRetorno) {
        this.dTipoRetorno = dTipoRetorno;
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

    public Integer getBActivo() {
        return bActivo;
    }

    public void setBActivo(Integer bActivo) {
        this.bActivo = bActivo;
    }

    public Integer getNParametros() {
        return nParametros;
    }

    public void setNParametros(Integer nParametros) {
        this.nParametros = nParametros;
    }

    public Set<AsParametro> getAsParametroSet() {
        return asParametroSet;
    }

    public void setAsParametroSet(Set<AsParametro> asParametroSet) {
        this.asParametroSet = asParametroSet;
    }

    public TbTipoMetodo getCTipoMetodo() {
        return cTipoMetodo;
    }

    public void setCTipoMetodo(TbTipoMetodo cTipoMetodo) {
        this.cTipoMetodo = cTipoMetodo;
    }

    public AsClase getAsClase() {
        return asClase;
    }

    public void setAsClase(AsClase asClase) {
        this.asClase = asClase;
    }

   
}
