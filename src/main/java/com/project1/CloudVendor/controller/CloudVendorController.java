package com.project1.CloudVendor.controller;

import java.util.List;

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

import com.project1.CloudVendor.model.CloudVendor;
import com.project1.CloudVendor.response.ResponseHandler;
import com.project1.CloudVendor.service.impl.CloudVendorServiceImpl;

@RestController
@RequestMapping("/cloudVendor")
public class CloudVendorController {
    public CloudVendorServiceImpl cloudVendorServiceImpl;

    public CloudVendorController(CloudVendorServiceImpl cloudVendorServiceImpl) {
        this.cloudVendorServiceImpl = cloudVendorServiceImpl;
    }

    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
        return ResponseHandler.responseBuilder("Requested Vendor Details are given here.",
                        HttpStatus.OK, this.cloudVendorServiceImpl.getCloudVendor(vendorId));
    }    


    @GetMapping()
    public List<CloudVendor> getCloudVendorDetails() {
        return this.cloudVendorServiceImpl.getAllCloudVendor();
    }    

    @PostMapping()
    public String postCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        //TODO: process POST request
        return this.cloudVendorServiceImpl.createCloudVendor(cloudVendor);
    }

    @PutMapping()
    public String putCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        //TODO: process PUT request
        return this.cloudVendorServiceImpl.updateCloudVendor(cloudVendor);
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return this.cloudVendorServiceImpl.deletCloudVendor(vendorId);
    }
}
