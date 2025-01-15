package com.project1.CloudVendor.service;

import java.util.List;

import com.project1.CloudVendor.model.CloudVendor;

public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deletCloudVendor(String vendorId); 
    public CloudVendor getCloudVendor(String vendorId);
    public List<CloudVendor> getAllCloudVendor();
}