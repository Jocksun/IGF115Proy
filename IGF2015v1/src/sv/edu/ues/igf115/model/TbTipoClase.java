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
import java.util.Date;
import java.util.List;

//ANOTACION
@Entity
@Table(name = "tb_tipo_clase", catalog = "mydb", schema = "")

public class TbTipoClase implements Serializable {
	//DECLARACIONES
	private static final long serialVersionUID = 1L;
	private String c_tipo_clase;
	private String d_tipo_clase;
	private Date f_ingreso;
	private Set<AsClase> asClaseSet;
	
    
    //CLASE CONSTRUCTOR
    public TbTipoClase() {
	}

    //CLASE CONSTRUCTOR RECIBE PARAMETROS
	public TbTipoClase(String c_tipo_clase, String d_tipo_clase, Date f_ingreso) {
		this.c_tipo_clase = c_tipo_clase;
		this.d_tipo_clase = d_tipo_clase;
		this.f_ingreso = f_ingreso;
	}
   
	
	//METODOS GET Y SET
	@Id
	@Basic(optional = false)
	@Column(name = "c_tipo_clase")
	public String getC_tipo_clase() {
		return c_tipo_clase;
	}

	public void setC_tipo_clase(String c_tipo_clase) {
		this.c_tipo_clase = c_tipo_clase;
	}
	
	@Basic(optional = false)
	@Column(name = "d_tipo_clase")
	public String getD_tipo_clase() {
		return d_tipo_clase;
	}

	public void setD_tipo_clase(String d_tipo_clase) {
		this.d_tipo_clase = d_tipo_clase;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "f_ingreso", length = 10)
	public Date getF_ingreso() {
		return this.f_ingreso;
	}

	public void setF_ingreso(Date f_ingreso) {
		this.f_ingreso = f_ingreso;
	}
	/*
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "c_tipo_clase")
    public Set<AsClase> getAsClaseSet() {
        return asClaseSet;
    }
	
    public void setAsClaseSet(Set<AsClase> asClaseSet) {
        this.asClaseSet = asClaseSet;
    }
*/
  
}
