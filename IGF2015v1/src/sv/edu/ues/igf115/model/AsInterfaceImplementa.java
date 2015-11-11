/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.igf115.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "as_interface_implementa", catalog = "mydb", schema = "")
public class AsInterfaceImplementa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "c_interface_implementa", nullable = false)
	private Integer cInterfaceImplementa;
	@JoinColumn(name = "c_interface_padre", referencedColumnName = "c_interface", nullable = false)
	@ManyToOne(optional = false)
	private AsInterface cInterfacePadre;
	@JoinColumn(name = "c_interface_hijo", referencedColumnName = "c_interface", nullable = false)
	@ManyToOne(optional = false)
	private AsInterface cInterfaceHijo;

	AsInterfaceImplementa() {
	}

	public AsInterfaceImplementa(Integer cInterfaceImplementa,
			AsInterface cInterfacePadre, AsInterface cInterfaceHijo) {
		this.cInterfaceImplementa = cInterfaceImplementa;
		this.cInterfacePadre = cInterfacePadre;
		this.cInterfaceHijo = cInterfaceHijo;
	}

	public AsInterfaceImplementa(Integer cInterfaceImplementa) {
		this.cInterfaceImplementa = cInterfaceImplementa;
	}

	public Integer getCInterfaceImplementa() {
		return cInterfaceImplementa;
	}

	public void setCInterfaceImplementa(Integer cInterfaceImplementa) {
		this.cInterfaceImplementa = cInterfaceImplementa;
	}

	public AsInterface getCInterfacePadre() {
		return cInterfacePadre;
	}

	public void setCInterfacePadre(AsInterface cInterfacePadre) {
		this.cInterfacePadre = cInterfacePadre;
	}

	public AsInterface getCInterfaceHijo() {
		return cInterfaceHijo;
	}

	public void setCInterfaceHijo(AsInterface cInterfaceHijo) {
		this.cInterfaceHijo = cInterfaceHijo;
	}

}
