package com.cmc.service.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmc.entity.SinhVien;
import com.cmc.repository.SinhVienRepository;
import com.cmc.service.SinhVienService;

/**
 * Create by: NV Tiep 
 * Create date:Oct 26, 2018 
 * Modifier: NV Tiep 
 * Modified date: Oct 26, 2018 
 * Description:
 */
@Service
public class SinhVienServiceImpl implements SinhVienService {
	@Autowired
	SinhVienRepository repo;
    Logger log=Logger.getLogger(SinhVienServiceImpl.class);
	@Override
	public List<SinhVien> getdAll() {
		List<SinhVien> list = repo.findAll();
		return list;
	}

	@Override
	public boolean insert(SinhVien s) {
		try {
			repo.save(s);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(SinhVien s) {
		try {
			repo.save(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(String s) {
		try {
			repo.deleteById(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
