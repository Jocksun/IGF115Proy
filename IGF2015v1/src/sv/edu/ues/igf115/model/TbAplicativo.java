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
import java.util.List;


@Entity
@Table(name = "tb_aplicativo", catalog = "mydb", schema = "")

public class TbAplicativo implements Serializable {
    private static final long serialVersionUID = 1L;
  //DECLARACIONES

  	private String c_aplicativo;
  	private String d_aplicativo;
  	private Date f_ingreso;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cAplicativo")
    private Set<AsClase> asClaseSet;

    public TbAplicativo() {
	}

    //CLASE CONSTRUCTOR RECIBE PARAMETROS
	public TbAplicativo(String c_aplicativo, String d_aplicativo, Date f_ingreso) {
		this.c_aplicativo = c_aplicativo;
		this.d_aplicativo = d_aplicativo;
		this.f_ingreso = f_ingreso;
	}
	@Id
	@Basic(optional = false)
	@Column(name = "c_aplicativo")
	public String getC_aplicativo() {
		return c_aplicativo;
	}

	public void setC_aplicativo(String c_aplicativo) {
		this.c_aplicativo = c_aplicativo;
	}
	
	@Basic(optional = false)
	@Column(name = "d_aplicativo")
	public String getD_aplicativo() {
		return d_aplicativo;
	}

	public void setD_aplicativo(String d_aplicativo) {
		this.d_aplicativo = d_aplicativo;
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
