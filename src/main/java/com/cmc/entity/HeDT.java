/**
 * 
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

/**
 * @author User
 * @creatdate Oct 26, 2018
 * @modifieddate Oct 26, 2018
 * @content ...
 */
@Entity
@Table(name="HeDT")
public class HeDT {
        
        @Id
        @Column(name="MaHeDT")
        private String maHeDT;
        
        @Column(name="TenHeDT")
        private String tenHeDT;

        @OneToMany(cascade=CascadeType.ALL)
        @JoinColumn(name="MaHeDT")
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
