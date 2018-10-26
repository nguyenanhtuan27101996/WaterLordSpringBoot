/**
 * Package: com.cmc.controller
 */
package com.cmc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
	 * Create by: Thanh Dao 
	 * Create date: Oct 26, 2018
	 * Modifier: Thanh Dao 
	 * Modified date: Oct 26, 2018
	 * Description: Version 1.0
	 */
@Controller
public class HeDTController {
	/**
	 * Date: Oct 26, 2018
	 * Content: show view of HeDT entity
	 * @return
	 */
	@RequestMapping({"/hedaotao"})
	public String showView() {
		return "HeDT";
	}
}
