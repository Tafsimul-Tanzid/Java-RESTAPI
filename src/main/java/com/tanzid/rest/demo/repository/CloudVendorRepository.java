package com.tanzid.rest.demo.repository;

import com.tanzid.rest.demo.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {

    boolean existsByVendorId(String vendorId);
}
