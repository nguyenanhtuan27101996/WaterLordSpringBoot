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
 * Create by: NV Tiep Create date:Oct 26, 2018 Modifier: NV Tiep Modified
 * date:Oct 26, 2018 Description:
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

	@PostMapping("/sinhvien/delete")
	@ResponseBody
	public String deleteSinhVien(@RequestParam String masv) {
		boolean flag = serviceSV.delete(masv);
		if (flag == true)
			return "true";
		else
			return "false";

	}

	@PostMapping("/sinhvien/search")
	public String searchSinhVien(Model model,@RequestParam String search)
		 {
        List<SinhVien> list=serviceSV.search(search);
		List<Lop> listL = serviceL.getListAllLop();
		model.addAttribute("listSinhVien", list);
		model.addAttribute("listLop", listL);
		return "ListSinhVien";
	}

}
