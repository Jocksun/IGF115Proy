package sv.edu.ues.igf115.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Joao
 */
@Entity
@Table(name = "users", catalog = "mydb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"email"})})

//@NamedQueries({ 
//	@NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
//    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.uname := uname")})

public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "uname", nullable = false, length = 10)
    private String uname;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 10)
    private String password;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "registeredon")
    @Temporal(TemporalType.DATE)
    private Date registeredon;

    public Users() {
    }

    public Users(String uname) {
        this.uname = uname;
    }

    public Users(String uname, String password) {
        this.uname = uname;
        this.password = password;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisteredon() {
        return registeredon;
    }

    public void setRegisteredon(Date registeredon) {
        this.registeredon = registeredon;
    }

    
}
