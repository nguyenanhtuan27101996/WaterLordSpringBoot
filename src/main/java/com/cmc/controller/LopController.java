/**
 * 
 */
package com.cmc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmc.entity.HeDT;
import com.cmc.entity.Khoa;
import com.cmc.entity.KhoaHoc;
import com.cmc.entity.Lop;
import com.cmc.service.HeDTService;
import com.cmc.service.KhoaHocService;
import com.cmc.service.KhoaService;
import com.cmc.service.LopService;

/**
 * @author User
 * @creatdate Oct 26, 2018
 * @modifieddate Oct 26, 2018
 * @content ...
 */
@Controller
public class LopController {
        
        @Autowired
        private LopService lopService;
        @Autowired
        private HeDTService heDTService;
        @Autowired
        private KhoaService khoaService;
        @Autowired
        private KhoaHocService khoaHocService;
        
        @GetMapping("/lop")
        public String index(ModelMap modelMap,Pageable pageable) {
                List<Lop> listLop = lopService.getListAllLop();
                List<HeDT> listHeDT = heDTService.getAllData();
                List<Khoa> listKhoa = khoaService.getListAllKhoa();
                List<KhoaHoc> listKhoaHoc = khoaHocService.getListAllKhoaHoc();
                
                modelMap.addAttribute("listLop", listLop);
                modelMap.addAttribute("listHeDT", listHeDT);
                modelMap.addAttribute("listKhoa",listKhoa);
                modelMap.addAttribute("listKhoaHoc", listKhoaHoc);
                
                return "lop";
        }
        
        @PostMapping("/lop/delete")
        @ResponseBody
        public String deleteLop(@RequestParam String maLop) {
                boolean isDeleted = lopService.deleteLop(maLop);
                return "" +isDeleted;
        }
        
        @PostMapping("/lop/insert")
        @ResponseBody
        public String insertLop(@RequestParam String maLop, @RequestParam String tenLop,
        		@RequestParam String maHeDT, @RequestParam String maKhoa, @RequestParam String maKhoaHoc) {
        	Lop lop = new Lop();
        	
        	lop.setMaLop(maLop);
        	lop.setTenLop(tenLop);
        	
        	HeDT heDT = heDTService.findHeDTByID(maHeDT);
        	lop.setHeDT(heDT);
        	
        	Khoa khoa = khoaService.findKhoaByID(maKhoa);
        	lop.setKhoa(khoa);
        	
        	KhoaHoc khoaHoc = khoaHocService.findKhoaHocByID(maKhoaHoc);
        	lop.setKhoaHoc(khoaHoc);
        	
        	boolean isInserted = lopService.insertLop(lop);
        	
        	return "" + isInserted;
        }
        
        @PostMapping("/lop/update")
        @ResponseBody
        public String updateLop(@RequestParam String maLop, @RequestParam String tenLop,
        		@RequestParam String maHeDT, @RequestParam String maKhoa, @RequestParam String maKhoaHoc) {
        	Lop lop = new Lop();
        	
        	lop.setMaLop(maLop);
        	lop.setTenLop(tenLop);
        	
        	HeDT heDT = heDTService.findHeDTByID(maHeDT);
        	lop.setHeDT(heDT);
        	
        	Khoa khoa = khoaService.findKhoaByID(maKhoa);
        	lop.setKhoa(khoa);
        	
        	KhoaHoc khoaHoc = khoaHocService.findKhoaHocByID(maKhoaHoc);
        	lop.setKhoaHoc(khoaHoc);
        	
        	boolean isUpdated = lopService.updateLop(lop);
        	
        	return "" + isUpdated;
        }
        
        @PostMapping("/lop/filter")
        @ResponseBody
        public String filterLop(@RequestParam String tenLop) {
        	List<Lop> listFilterLopByName = lopService.filterLopByName(tenLop);
        	StringBuilder stringBuilder = new StringBuilder();
        	for (Lop lop : listFilterLopByName) {
        		stringBuilder.append("<tr>");
        		stringBuilder.append("<td id='p-malop'>" + lop.getMaLop() + "</td>");
        		stringBuilder.append("<td id='p-tenlop'>" + lop.getTenLop() + "</td>");
        		stringBuilder.append("<td id='p-mahedt'>" + lop.getHeDT().getMaHeDT() + "</td>");
        		stringBuilder.append("<td id='p-makhoa'>" + lop.getKhoa().getMaKhoa() + "</td>");
        		stringBuilder.append("<td id='p-makhoahoc'>" + lop.getKhoaHoc().getMaKhoaHoc() + "</td>");
        		stringBuilder.append("<td><button class='btn btn-warning btn-update'>Cập nhật</button></td>");
        		stringBuilder.append("<td><button class='btn btn-danger btn-delete'>Xóa</button></td>");
            	stringBuilder.append("</tr>");
			}
        	return stringBuilder.toString();
        }
          
}
