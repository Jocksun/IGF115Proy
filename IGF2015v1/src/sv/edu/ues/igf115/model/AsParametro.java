/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.igf115.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "as_parametro", catalog = "mydb", schema = "")

public class AsParametro implements Serializable {
	
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsParametroPK asParametroPK;
    @Column(name = "d_parametro", length = 50)
    private String dParametro;
    @Column(name = "d_tipo_parametro", length = 50)
    private String dTipoParametro;
    @Column(name = "c_usuario", length = 30)
    private String cUsuario;
    @Column(name = "f_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fIngreso;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumns({
    	@JoinColumn(name="c_clase"),
    	@JoinColumn(name="c_metodo"),
    	@JoinColumn(name="c_parametro"),
    })
    private Set<AsObservacion> asObservacionSet;
    //COMENTAR PARA QUITAR LAS LLAVES FORANEAS DESDE AQUI
    
    @JoinColumns({
        @JoinColumn(name = "c_clase", referencedColumnName = "c_clase", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "c_metodo", referencedColumnName = "c_metodo", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private AsMetodo asMetodo;
    //HASTA AQUI
    public AsParametro() {
    }

    public AsParametro(AsParametroPK asParametroPK) {
        this.asParametroPK = asParametroPK;
    }

    public AsParametro(int cClase, int cMetodo, int cParametro) {
        this.asParametroPK = new AsParametroPK(cClase, cMetodo, cParametro);
    }

    public AsParametroPK getAsParametroPK() {
        return asParametroPK;
    }

    public void setAsParametroPK(AsParametroPK asParametroPK) {
        this.asParametroPK = asParametroPK;
    }

    public String getDParametro() {
        return dParametro;
    }

    public void setDParametro(String dParametro) {
        this.dParametro = dParametro;
    }

    public String getDTipoParametro() {
        return dTipoParametro;
    }

    public void setDTipoParametro(String dTipoParametro) {
        this.dTipoParametro = dTipoParametro;
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

    public Set<AsObservacion> getAsObservacionSet() {
        return asObservacionSet;
    }

    public void setAsObservacionSet(Set<AsObservacion> asObservacionSet) {
        this.asObservacionSet = asObservacionSet;
    }
    //COMENTAR PARA QUITAR LAS LLAVES FORANEAS DESDE AQUI
    
    public AsMetodo getAsMetodo() {
        return asMetodo;
    }

    public void setAsMetodo(AsMetodo asMetodo) {
        this.asMetodo = asMetodo;
    }//HASTA AQUI
    
}
