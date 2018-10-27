/**
 * Package: com.cmc.controller
 */
package com.cmc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmc.entity.HeDT;
import com.cmc.service.serviceimpl.HeDTServiceIplm;

/**
	 * Create by: Thanh Dao 
	 * Create date: Oct 26, 2018
	 * Modifier: Thanh Dao 
	 * Modified date: Oct 26, 2018
	 * Description: Version 1.0
	 */
@Controller
public class HeDTController {
	@Autowired 
	HeDTServiceIplm service;
	/**
	 * Date: Oct 26, 2018
	 * Content: show view of HeDT entity
	 * @return
	 */
	@RequestMapping({"/hedaotao"})
	public String showView(Model model) {
		List<HeDT> list = service.getAllData();
		model.addAttribute("listHDT", list);
		return "HeDT";
	}
}
