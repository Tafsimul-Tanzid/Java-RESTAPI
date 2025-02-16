package com.tanzid.rest.demo.controller;

import com.tanzid.rest.demo.model.CloudVendor;
import com.tanzid.rest.demo.response.ResponseHandler;
import com.tanzid.rest.demo.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cloudVendor")
public class CloudVendorAPIController {
    public CloudVendorAPIController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;

    }

    CloudVendorService cloudVendorService;
    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId)
    {
        return ResponseHandler.responseBuilder("Requested Vendor Details", HttpStatus.OK,cloudVendorService.getCloudVendor(vendorId));

    }

    @GetMapping()
    public  ResponseEntity<Object> getAllCloudVendorDetails() {
        return ResponseHandler.responseBuilder("ALL Vendor Details", HttpStatus.OK,cloudVendorService.getALlCloudVendor());

    }
    @PostMapping
    public ResponseEntity<Object> createCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {

        return ResponseHandler.responseBuilder("Cloud Vendor Created Successfully", HttpStatus.OK, cloudVendorService.createCloudVendor(cloudVendor));


    }
@PutMapping
    public ResponseEntity<Object> updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
        return ResponseHandler.responseBuilder("Cloud Vendor Updated Successfully", HttpStatus.OK, cloudVendorService.updateCloudVendor(cloudVendor));

    }
    @DeleteMapping("{vendorId}")
    public ResponseEntity<Object> DeleteCloudVendorDetails(@PathVariable() String vendorId)
    {
        return ResponseHandler.responseBuilder("Cloud Vendor Deleted Successfully", HttpStatus.OK, cloudVendorService.deleteCloudVendor(vendorId));

    }
}
