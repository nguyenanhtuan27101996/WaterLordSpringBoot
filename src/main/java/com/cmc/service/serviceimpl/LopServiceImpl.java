/**
 * 
 */
package com.cmc.service.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
                Lop lop = lopRepository.getOne(maLop);
                
                try {
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
                Lop insertedLop = lopRepository.save(lop);
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
                Lop updatedLop = lopRepository.save(lop);
                if (updatedLop != null){
                        isSuccess = true;
                } else {
                        isSuccess = false;
                        log.error("Co loi khi update object lop ");
                }
                return isSuccess;
        }

}
