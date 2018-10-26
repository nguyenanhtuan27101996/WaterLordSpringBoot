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
import javax.persistence.Table;

/**
 * @author User
 * @creatdate Oct 26, 2018
 * @modifieddate Oct 26, 2018
 * @content ...
 */
@Entity
@Table(name="Khoa")
public class Khoa {

        @Id
        @Column(name="MaKhoa")
        private String maKhoa;
        @Column(name="TenKhoa")
        private String tenKhoa;
        @Column(name="DiaChi")
        private String diaChi;
        @Column(name="DienThoai")
        private String dienThoai;
        @OneToMany
        @JoinColumn(name="MaKhoa")
        private Set<Lop> setLops;
        
        public Khoa(String maKhoa, String tenKhoa, String diaChi, String dienThoai) {
                super();
                this.maKhoa = maKhoa;
                this.tenKhoa = tenKhoa;
                this.diaChi = diaChi;
                this.dienThoai = dienThoai;
        }
        public Khoa() {
                
        }
        public String getMaKhoa() {
                return maKhoa;
        }
        public void setMaKhoa(String maKhoa) {
                this.maKhoa = maKhoa;
        }
        public String getTenKhoa() {
                return tenKhoa;
        }
        public void setTenKhoa(String tenKhoa) {
                this.tenKhoa = tenKhoa;
        }
        public String getDiaChi() {
                return diaChi;
        }
        public void setDiaChi(String diaChi) {
                this.diaChi = diaChi;
        }
        public String getDienThoai() {
                return dienThoai;
        }
        public void setDienThoai(String dienThoai) {
                this.dienThoai = dienThoai;
        }
        public Set<Lop> getSetLops() {
                return setLops;
        }
        public void setSetLops(Set<Lop> setLops) {
                this.setLops = setLops;
        }
        
        
}
