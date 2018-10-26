/**
 * 
 */
package com.cmc.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author User
 * @creatdate Oct 26, 2018
 * @modifieddate Oct 26, 2018
 * @content ...
 */
@Embeddable
public class DiemID implements Serializable{

        private int maSV;
        private int maMH;
        public DiemID() {
                super();
        }
        public DiemID(int maSV, int maMH) {
                super();
                this.maSV = maSV;
                this.maMH = maMH;
        }
        public int getMaSV() {
                return maSV;
        }
        public void setMaSV(int maSV) {
                this.maSV = maSV;
        }
        public int getMaMH() {
                return maMH;
        }
        public void setMaMH(int maMH) {
                this.maMH = maMH;
        }
        
        
}
