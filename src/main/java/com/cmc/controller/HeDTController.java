/**
 * Package: com.cmc.controller
 */
package com.cmc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@PostMapping("/hedaotao/insert")
	@ResponseBody
	public String insertHeDT(String mahedt, String tenhedt) {
		HeDT hdt = new HeDT();
//		mahedt, tenhedt
		//hedt.setmahedt(hedt.getmahedt())
		hdt.setMaHeDT(mahedt);
		hdt.setTenHeDT(tenhedt);
		boolean isSuccess = service.insertData(hdt);
		return ""+isSuccess;
	}
	
	@PostMapping("/hedaotao/delete")
	@ResponseBody
	public String deleteHeDT(String mahedt) {
		HeDT hdt = new HeDT();
		hdt.setMaHeDT(mahedt);
		boolean isSuccess = service.deleteData(hdt);
		return ""+isSuccess;
	}
}
