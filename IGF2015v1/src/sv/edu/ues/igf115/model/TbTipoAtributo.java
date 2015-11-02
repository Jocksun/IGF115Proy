
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
@Table(name = "tb_tipo_atributo", catalog = "mydb", schema = "")
@NamedQueries({
    @NamedQuery(name = "TbTipoAtributo.findAll", query = "SELECT t FROM TbTipoAtributo t"),
	@NamedQuery(name = "TbTipoAtributo.findByIdcTipoAtributo", query = "SELECT tipo FROM TbTipoAtributo tipo WHERE tipo.cTipoAtributo = :tipoAtributo")})
public class TbTipoAtributo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "c_tipo_atributo", nullable = false, length = 1)
    private String cTipoAtributo;
    @Column(name = "d_tipo_atributo", length = 50)
    private String dTipoAtributo;
    @Column(name = "f_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fIngreso;

    public TbTipoAtributo() {
    }

    public TbTipoAtributo(String cTipoAtributo) {
        this.cTipoAtributo = cTipoAtributo;
    }

    public String getCTipoAtributo() {
        return cTipoAtributo;
    }

    public void setCTipoAtributo(String cTipoAtributo) {
        this.cTipoAtributo = cTipoAtributo;
    }

    public String getDTipoAtributo() {
        return dTipoAtributo;
    }

    public void setDTipoAtributo(String dTipoAtributo) {
        this.dTipoAtributo = dTipoAtributo;
    }

    public Date getFIngreso() {
        return fIngreso;
    }

    public void setFIngreso(Date fIngreso) {
        this.fIngreso = fIngreso;
    }

        
}
