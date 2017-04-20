/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.persistence.Transient;

/**
 *
 * @author Ula
 */
@Entity
@Table(name = "POMIAR_TEMPERATURA", catalog = "", schema = "UROMANIEC")
@NamedQueries({
    @NamedQuery(name = "PomiarTemperatura.findAll", query = "SELECT p FROM PomiarTemperatura p"),
    @NamedQuery(name = "PomiarTemperatura.findByPomiarId", query = "SELECT p FROM PomiarTemperatura p WHERE p.pomiarId = :pomiarId"),
    @NamedQuery(name = "PomiarTemperatura.findBySprzetId", query = "SELECT p FROM PomiarTemperatura p WHERE p.sprzetId = :sprzetId"),
    @NamedQuery(name = "PomiarTemperatura.findByMomentPomiaru", query = "SELECT p FROM PomiarTemperatura p WHERE p.momentPomiaru = :momentPomiaru"),
    @NamedQuery(name = "PomiarTemperatura.findByPomiarTemp", query = "SELECT p FROM PomiarTemperatura p WHERE p.pomiarTemp = :pomiarTemp")})
public class PomiarTemperatura implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "POMIAR_ID")
    private BigDecimal pomiarId;
    @Basic(optional = false)
    @Column(name = "SPRZET_ID")
    private BigInteger sprzetId;
    @Basic(optional = false)
    @Column(name = "MOMENT_POMIARU")
    @Temporal(TemporalType.TIMESTAMP)
    private Date momentPomiaru;
    @Column(name = "POMIAR_TEMP")
    private Double pomiarTemp;

    public PomiarTemperatura() {
    }

    public PomiarTemperatura(BigDecimal pomiarId) {
        this.pomiarId = pomiarId;
    }

    public PomiarTemperatura(BigDecimal pomiarId, BigInteger sprzetId, Date momentPomiaru) {
        this.pomiarId = pomiarId;
        this.sprzetId = sprzetId;
        this.momentPomiaru = momentPomiaru;
    }

    public BigDecimal getPomiarId() {
        return pomiarId;
    }

    public void setPomiarId(BigDecimal pomiarId) {
        BigDecimal oldPomiarId = this.pomiarId;
        this.pomiarId = pomiarId;
        changeSupport.firePropertyChange("pomiarId", oldPomiarId, pomiarId);
    }

    public BigInteger getSprzetId() {
        return sprzetId;
    }

    public void setSprzetId(BigInteger sprzetId) {
        BigInteger oldSprzetId = this.sprzetId;
        this.sprzetId = sprzetId;
        changeSupport.firePropertyChange("sprzetId", oldSprzetId, sprzetId);
    }

    public Date getMomentPomiaru() {
        return momentPomiaru;
    }

    public void setMomentPomiaru(Date momentPomiaru) {
        Date oldMomentPomiaru = this.momentPomiaru;
        this.momentPomiaru = momentPomiaru;
        changeSupport.firePropertyChange("momentPomiaru", oldMomentPomiaru, momentPomiaru);
    }

    public Double getPomiarTemp() {
        return pomiarTemp;
    }

    public void setPomiarTemp(Double pomiarTemp) {
        Double oldPomiarTemp = this.pomiarTemp;
        this.pomiarTemp = pomiarTemp;
        changeSupport.firePropertyChange("pomiarTemp", oldPomiarTemp, pomiarTemp);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pomiarId != null ? pomiarId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PomiarTemperatura)) {
            return false;
        }
        PomiarTemperatura other = (PomiarTemperatura) object;
        if ((this.pomiarId == null && other.pomiarId != null) || (this.pomiarId != null && !this.pomiarId.equals(other.pomiarId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.PomiarTemperatura[ pomiarId=" + pomiarId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
