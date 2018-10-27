/**
 * 
 */
package com.cmc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmc.entity.Lop;
import com.cmc.repository.LopRepository;
import com.cmc.service.LopService;

/**
 * @author User
 * @creatdate Oct 26, 2018
 * @modifieddate Oct 26, 2018
 * @content ...
 */
@RestController
@RequestMapping("/api")
public class LopRestApiController {

	@Autowired
	private LopService lopService;
	
	@Autowired
	private LopRepository lopRepository;
	
	@GetMapping("/lop")
	public ResponseEntity<List<Lop>> getListAllLop(){
		List<Lop> listLop = lopService.getListAllLop();
		
		if (listLop.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Lop>>(listLop, HttpStatus.OK);
	}
	
	@PostMapping("/lop")
	public Lop saveLop(@Valid @RequestBody Lop Lop) {
		return lopRepository.save(Lop);
	}
	
	
	@PutMapping("/lop/{maLop}")
	public ResponseEntity<Lop> updateLop(@PathVariable(value = "maLop") String maLop, 
	                                       @Valid @RequestBody Lop lopForm) {
		Lop lop = lopService.findLopByID(maLop);
	    if(lop == null) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    lop.setTenLop(lopForm.getTenLop());

	    Lop updatedLop = lopRepository.save(lop);
	    return ResponseEntity.ok(updatedLop);
	}
	
	@DeleteMapping("/lop/{maLop}")
	public ResponseEntity<Lop> deleteLop(@PathVariable(value = "maLop") String maLop) {
		Lop lop = lopService.findLopByID(maLop);
	    if(lop == null) {
	        return ResponseEntity.notFound().build();
	    }

	    lopRepository.delete(lop);
	    return ResponseEntity.ok().build();
	}

}
