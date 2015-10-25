/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.igf115.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class AsMetodoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "c_clase", nullable = false)
    private int cClase;
    @Basic(optional = false)
    @Column(name = "c_metodo", nullable = false)
    private int cMetodo;

    public AsMetodoPK() {
    }

    public AsMetodoPK(int cClase, int cMetodo) {
        this.cClase = cClase;
        this.cMetodo = cMetodo;
    }

    public int getCClase() {
        return cClase;
    }

    public void setCClase(int cClase) {
        this.cClase = cClase;
    }

    public int getCMetodo() {
        return cMetodo;
    }

    public void setCMetodo(int cMetodo) {
        this.cMetodo = cMetodo;
    }

   
}
