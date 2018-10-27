/**
 * 
 */
package com.cmc.service;

import java.util.List;

import com.cmc.entity.Lop;


/**
 * @author NATuan3
 * @creatdate Oct 26, 2018
 * @modifieddate Oct 26, 2018
 * @content ...
 */
public interface LopService {

        /**
         * @author NATuan3
         * @creatdate Oct 26, 2018
         * @modifier
         * @modifieddate Oct 26, 2018
         * @description return a list of Lop
         * @version 1.0
         * @return list
         */
        List<Lop> getListAllLop();
        
        boolean deleteLop(String maLop);
        
        boolean insertLop(Lop lop);
        
        boolean updateLop(Lop lop);
        
        Lop findLopByID(String maLop);
        
        
}
