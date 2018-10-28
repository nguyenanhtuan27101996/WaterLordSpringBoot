/**
 * Package: com.cmc.entity
 */
package com.cmc.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
	 * Create by: Thanh Dao 
	 * Create date: Oct 28, 2018
	 * Modifier: Thanh Dao 
	 * Modified date: Oct 28, 2018
	 * Description: Version 1.0
	 */
@Entity
@Table(name="HeDT")
public class HeDT {
	@Id
    @Column(name="MaHeDT", length=255)
    private String maHeDT;
    
    @Column(name="TenHeDT")
    private String tenHeDT;

        @OneToMany(cascade=CascadeType.ALL)
        @JoinColumn(name="MaHeDT")
        @JsonManagedReference
        private Set<Lop> setLops;
        
        public HeDT(String maHeDT, String tenHeDT) {
                super();
                this.maHeDT = maHeDT;
                this.tenHeDT = tenHeDT;
        }

    public HeDT() {
            
    }

    public String getMaHeDT() {
            return maHeDT;
    }
    
    public void setMaHeDT(String maHeDT) {
            this.maHeDT = maHeDT;
    }

    public String getTenHeDT() {
            return tenHeDT;
    }

    public void setTenHeDT(String tenHeDT) {
            this.tenHeDT = tenHeDT;
    }

    public Set<Lop> getSetLops() {
            return setLops;
    }

    public void setSetLops(Set<Lop> setLops) {
            this.setLops = setLops;
    }
}
