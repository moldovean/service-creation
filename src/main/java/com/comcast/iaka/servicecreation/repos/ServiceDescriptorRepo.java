package com.comcast.iaka.servicecreation.repos;

import com.comcast.iaka.servicecreation.entities.ServiceDescriptor;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface ServiceDescriptorRepo extends ReactiveCassandraRepository<ServiceDescriptor, Long> {

}
