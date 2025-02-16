package com.tanzid.rest.demo.service.impl;

import com.tanzid.rest.demo.exception.CloudVendorNotFoundException;
import com.tanzid.rest.demo.exception.DuplicateCloudVendorException;
import com.tanzid.rest.demo.model.CloudVendor;
import com.tanzid.rest.demo.repository.CloudVendorRepository;
import com.tanzid.rest.demo.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository){
        this.cloudVendorRepository =cloudVendorRepository;
    }


    @Override
    public CloudVendor createCloudVendor(CloudVendor cloudVendor) {
        if (cloudVendorRepository.existsByVendorId(cloudVendor.getVendorId())) {
            throw new DuplicateCloudVendorException("Cloud Vendor with ID " + cloudVendor.getVendorId() + " already exists.");
        }
        return cloudVendorRepository.save(cloudVendor);
    }


    @Override
    public CloudVendor updateCloudVendor(CloudVendor cloudVendor) {

        return cloudVendorRepository.save(cloudVendor);
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Deleted Success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        if (cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud Vendor Not Exist");
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getALlCloudVendor() {
        if (cloudVendorRepository.findAll().isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud Vendor Not Exist");
        return cloudVendorRepository.findAll();

    }
}
