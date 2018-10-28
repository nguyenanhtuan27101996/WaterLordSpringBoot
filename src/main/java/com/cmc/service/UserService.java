/**
 * 
 */
package com.cmc.service;


import com.cmc.entity.User;

/**
         * Create by: HaNuoc
         * Create date: Oct 27, 2018
         * Modifier: HaNuoc
         * Modified date:  Oct 27, 2018
         * Description: ....
         * Version 1.0
         */
public interface UserService {
	 void save(User user);
	 User findByUsername(String username);
}
