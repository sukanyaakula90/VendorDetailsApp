package com.dakr.service;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.multipart.MultipartFile;

import com.dakr.entity.Vendor;
import com.dakr.repository.VendorRepository;

@Service
public class VendorServiceImp implements VendorService {

	@Autowired
	private VendorRepository vendorRepo;
	@Override//save the data
	public Vendor SaveVendor(MultipartFile file, String vendor_name, String vendor_location,
			Integer vendor_price, String vendor_desc) {
	
		Vendor vendor = new Vendor();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		if(fileName.contains(".."))
		{	
			System.out.println("not a valid file");
			}
			
			try {
				vendor.setVendor_image(Base64.getEncoder().encodeToString(file.getBytes()));
			}
			catch(IOException e) {
				
				e.printStackTrace();
				
			}
	
	vendor.setVendor_name(vendor_name);
	vendor.setVendor_location(vendor_location);
	vendor.setVendor_price(vendor_price);
	vendor.setVendor_desc(vendor_desc);
	
	vendorRepo.save(vendor);
		return vendor;
	}
	@Override//Retrieve the data from the database by using id
	public Optional<Vendor> findById(Integer id) {
		return vendorRepo.findById(id);
	} 
	
	
	@Override//Update By Using Id
	public Vendor updateData(MultipartFile file, Integer id, String vendor_name, String vendor_location,
			Integer vendor_price, String vendor_desc) {
		Optional<Vendor> optionalVendor = vendorRepo.findById(id);
        if (!optionalVendor.isPresent()) {	
     	return null; 
     	}
     	Vendor vendor = optionalVendor.get();
     	vendor.setVendor_name(vendor_name);
     	vendor.setVendor_location(vendor_location);
     	vendor.setVendor_price(vendor_price);
     	vendor.setVendor_desc(vendor_desc);

     	if (file != null && !file.isEmpty()) {
     	String fileName = StringUtils.cleanPath(file.getOriginalFilename());

     	if (fileName.contains("..")) {
     	System.out.println("not a valid file");
     
     	} else {
     	try {
     	 vendor.setVendor_image(Base64.getEncoder().encodeToString(file.getBytes()));
     	} 
     	catch (IOException e) {
     	 e.printStackTrace();
     	
     	}
     	}
     	}
             vendorRepo.save(vendor);
        return vendor;
}

		@Override//Delete Operation
	  public String deleteData(Integer id) {
      Optional<Vendor> ven = vendorRepo.findById(id);
       if(ven.isPresent()) {
    	   vendorRepo.deleteById(id);
       }
	return "Data deleted Sucessfully";
	}
		
	}
	
    
            			


