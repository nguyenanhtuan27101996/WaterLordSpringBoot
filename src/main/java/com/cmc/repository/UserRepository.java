/**
 * 
 */
package com.cmc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmc.entity.User;

/**
         * Create by: HaNuoc
         * Create date: Oct 27, 2018
         * Modifier: HaNuoc
         * Modified date:  Oct 27, 2018
         * Description: ....
         * Version 1.0
         */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}
