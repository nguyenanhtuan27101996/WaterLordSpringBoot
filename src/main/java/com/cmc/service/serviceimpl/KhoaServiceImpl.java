/**
 * 
 */
package com.cmc.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.entity.Khoa;
import com.cmc.repository.KhoaRepository;
import com.cmc.service.KhoaService;

/**
 * @author NATuan3
 * @creatdate Oct 26, 2018
 * @modifieddate Oct 26, 2018
 * @content ...
 */
@Service
public class KhoaServiceImpl implements KhoaService{

        @Autowired
        private KhoaRepository khoaRepository;

        @Override
        public List<Khoa> getListAllKhoa() {
                return khoaRepository.findAll();
        }
        
        
}
