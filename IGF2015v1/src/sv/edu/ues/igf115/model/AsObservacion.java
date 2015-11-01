package sv.edu.ues.igf115.model;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Joao
 */
@Entity
@Table(name = "as_observacion", catalog = "mydb", schema = "")
@NamedQueries({
    @NamedQuery(name = "AsObservacion.findAll", query = "SELECT a FROM AsObservacion a"),
    @NamedQuery(name = "AsObservacion.findByCObservacion", query = "SELECT a FROM AsObservacion a WHERE a.cObservacion = :cObservacion"),
    @NamedQuery(name = "AsObservacion.findByDObservacion", query = "SELECT a FROM AsObservacion a WHERE a.dObservacion = :dObservacion"),
    @NamedQuery(name = "AsObservacion.findByCUsuario", query = "SELECT a FROM AsObservacion a WHERE a.cUsuario = :cUsuario"),
    @NamedQuery(name = "AsObservacion.findByFIngreso", query = "SELECT a FROM AsObservacion a WHERE a.fIngreso = :fIngreso"),
    @NamedQuery(name = "AsObservacion.findByBActivo", query = "SELECT a FROM AsObservacion a WHERE a.bActivo = :bActivo"),
    @NamedQuery(name = "AsObservacion.findByCClase", query = "SELECT a FROM AsObservacion a WHERE a.cClase = :cClase"),
    @NamedQuery(name = "AsObservacion.findByCAtributo", query = "SELECT a FROM AsObservacion a WHERE a.cAtributo = :cAtributo"),
    @NamedQuery(name = "AsObservacion.findByCMetodo", query = "SELECT a FROM AsObservacion a WHERE a.cMetodo = :cMetodo"),
    @NamedQuery(name = "AsObservacion.findByCParametro", query = "SELECT a FROM AsObservacion a WHERE a.cParametro = :cParametro")})
public class AsObservacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "c_observacion", nullable = false)
    private Integer cObservacion;
    @Column(name = "d_observacion", length = 4000)
    private String dObservacion;
    @Column(name = "c_usuario", length = 30)
    private String cUsuario;
    @Column(name = "f_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fIngreso;
    @Column(name = "b_activo")
    private Integer bActivo;
    @Basic(optional = false)
    @Column(name = "c_clase", nullable = false)
    private int cClase;
    @Column(name = "c_atributo")
    private Integer cAtributo;
    @Column(name = "c_metodo")
    private Integer cMetodo;
    @Column(name = "c_parametro")
    private Integer cParametro;

    public AsObservacion() {
    }

    public AsObservacion(Integer cObservacion) {
        this.cObservacion = cObservacion;
    }

    public AsObservacion(Integer cObservacion, int cClase) {
        this.cObservacion = cObservacion;
        this.cClase = cClase;
    }

    public Integer getCObservacion() {
        return cObservacion;
    }

    public void setCObservacion(Integer cObservacion) {
        this.cObservacion = cObservacion;
    }

    public String getDObservacion() {
        return dObservacion;
    }

    public void setDObservacion(String dObservacion) {
        this.dObservacion = dObservacion;
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

    public int getCClase() {
        return cClase;
    }

    public void setCClase(int cClase) {
        this.cClase = cClase;
    }

    public Integer getCAtributo() {
        return cAtributo;
    }

    public void setCAtributo(Integer cAtributo) {
        this.cAtributo = cAtributo;
    }

    public Integer getCMetodo() {
        return cMetodo;
    }

    public void setCMetodo(Integer cMetodo) {
        this.cMetodo = cMetodo;
    }

    public Integer getCParametro() {
        return cParametro;
    }

    public void setCParametro(Integer cParametro) {
        this.cParametro = cParametro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cObservacion != null ? cObservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsObservacion)) {
            return false;
        }
        AsObservacion other = (AsObservacion) object;
        if ((this.cObservacion == null && other.cObservacion != null) || (this.cObservacion != null && !this.cObservacion.equals(other.cObservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AsObservacion[ cObservacion=" + cObservacion + " ]";
    }
    
}
