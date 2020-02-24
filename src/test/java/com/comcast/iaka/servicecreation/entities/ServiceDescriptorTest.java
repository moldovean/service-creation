package com.comcast.iaka.servicecreation.entities;

import com.comcast.iaka.servicecreation.repos.ServiceDescriptorRepo;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

@SpringBootTest
class ServiceDescriptorTest {

    @Autowired
    ServiceDescriptorRepo serviceDescriptorRepo;


    @Test
    public void createEntryInCassandra() {
        ServiceDescriptor serviceDescriptor = new ServiceDescriptor();
        serviceDescriptor.setFqdn("iakaiaka02uu");
        serviceDescriptor.setId(1L);
        serviceDescriptor.setVmdName("VMD_RED");
        List<String> vcsNames = Arrays.asList("VCS_RED", "VCS_BLUE");
        serviceDescriptor.setVcsNames(vcsNames);
        Mono<ServiceDescriptor> insert = serviceDescriptorRepo.insert(serviceDescriptor);
        insert.subscribe();


    }

}