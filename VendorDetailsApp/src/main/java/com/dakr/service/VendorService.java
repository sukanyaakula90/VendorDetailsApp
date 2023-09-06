package com.dakr.service;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.dakr.entity.Vendor;

public interface VendorService {
Vendor SaveVendor(MultipartFile file, String vendor_name, String vendor_location,
                      Integer vendor_price, String vendor_desc);
   

    public Optional<Vendor> findById(Integer id) ;
    
    
    
    public Vendor updateData(MultipartFile file,Integer id, String vendor_name, String vendor_location,
		Integer vendor_price, String vendor_desc );
    
    
     public String deleteData(@RequestParam Integer id);
}
