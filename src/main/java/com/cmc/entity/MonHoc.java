/**
 * 
 */
package com.cmc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author NATuan3
 * @creatdate Oct 26, 2018
 * @modifieddate Oct 26, 2018
 * @content ...
 */
@Entity
@Table(name="MonHoc")
public class MonHoc {
        
        @Id
        @Column(name="MaMH")
        private String maMH;
        
        @Column(name="TenMH")
        private String tenMH;
        
        @Column(name="SoTrinh")
        private int soTrinh;

        public MonHoc(String maMH, String tenMH, int soTrinh) {
                super();
                this.maMH = maMH;
                this.tenMH = tenMH;
                this.soTrinh = soTrinh;
        }

        public MonHoc() {
                
        }

        public String getMaMH() {
                return maMH;
        }

        public void setMaMH(String maMH) {
                this.maMH = maMH;
        }

        public String getTenMH() {
                return tenMH;
        }

        public void setTenMH(String tenMH) {
                this.tenMH = tenMH;
        }

        public int getSoTrinh() {
                return soTrinh;
        }

        public void setSoTrinh(int soTrinh) {
                this.soTrinh = soTrinh;
        }
        
        
}
