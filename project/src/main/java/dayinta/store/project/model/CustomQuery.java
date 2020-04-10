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
@Table(name = "custom_query")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomQuery.findAll", query = "SELECT c FROM CustomQuery c")
    , @NamedQuery(name = "CustomQuery.findById", query = "SELECT c FROM CustomQuery c WHERE c.id = :id")
    , @NamedQuery(name = "CustomQuery.findByCode", query = "SELECT c FROM CustomQuery c WHERE c.code = :code")
    , @NamedQuery(name = "CustomQuery.findByValue", query = "SELECT c FROM CustomQuery c WHERE c.value = :value")
    , @NamedQuery(name = "CustomQuery.findByMessage", query = "SELECT c FROM CustomQuery c WHERE c.message = :message")})
public class CustomQuery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODE")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "VALUE")
    private String value;
    @Size(max = 400)
    @Column(name = "MESSAGE")
    private String message;

    public CustomQuery() {
    }

    public CustomQuery(Integer id) {
        this.id = id;
    }

    public CustomQuery(Integer id, String code, String value) {
        this.id = id;
        this.code = code;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        if (!(object instanceof CustomQuery)) {
            return false;
        }
        CustomQuery other = (CustomQuery) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dayinta.store.project.model.CustomQuery[ id=" + id + " ]";
    }
    
}
