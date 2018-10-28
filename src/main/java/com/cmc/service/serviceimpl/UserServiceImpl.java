/**
 * 
 */
package com.cmc.service.serviceimpl;

import com.cmc.entity.User;
import com.cmc.repository.RoleRepository;
import com.cmc.repository.UserRepository;
import com.cmc.service.UserService;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
         * Create by: HaNuoc
         * Create date: Oct 27, 2018
         * Modifier: HaNuoc
         * Modified date:  Oct 27, 2018
         * Description: ....
         * Version 1.0
         */
@Service("userService")
public class UserServiceImpl implements UserService{
	 @Autowired
	    private UserRepository userRepository;
	    @Autowired
	    private RoleRepository roleRepository;
	    @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	/* (non-Javadoc)
	 * @see com.cmc.service.UserService#save(com.cmc.entity.User)
	 */
	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
		
	}

	/* (non-Javadoc)
	 * @see com.cmc.service.UserService#findByUsername(java.lang.String)
	 */
	@Override
	public User findByUsername(String username) {
		 return userRepository.findByUsername(username);
	}

}
