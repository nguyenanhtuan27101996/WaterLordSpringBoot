/**
 * 
 */
package com.cmc.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author User
 * @creatdate Oct 26, 2018
 * @modifieddate Oct 26, 2018
 * @content ...
 */
@Entity
@Table(name="Lop")
public class Lop {
        
        @Id
        @Column(name="MaLop")
        private String maLop;
        
        @Column(name="TenLop")
        private String tenLop;
        
        @OneToOne
        @JoinColumn(name="MaKhoa")
        @JsonBackReference
        private Khoa khoa;
        
        @OneToOne
        @JsonBackReference
        @JoinColumn(name="MaHeDT")
        private HeDT heDT;
        
        @OneToOne
        @JsonBackReference
        @JoinColumn(name="MaKhoaHoc")
        private KhoaHoc khoaHoc;
        
        @OneToMany(cascade=CascadeType.REMOVE)
        @JoinColumn(name="MaLop")
        @JsonManagedReference
        private Set<SinhVien> setSinhViens;
        
        public Lop(String maLop, String tenLop, Khoa khoa, HeDT heDT, KhoaHoc khoaHoc) {
                super();
                this.maLop = maLop;
                this.tenLop = tenLop;
                this.khoa = khoa;
                this.heDT = heDT;
                this.khoaHoc = khoaHoc;
        }

        public Lop() {
                super();
        }

        public String getMaLop() {
                return maLop;
        }

        public void setMaLop(String maLop) {
                this.maLop = maLop;
        }

        public String getTenLop() {
                return tenLop;
        }

        public void setTenLop(String tenLop) {
                this.tenLop = tenLop;
        }

        public Khoa getKhoa() {
                return khoa;
        }

        public void setKhoa(Khoa khoa) {
                this.khoa = khoa;
        }

        public HeDT getHeDT() {
                return heDT;
        }

        public void setHeDT(HeDT heDT) {
                this.heDT = heDT;
        }

        public KhoaHoc getKhoaHoc() {
                return khoaHoc;
        }

        public void setKhoaHoc(KhoaHoc khoaHoc) {
                this.khoaHoc = khoaHoc;
        }

        public Set<SinhVien> getSetSinhViens() {
                return setSinhViens;
        }

        public void setSetSinhViens(Set<SinhVien> setSinhViens) {
                this.setSinhViens = setSinhViens;
        }
        
        
        
        
        
}
