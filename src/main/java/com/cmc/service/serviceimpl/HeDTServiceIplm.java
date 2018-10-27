/**
 * Package: com.cmc.service.serviceimpl
 */
package com.cmc.service.serviceimpl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmc.entity.HeDT;
import com.cmc.repository.HeDTRepository;
import com.cmc.service.HeDTService;

/**
 * Create by: Thanh Dao 
 * Create date: Oct 27, 2018
 * Modifier: Thanh Dao 
 * Modified date: Oct 27, 2018
 * Description: Version 1.0
 */
@Service
@Transactional
public class HeDTServiceIplm implements HeDTService {
	@Autowired
	HeDTRepository repo;
	Logger log = Logger.getLogger(HeDTServiceIplm.class);
	/* (non-Javadoc)
	 * @see com.cmc.service.HeDTService#getAllData()
	 */
	@Override
	public List<HeDT> getAllData() {
		try {
			List<HeDT> list = (List<HeDT>)repo.findAll();
			return list;
		}catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
		
	}
	/* (non-Javadoc)
	 * @see com.cmc.service.HeDTService#insertData(com.cmc.entity.HeDT)
	 */
	@Override
	public boolean insertData(HeDT hdt) {
		// TODO Auto-generated method stub
		try {
			repo.save(hdt);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
			return false;
		}	
	}
	/* (non-Javadoc)
	 * @see com.cmc.service.HeDTService#deleteData(com.cmc.entity.HeDT)
	 */
	@Override
	public boolean deleteData(HeDT hdt) {
		String id = hdt.getMaHeDT();
		try {
			repo.deleteById(id);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
	}
	

}
