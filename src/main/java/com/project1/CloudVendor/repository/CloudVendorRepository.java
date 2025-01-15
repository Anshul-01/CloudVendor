package com.project1.CloudVendor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project1.CloudVendor.model.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String>{

    List<CloudVendor> findByVendorName(String string);
    
}
