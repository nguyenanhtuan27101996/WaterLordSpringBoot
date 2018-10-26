/**
 * 
 */
package com.cmc.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author User
 * @creatdate Oct 26, 2018
 * @modifieddate Oct 26, 2018
 * @content ...
 */
@Entity
@Table(name="SinhVien")
public class SinhVien {

        @Id
        @Column(name="MaSV")
        private String maSV;
        @Column(name="TenSV")
        private String tenSV;
        @Column(name="GioiTinh")
        private boolean gioiTinh;
        @Column(name="NgaySinh")
        private String ngaySinh;
        @Column(name="QueQuan")
        private String queQuan;
        
        @OneToOne
        @JoinColumn(name="MaLop")
        private Lop lop;

        public SinhVien(String maSV, String tenSV, boolean gioiTinh, String ngaySinh, String queQuan, Lop lop) {
                super();
                this.maSV = maSV;
                this.tenSV = tenSV;
                this.gioiTinh = gioiTinh;
                this.ngaySinh = ngaySinh;
                this.queQuan = queQuan;
                this.lop = lop;
        }

        public SinhVien() {
                super();
        }

        public String getMaSV() {
                return maSV;
        }

        public void setMaSV(String maSV) {
                this.maSV = maSV;
        }

        public String getTenSV() {
                return tenSV;
        }

        public void setTenSV(String tenSV) {
                this.tenSV = tenSV;
        }

        public boolean isGioiTinh() {
                return gioiTinh;
        }

        public void setGioiTinh(boolean gioiTinh) {
                this.gioiTinh = gioiTinh;
        }

        public String getNgaySinh() {
                return ngaySinh;
        }

        public void setNgaySinh(String ngaySinh) {
                this.ngaySinh = ngaySinh;
        }

        public String getQueQuan() {
                return queQuan;
        }

        public void setQueQuan(String queQuan) {
                this.queQuan = queQuan;
        }

        public Lop getLop() {
                return lop;
        }

        public void setLop(Lop lop) {
                this.lop = lop;
        }
        
        
}

