/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@NamedQueries({
    @NamedQuery(name = "Citation.findAll", query = "SELECT s FROM Citation s"),
    @NamedQuery(name = "Citation.findByName", query = "SELECT s FROM Citation s WHERE s.firstName = :firstName AND s.lastName = :lastName"),
    @NamedQuery(name = "Citation.findByBusinessName", query = "SELECT s FROM Citation s WHERE s.businessName = :businessName"),
    @NamedQuery(name = "Citation.findByCitation", query = "SELECT s FROM Citation s WHERE s.citationNumber = :citationNumber"),
    @NamedQuery(name = "Citation.findByCaseNumber", query = "SELECT s FROM Citation s WHERE s.caseNumber = :caseNumber")})
public class Citation implements Serializable{
    private static final long serialVersionUID = 1L;
    @Size(min = 2, max = 10)
    private String firstName;
    @Size(min = 2, max = 10)
    private String lastName;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 4, max = 10)
    private String caseNumber;
    @NotNull
    @Size(min = 4, max = 15)    
    private String citationNumber; 
    private String businessName;
    private String dateStr;
    private String partyName;
    private String caseType;

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getCitationNumber() {
        return citationNumber;
    }

    public void setCitationNumber(String citationNumber) {
        this.citationNumber = citationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (caseNumber != null ? caseNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citation)) {
            return false;
        }
        Citation other = (Citation) object;
        if ((this.caseNumber == null && other.caseNumber != null) || (this.caseNumber != null && !this.caseNumber.equals(other.caseNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Case[ caseNumber=" + caseNumber + " ]";
    }
    
}