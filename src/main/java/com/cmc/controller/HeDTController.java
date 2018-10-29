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
import com.cmc.entity.Lop;
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
	/**
	 * Create by: Thanh Dao
	 * Create date: Oct 27, 2018
	 * Modifier: Thanh Dao
	 * Modified date: Oct 27, 2018
	 * Description: show all data to view
	 * Version 1.0
	 * @param model
	 * @return
	 */
	@RequestMapping({"/hedaotao"})
	public String showView(Model model) {
		List<HeDT> list = service.getAllData();
		model.addAttribute("listHDT", list);
		return "HeDT";
	}
	
	/**
	 * Create by: Thanh Dao
	 * Create date: Oct 28, 2018
	 * Modifier: Thanh Dao
	 * Modified date: Oct 28, 2018
	 * Description: add new record to database
	 * Version 1.0
	 * @param mahedt: HeDT id
	 * @param tenhedt: HeDT name
	 * @return
	 */
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
	
	/**
	 * Create by: Thanh Dao
	 * Create date: Oct 28, 2018
	 * Modifier: Thanh Dao
	 * Modified date: Oct 28, 2018
	 * Description: delete record in database
	 * Version 1.0
	 * @param mahedt: HeDT id
	 * @return
	 */
	@PostMapping("/hedaotao/delete")
	@ResponseBody
	public String deleteHeDT(String mahedt) {
		HeDT hdt = new HeDT();
		hdt.setMaHeDT(mahedt);
		boolean isSuccess = service.deleteData(hdt);
		return ""+isSuccess;
	}
	
	/**
	 * Create by: Thanh Dao
	 * Create date: Oct 28, 2018
	 * Modifier: Thanh Dao
	 * Modified date: Oct 28, 2018
	 * Description: modify data in database
	 * Version 1.0
	 * @param mahedt: id of HeDT
	 * @param tenhedt: name of HeDT
	 * @return
	 */
	@PostMapping("/hedaotao/update")
	@ResponseBody
	public String updateHeDT(String mahedt, String tenhedt) {
		HeDT hdt = new HeDT();
		hdt.setMaHeDT(mahedt);
		hdt.setTenHeDT(tenhedt);
		boolean isSuccess = service.updateData(hdt);
		return ""+isSuccess;
	}
	
	/**
	 * Create by: Thanh Dao
	 * Create date: Oct 29, 2018
	 * Modifier: Thanh Dao
	 * Modified date: Oct 29, 2018
	 * Description: live search function
	 * Version 1.0
	 * @param tenhedt: HeDT name
	 * @return
	 */
	@PostMapping("/hedaotao/filter")
	@ResponseBody
	public String filter(String tenhedt) {
		List<HeDT> list = service.filterByName(tenhedt);
		StringBuilder stringBuilder = new StringBuilder();
    	for (HeDT hedt : list) {
    		stringBuilder.append("<tr>");
    		stringBuilder.append("<td id='text-mahedt'>" + hedt.getMaHeDT() + "</td>");
    		stringBuilder.append("<td id='text-tenhedt'>" + hedt.getTenHeDT() + "</td>");
    		stringBuilder.append("<td><button class='btn btn-warning btn-update'>Cập nhật</button></td>");
    		stringBuilder.append("<td><button class='btn btn-danger btn-delete'>Xóa</button></td>");
        	stringBuilder.append("</tr>");
		}
    	return stringBuilder.toString();
	}
}
