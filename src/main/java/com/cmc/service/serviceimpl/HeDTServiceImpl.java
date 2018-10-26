/**
 * 
 */
package com.cmc.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.entity.HeDT;
import com.cmc.repository.HeDTRepository;
import com.cmc.service.HeDTService;

/**
 * @author NATuan3
 * @creatdate Oct 26, 2018
 * @modifieddate Oct 26, 2018
 * @content ...
 */
@Service
public class HeDTServiceImpl implements HeDTService{

        @Autowired
        private HeDTRepository heDTRepository;
        @Override
        public List<HeDT> getListAllHeDT() {
                return heDTRepository.findAll();
        }

}
