/**
 * 
 */
package com.cmc.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author NATuan3
 * @creatdate Oct 26, 2018
 * @modifieddate Oct 26, 2018
 * @content ...
 */
@Entity
@Table(name="KhoaHoc")
public class KhoaHoc {

        @Id
        @Column(name="MaKhoaHoc")
        private String maKhoaHoc;
        
        @Column(name="TenKhoaHoc")
        private String tenKhoaHoc;
        
        @OneToMany
        @JoinColumn(name="MaKhoaHoc")
        private Set<Lop> setLops;

        public KhoaHoc(String maKhoaHoc, String tenKhoaHoc, Set<Lop> setLops) {
                super();
                this.maKhoaHoc = maKhoaHoc;
                this.tenKhoaHoc = tenKhoaHoc;
                this.setLops = setLops;
        }

        public KhoaHoc() {
                super();
        }

        public String getMaKhoaHoc() {
                return maKhoaHoc;
        }

        public void setMaKhoaHoc(String maKhoaHoc) {
                this.maKhoaHoc = maKhoaHoc;
        }

        public String getTenKhoaHoc() {
                return tenKhoaHoc;
        }

        public void setTenKhoaHoc(String tenKhoaHoc) {
                this.tenKhoaHoc = tenKhoaHoc;
        }

        public Set<Lop> getSetLops() {
                return setLops;
        }

        public void setSetLops(Set<Lop> setLops) {
                this.setLops = setLops;
        }
        
        
}
