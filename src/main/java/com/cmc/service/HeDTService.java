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
	 * @return true if success
	 */
	public boolean deleteData(HeDT hdt);
	
	/**
	 * Create by: Thanh Dao 
	 * Create date: Oct 27, 2018
	 * Modifier: Thanh Dao 
	 * Modified date: Oct 27, 2018
	 * Description: update data in table HeDT
	 * Version 1.0
	 * @param hdt: HeDT object 
	 * @return: true if success
	 */
	public boolean updateData(HeDT hdt);
	
	/**
	 * Create by: Tuan Nguyen Anh
	 * Create date: Oct 25, 2018
	 * Modifier: Thanh Dao 
	 * Modified date: Oct 27, 2018
	 * Description: find HeDT record in database by id
	 * Version 1.0
	 * @param maHeDT
	 * @return
	 */
	HeDT findHeDTByID(String maHeDT);
	
	/**
	 * Create by: Thanh Dao
	 * Create date: Oct 29, 2018
	 * Modifier: Thanh Dao
	 * Modified date: Oct 29, 2018
	 * Description: search name of HeDT
	 * Version 1.0
	 * @param name: name of HeDT object
	 * @return
	 */
	List<HeDT> filterByName(String name);
}	

        