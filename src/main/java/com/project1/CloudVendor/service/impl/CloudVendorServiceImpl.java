package com.project1.CloudVendor.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project1.CloudVendor.exception.CloudVendorNotFoundException;
import com.project1.CloudVendor.model.CloudVendor;
import com.project1.CloudVendor.repository.CloudVendorRepository;
import com.project1.CloudVendor.service.CloudVendorService;

@Service
public class CloudVendorServiceImpl implements CloudVendorService{
    public CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        this.cloudVendorRepository.save(cloudVendor);
        return cloudVendor.getVendorId() + " is added successfully";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        String updateResult = null;
        if(this.cloudVendorRepository.findById(cloudVendor.getVendorId()).isEmpty())
            updateResult = cloudVendor.getVendorId() + " does not exists but added successfully";
        
        this.cloudVendorRepository.save(cloudVendor);
        return updateResult == null ? cloudVendor.getVendorId() + " is updated successfully"
                                    : updateResult;
    }

    @Override
    public String deletCloudVendor(String vendorId) {
        if(this.cloudVendorRepository.findById(vendorId).isEmpty())
            throw new CloudVendorNotFoundException(vendorId + " doesnot exists.");
        
        this.cloudVendorRepository.deleteById(vendorId);
        return vendorId + " is deleted successfully";
    }

    @Override
    public CloudVendor getCloudVendor(String vendorId) {
        if(this.cloudVendorRepository.findById(vendorId).isEmpty())
            throw new CloudVendorNotFoundException(vendorId + " doesnot exists.");
        
        return this.cloudVendorRepository.findById(vendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        return this.cloudVendorRepository.findAll();
    }
}
