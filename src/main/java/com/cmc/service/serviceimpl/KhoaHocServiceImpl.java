/**
 * 
 */
package com.cmc.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.entity.KhoaHoc;
import com.cmc.repository.KhoaHocRepository;
import com.cmc.service.KhoaHocService;

/**
 * @author NATuan3
 * @creatdate Oct 26, 2018
 * @modifieddate Oct 26, 2018
 * @content ...
 */
@Service
public class KhoaHocServiceImpl implements KhoaHocService {

        @Autowired
        private KhoaHocRepository khoaHocRepository;
        @Override
        public List<KhoaHoc> getListAllKhoaHoc() {
                return khoaHocRepository.findAll();
        }

}
