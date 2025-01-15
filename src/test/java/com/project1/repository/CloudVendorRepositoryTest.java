package com.project1.repository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project1.CloudVendor.model.CloudVendor;
import com.project1.CloudVendor.repository.CloudVendorRepository;

@DataJpaTest
public class CloudVendorRepositoryTest {
    
    @Autowired
    private CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp(){
        cloudVendor = new CloudVendor("1","Amazon",
        "USA","xxxx");
        cloudVendorRepository.save(cloudVendor);
    }

    @AfterAll
    void tearDown(){
        cloudVendor = null;
        cloudVendorRepository.deleteAll();
    }

    // Testcase SUCCESS
    void testFindByVendorName_Found(){
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("Amazon");
        assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
    }

    // Testcase FAILURE
    
}
