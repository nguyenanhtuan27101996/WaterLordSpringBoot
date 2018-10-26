/**
 * 
 */
package com.cmc.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author User
 * @creatdate Oct 26, 2018
 * @modifieddate Oct 26, 2018
 * @content ...
 */
@Entity
@Table(name="Diem")
public class Diem {
        @EmbeddedId
        private DiemID diemID;
        
        @Column(name="HocKy")
        private int hocKy;
        @Column(name="DiemLan1")
        private int diemLan1;
        @Column(name="DiemLan2")
        private int diemLan2;
        
}
