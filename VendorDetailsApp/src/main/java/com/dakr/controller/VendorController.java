package com.dakr.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dakr.entity.Vendor;
import com.dakr.service.VendorServiceImp;

@RestController
public class VendorController {

  @Autowired
  private VendorServiceImp venodreimp;
   

    @PostMapping("/saveImage")
    public String saveVendorDetails(
    		
            @RequestParam MultipartFile file,
            @RequestParam String vendor_name,
            @RequestParam String vendor_location,
            @RequestParam Integer vendor_price,
            @RequestParam String vendor_desc) {
    	
    	Vendor vendor = venodreimp.SaveVendor(file, vendor_name, vendor_location, vendor_price, vendor_desc);
        
    	String message = null;
    	if( vendor != null)
    	{
    		message = "data save successfully";
    	}
    	else
    	{
    		message = "not saved";
    	}
    	
        return  message;
    }
    @GetMapping("/{id}")
    public Optional<Vendor> getData(@RequestParam Integer id) {
    	return venodreimp.findById(id) ;
    }
    @PutMapping("/update")
    public Vendor updateData(MultipartFile file,Integer id, String vendor_name, String vendor_location,
    		Integer vendor_price, String vendor_desc ){
    	return venodreimp.updateData(file,id,vendor_name,vendor_location,vendor_price,vendor_desc);
    }
   @DeleteMapping("/delete{id}")
    public String deleteData(@RequestParam Integer id) {
	   return venodreimp.deleteData(id);
   }
    
    
    
}
