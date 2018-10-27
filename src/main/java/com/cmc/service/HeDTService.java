/**
 * Package: com.cmc.service
 */
package com.cmc.service;

import java.util.List;

import com.cmc.entity.HeDT;

/**
 * Create by: Thanh Dao 
 * Create date: Oct 27, 2018
 * Modifier: Thanh Dao 
 * Modified date: Oct 27, 2018
 * Description: Version 1.0
 */
public interface HeDTService {
	

	/**
	 * Create by: Thanh Dao 
	 * Create date: Oct 27, 2018
	 * Modifier: Thanh Dao 
	 * Modified date: Oct 27, 2018
	 * Description: get all data from dao
	 * Version 1.0
	 * @return
	 */
	public List<HeDT> getAllData();
	/**
	 * Create by: Thanh Dao 
	 * Create date: Oct 27, 2018
	 * Modifier: Thanh Dao 
	 * Modified date: Oct 27, 2018
	 * Description: insert new record into database
	 * Version 1.0
	 * @param hdt: HeDT object
	 * @return bool result- true id success
	 */
	public boolean insertData(HeDT hdt);
	
	/**
	 * Create by: Thanh Dao 
	 * Create date: Oct 27, 2018
	 * Modifier: Thanh Dao 
	 * Modified date: Oct 27, 2018
	 * Description: delete record in database
	 * Version 1.0
	 * @param hdt: HeDT object
	 * @return
	 */
	public boolean deleteData(HeDT hdt);
}	
