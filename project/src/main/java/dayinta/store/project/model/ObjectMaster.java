/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayinta.store.project.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "object_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObjectMaster.findAll", query = "SELECT o FROM ObjectMaster o")
    , @NamedQuery(name = "ObjectMaster.findById", query = "SELECT o FROM ObjectMaster o WHERE o.id = :id")
    , @NamedQuery(name = "ObjectMaster.findByNamaBarang", query = "SELECT o FROM ObjectMaster o WHERE o.namaBarang = :namaBarang")
    , @NamedQuery(name = "ObjectMaster.findByHarga", query = "SELECT o FROM ObjectMaster o WHERE o.harga = :harga")
    , @NamedQuery(name = "ObjectMaster.findByStatus", query = "SELECT o FROM ObjectMaster o WHERE o.status = :status")})
public class ObjectMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAMA_BARANG")
    private String namaBarang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HARGA")
    private int harga;
    @Column(name = "status")
    private Integer status;

    public ObjectMaster() {
    }

    public ObjectMaster(Integer id) {
        this.id = id;
    }

    public ObjectMaster(Integer id, String namaBarang, int harga) {
        this.id = id;
        this.namaBarang = namaBarang;
        this.harga = harga;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObjectMaster)) {
            return false;
        }
        ObjectMaster other = (ObjectMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dayinta.store.project.model.ObjectMaster[ id=" + id + " ]";
    }
    
}
