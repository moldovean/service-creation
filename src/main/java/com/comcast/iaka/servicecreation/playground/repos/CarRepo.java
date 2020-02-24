package com.comcast.iaka.servicecreation.playground.repos;

import com.comcast.iaka.servicecreation.playground.models.Car;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface CarRepo extends ReactiveCassandraRepository<Car, String> {

}
