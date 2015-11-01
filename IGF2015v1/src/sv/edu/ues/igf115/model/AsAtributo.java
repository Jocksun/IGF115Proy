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
@Table(name = "as_atributo", catalog = "mydb", schema = "")
@NamedQueries({
    @NamedQuery(name = "AsAtributo.findAll", query = "SELECT a FROM AsAtributo a"),
    @NamedQuery(name = "AsAtributo.findByCClase", query = "SELECT a FROM AsAtributo a WHERE a.cClase = :cClase"),
    @NamedQuery(name = "AsAtributo.findByCAtributo", query = "SELECT a FROM AsAtributo a WHERE a.cAtributo = :cAtributo"),
    @NamedQuery(name = "AsAtributo.findByCMetodo", query = "SELECT a FROM AsAtributo a WHERE a.cMetodo = :cMetodo"),
    @NamedQuery(name = "AsAtributo.findByDAtributo", query = "SELECT a FROM AsAtributo a WHERE a.dAtributo = :dAtributo"),
    @NamedQuery(name = "AsAtributo.findByDTipoDatoAtributo", query = "SELECT a FROM AsAtributo a WHERE a.dTipoDatoAtributo = :dTipoDatoAtributo"),
    @NamedQuery(name = "AsAtributo.findByCUsuario", query = "SELECT a FROM AsAtributo a WHERE a.cUsuario = :cUsuario"),
    @NamedQuery(name = "AsAtributo.findByFIngreso", query = "SELECT a FROM AsAtributo a WHERE a.fIngreso = :fIngreso"),
    @NamedQuery(name = "AsAtributo.findByCTipoAtributo", query = "SELECT a FROM AsAtributo a WHERE a.cTipoAtributo = :cTipoAtributo")})
public class AsAtributo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "c_clase", nullable = false)
    private Integer cClase;
    @Basic(optional = false)
    @Column(name = "c_atributo", nullable = false)
    private int cAtributo;
    @Column(name = "c_metodo")
    private Integer cMetodo;
    @Column(name = "d_atributo", length = 50)
    private String dAtributo;
    @Column(name = "d_tipo_dato_atributo", length = 50)
    private String dTipoDatoAtributo;
    @Column(name = "c_usuario", length = 30)
    private String cUsuario;
    @Column(name = "f_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fIngreso;
    @Basic(optional = false)
    @Column(name = "c_tipo_atributo", nullable = false, length = 1)
    private String cTipoAtributo;

    public AsAtributo() {
    }

    public AsAtributo(Integer cClase) {
        this.cClase = cClase;
    }

    public AsAtributo(Integer cClase, int cAtributo, String cTipoAtributo) {
        this.cClase = cClase;
        this.cAtributo = cAtributo;
        this.cTipoAtributo = cTipoAtributo;
    }

    public Integer getCClase() {
        return cClase;
    }

    public void setCClase(Integer cClase) {
        this.cClase = cClase;
    }

    public int getCAtributo() {
        return cAtributo;
    }

    public void setCAtributo(int cAtributo) {
        this.cAtributo = cAtributo;
    }

    public Integer getCMetodo() {
        return cMetodo;
    }

    public void setCMetodo(Integer cMetodo) {
        this.cMetodo = cMetodo;
    }

    public String getDAtributo() {
        return dAtributo;
    }

    public void setDAtributo(String dAtributo) {
        this.dAtributo = dAtributo;
    }

    public String getDTipoDatoAtributo() {
        return dTipoDatoAtributo;
    }

    public void setDTipoDatoAtributo(String dTipoDatoAtributo) {
        this.dTipoDatoAtributo = dTipoDatoAtributo;
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

    public String getCTipoAtributo() {
        return cTipoAtributo;
    }

    public void setCTipoAtributo(String cTipoAtributo) {
        this.cTipoAtributo = cTipoAtributo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cClase != null ? cClase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsAtributo)) {
            return false;
        }
        AsAtributo other = (AsAtributo) object;
        if ((this.cClase == null && other.cClase != null) || (this.cClase != null && !this.cClase.equals(other.cClase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AsAtributo[ cClase=" + cClase + " ]";
    }
    
}
