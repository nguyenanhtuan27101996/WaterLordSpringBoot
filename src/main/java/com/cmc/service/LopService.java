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
        
        /**
         * @author NATuan3
         * @modifidate Oct 27, 2018
         * @modifi
         * @desciption delete an object Lop
         * @return boolean
         */
        boolean deleteLop(String maLop);
        
        
        /**
         * @author NATuan3
         * @modifidate Oct 27, 2018
         * @modifi
         * @desciption insert an object Lop
         * @return boolean
         */
        boolean insertLop(Lop lop);
        
        /**
         * @author NATuan3
         * @modifidate Oct 27, 2018
         * @modifi
         * @desciption update an object Lop
         * @return boolean
         */
        boolean updateLop(Lop lop);
        
        /**
         * @author NATuan3
         * @modifidate Oct 27, 2018
         * @modifi
         * @desciption return an object Lop found by maLop
         * @return Lop
         */
        Lop findLopByID(String maLop);
        
        
        /**
         * @author NATuan3
         * @modifidate Oct 27, 2018
         * @modifi
         * @desciption return a list of Lop that name containing tenLop
         * @return list
         */
        List<Lop> filterLopByName(String tenLop);  
        
}
