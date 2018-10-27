/**
 * 
 */
package com.cmc.service;

import java.util.List;

import com.cmc.entity.Khoa;

/**
 * @author NATuan3
 * @creatdate Oct 26, 2018
 * @modifieddate Oct 26, 2018
 * @content ...
 */
public interface KhoaService {

        List<Khoa> getListAllKhoa();
        
        Khoa findKhoaByID(String maKhoa);
}
