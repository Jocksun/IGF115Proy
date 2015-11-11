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
import javax.persistence.Table;


@Entity
@Table(name = "as_clase_interface", catalog = "mydb", schema = "")

public class AsClaseInterface implements Serializable {
 
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_clase_interface", nullable = false)
    private Integer cClaseInterface;
    @JoinColumn(name = "c_interface", referencedColumnName = "c_interface", nullable = false)
    @ManyToOne(optional = false)
    private Integer  cInterface;
    @JoinColumn(name = "c_clase", referencedColumnName = "c_clase", nullable = false)
    @ManyToOne(optional = false)
    private Integer cClase;

    public AsClaseInterface() {
    }

    public AsClaseInterface(Integer cClaseInterface, Integer cInterface,Integer cClase) {
 		this.cClaseInterface = cClaseInterface;
 		this.cInterface = cInterface;
 		this.cClase = cClase;
 	}


    public Integer getCClaseInterface() {
        return cClaseInterface;
    }

    public void setCClaseInterface(Integer cClaseInterface) {
        this.cClaseInterface = cClaseInterface;
    }

    public Integer getCInterface() {
        return cInterface;
    }

    public void setCInterface(Integer cInterface) {
        this.cInterface = cInterface;
    }

    public Integer  getCClase() {
        return cClase;
    }

    public void setCClase(Integer cClase) {
        this.cClase = cClase;
    }

   
}
