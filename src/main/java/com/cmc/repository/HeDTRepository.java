/**
 * 
 */
package com.cmc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmc.entity.HeDT;

/**
 * @author User
 * @creatdate Oct 26, 2018
 * @modifieddate Oct 26, 2018
 * @content ...
 */
@Repository
public interface HeDTRepository extends JpaRepository<HeDT, String>{
	List<HeDT>findAll();
}
