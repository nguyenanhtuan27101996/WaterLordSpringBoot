/**
 * 
 */
package com.cmc.service.serviceimpl;

import java.util.List;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cmc.entity.Lop;
import com.cmc.repository.LopRepository;
import com.cmc.service.LopService;

/**
 * @author NATuan3
 * @creatdate Oct 26, 2018
 * @modifieddate Oct 26, 2018
 * @content ...
 */
@Service
public class LopServiceImpl implements LopService{
        private static Logger log = Logger.getLogger(LopServiceImpl.class);
        @Autowired
        private LopRepository lopRepository;
        
        @Override
        public List<Lop> getListAllLop() {
                return lopRepository.findAll();
        }

        @Override
        public boolean deleteLop(String maLop) {
                boolean isSuccess = false;
                
                //find an object Lop that have maLop = maLop
                Lop lop = lopRepository.getOne(maLop);
                
                try {
                		//delete object Lop found
                        lopRepository.delete(lop);
                        isSuccess = true;
                } catch (Exception e) {
                        log.error("Co loi khi delete object lop" +e.getMessage());
                        isSuccess = false;
                }
                return isSuccess;
        }

        @Override
        public boolean insertLop(Lop lop) {
                boolean isSuccess = false;
                lop.setMaLop(lop.getMaLop());
                //save object love into database
                Lop insertedLop = lopRepository.save(lop);
                //check if insertedLop null
                if (insertedLop != null) {
                        isSuccess = true;
                } else {
                        isSuccess = false;
                        log.error("Co loi khi insert object lop ");
                }
                return isSuccess;
        }

        @Override
        public boolean updateLop(Lop lop) {
                boolean isSuccess = false;
                //save object love into database
                Lop updatedLop = lopRepository.save(lop);
                //check if insertedLop null
                if (updatedLop != null){
                        isSuccess = true;
                } else {
                        isSuccess = false;
                        log.error("Co loi khi update object lop ");
                }
                return isSuccess;
        }

		@Override
		public Lop findLopByID(String maLop) {
			return lopRepository.getOne(maLop);
			
			
		}

		@Override
		public List<Lop> filterLopByName(String tenLop) {
			return lopRepository.findByTenLopContaining(tenLop);
		}      
}
