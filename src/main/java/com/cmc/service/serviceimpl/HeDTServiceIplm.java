/**
 * Package: com.cmc.service.serviceimpl
 */
package com.cmc.service.serviceimpl;

import java.util.List;

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
	/* (non-Javadoc)
	 * @see com.cmc.service.HeDTService#getAllData()
	 */
	@Override
	public List<HeDT> getAllData() {
		// TODO Auto-generated method stub
		List<HeDT> list = (List<HeDT>)repo.findAll();
		return list;
	}

}
