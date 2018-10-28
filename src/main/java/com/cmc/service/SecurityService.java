/**
 * 
 */
package com.cmc.service;

        /**
         * Create by: HaNuoc
         * Create date: Oct 27, 2018
         * Modifier: HaNuoc
         * Modified date:  Oct 27, 2018
         * Description: ....
         * Version 1.0
         */
public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);

}
