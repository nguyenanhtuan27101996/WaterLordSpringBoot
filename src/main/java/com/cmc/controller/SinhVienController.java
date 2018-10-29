package com.cmc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmc.entity.Lop;
import com.cmc.entity.SinhVien;
import com.cmc.service.serviceimpl.LopServiceImpl;
import com.cmc.service.serviceimpl.SinhVienServiceImpl;



/**
* Create by: NVTiep
* Create date:Oct 29, 2018
* Modifier: NVTiep
* Modified date:Oct 29, 2018
* Description:
* Version 1.0
*/
@Controller
public class SinhVienController {
	@Autowired
	private SinhVienServiceImpl serviceSV;
	@Autowired
	private LopServiceImpl serviceL;

	@GetMapping("/sinhvien")
	public String showList(Model model) {
		List<SinhVien> listSV = serviceSV.getdAll();
		List<Lop> listL = serviceL.getListAllLop();
		model.addAttribute("listSinhVien", listSV);
		model.addAttribute("listLop", listL);
		return "ListSinhVien";
	}

	
	/**
	* Create by: NVTiep
	* Create date:Oct 29, 2018
	* Modifier: NVTiep
	* Modified date:Oct 29, 2018
	* Description:
	* Version 1.0
	* @param masv
	* @param tensv
	* @param ngaysinh
	* @param gioitinh
	* @param quequan
	* @param lop
	* @return
	*/
	@PostMapping("/sinhvien/insert")
	@ResponseBody
	public String insertSinhVien(@RequestParam String masv, @RequestParam String tensv, @RequestParam String ngaysinh,
			@RequestParam String gioitinh, @RequestParam String quequan, @RequestParam String lop) {
		SinhVien sv = new SinhVien();
		sv.setMaSV(masv);
		sv.setTenSV(tensv);
		sv.setNgaySinh(ngaysinh);
		if ("true".equals(gioitinh))
			sv.setGioiTinh(true);
		else
			sv.setGioiTinh(false);
		sv.setQueQuan(quequan);
		Lop l = serviceL.findLopByID(lop);
		if (l != null)
			sv.setLop(l);
		else
			sv.setLop(null);
		boolean flag = serviceSV.insert(sv);
		if (flag == true)
			return "true";
		else
			return "false";

	}

	
	/**
	* Create by: NVTiep
	* Create date:Oct 29, 2018
	* Modifier: NVTiep
	* Modified date:Oct 29, 2018
	* Description:
	* Version 1.0
	* @param masv
	* @param tensv
	* @param ngaysinh
	* @param gioitinh
	* @param quequan
	* @param lop
	* @return
	*/
	@PostMapping("/sinhvien/update")
	@ResponseBody
	public String updateSinhVien(@RequestParam String masv, @RequestParam String tensv, @RequestParam String ngaysinh,
			@RequestParam String gioitinh, @RequestParam String quequan, @RequestParam String lop) {
		SinhVien sv = new SinhVien();
		sv.setMaSV(masv);
		sv.setTenSV(tensv);
		sv.setNgaySinh(ngaysinh);
		if ("true".equals(gioitinh))
			sv.setGioiTinh(true);
		else
			sv.setGioiTinh(false);
		sv.setQueQuan(quequan);
		Lop l = serviceL.findLopByID(lop);
		if (l != null)
			sv.setLop(l);
		else
			sv.setLop(null);
		boolean flag = serviceSV.update(sv);
		if (flag == true)
			return "true";
		else
			return "false";

	}

	
	/**
	* Create by: NVTiep
	* Create date:Oct 29, 2018
	* Modifier: NVTiep
	* Modified date:Oct 29, 2018
	* Description:
	* Version 1.0
	* @param masv
	* @return
	*/
	@PostMapping("/sinhvien/delete")
	@ResponseBody
	public String deleteSinhVien(@RequestParam String masv) {
		boolean flag = serviceSV.delete(masv);
		if (flag == true)
			return "true";
		else
			return "false";

	}

	
	/**
	* Create by: NVTiep
	* Create date:Oct 29, 2018
	* Modifier: NVTiep
	* Modified date:Oct 29, 2018
	* Description:
	* Version 1.0
	* @param model
	* @param search
	* @return
	*/
	@PostMapping("/sinhvien/search")
	@ResponseBody
	public String searchSinhVien(@RequestParam String search)
		 {
        List<SinhVien> list=serviceSV.search(search);
		StringBuilder stringBuilder = new StringBuilder();
    	for (SinhVien sv : list) {
    		String gioiTinh=sv.isGioiTinh()==true?"Nam":"Nữ";
    		stringBuilder.append("<tr>");
    		stringBuilder.append("<td>" + sv.getMaSV() + "</td>");
    		stringBuilder.append("<td>" + sv.getTenSV() + "</td>");
    		stringBuilder.append("<td>" + sv.getNgaySinh() + "</td>");
    		stringBuilder.append("<td>" + gioiTinh + "</td>");
    		stringBuilder.append("<td>" + sv.getQueQuan() + "</td>");
    		stringBuilder.append("<td>" + sv.getLop().getTenLop() + "</td>");
    		stringBuilder.append("<td><button class='btn btn-info edit_btn'>Edit</button></td>");
    		stringBuilder.append("<td><button class= 'btn btn-info delete_btn '>Delete</button></td>");
        	stringBuilder.append("</tr>");
		}
    	return stringBuilder.toString();
	}

}
