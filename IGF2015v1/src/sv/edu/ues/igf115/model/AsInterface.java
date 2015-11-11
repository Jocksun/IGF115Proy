package sv.edu.ues.igf115.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "as_interface", catalog = "mydb", schema = "")
public class AsInterface implements Serializable{
	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "c_interface", nullable = false)
	private Short c_interface;
	@Column(name = "d_interface", length = 50)
	private String d_interface;
	@Column(name = "c_usuario", length = 30)
	private String c_usuario;
	@Column(name = "f_ingreso")
    @Temporal(TemporalType.DATE)
	private Date fIngreso;
	
	public AsInterface(){
		
	}
	public AsInterface(String d_interface, String c_usuario,	Date fIngreso) {
		super();
		this.d_interface = d_interface;
		this.c_usuario = c_usuario;
		this.fIngreso = fIngreso;
	}
	
	public Short getC_interface() {
		return c_interface;
	}
	public void setC_interface(Short c_interface) {
		this.c_interface = c_interface;
	}
	public String getD_interface() {
		return d_interface;
	}
	public void setD_interface(String d_interface) {
		this.d_interface = d_interface;
	}
	public String getC_usuario() {
		return c_usuario;
	}
	public void setC_usuario(String c_usuario) {
		this.c_usuario = c_usuario;
	}
	public Date getfIngreso() {
		return fIngreso;
	}
	public void setfIngreso(Date fIngreso) {
		this.fIngreso = fIngreso;
	}
	

}
