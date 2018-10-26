/**
 * 
 */
package com.cmc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
        public String index(ModelMap modelMap) {
                List<Lop> listLop = lopService.getListAllLop();
                List<HeDT> listHeDT = heDTService.getListAllHeDT();
                List<Khoa> listKhoa = khoaService.getListAllKhoa();
                List<KhoaHoc> listKhoaHoc = khoaHocService.getListAllKhoaHoc();
                
                modelMap.addAttribute("listLop", listLop);
                modelMap.addAttribute("listHeDT", listHeDT);
                modelMap.addAttribute("listKhoa",listKhoa);
                modelMap.addAttribute("listKhoaHoc", listKhoaHoc);
                
                return "index";
        }
        
        @PostMapping("/lop/delete")
        @ResponseBody
        public String deleteLop(@RequestParam String maLop) {
                boolean isDeleted = lopService.deleteLop(maLop);
                return "" +isDeleted;
        }
        
        
}
