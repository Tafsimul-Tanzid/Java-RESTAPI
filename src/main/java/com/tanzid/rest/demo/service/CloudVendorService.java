package com.tanzid.rest.demo.service;

import com.tanzid.rest.demo.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    public CloudVendor createCloudVendor(CloudVendor cloudVendor);
    public CloudVendor updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(String cloudVendorId);
    public  CloudVendor getCloudVendor(String cloudVendorId);
    public List<CloudVendor> getALlCloudVendor();

}
