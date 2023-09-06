package com.dakr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dakr.entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer>{

}
