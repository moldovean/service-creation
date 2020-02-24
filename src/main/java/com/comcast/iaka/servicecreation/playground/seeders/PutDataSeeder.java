package com.comcast.iaka.servicecreation.playground.seeders;

import com.comcast.iaka.servicecreation.playground.models.Car;
import com.comcast.iaka.servicecreation.playground.repos.CarRepo;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class PutDataSeeder implements ApplicationListener<ApplicationReadyEvent> {

    private final CarRepo carRepo;
    private Logger logger = LoggerFactory.getLogger(PutDataSeeder.class);

    public PutDataSeeder(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public void insertSomeData() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", 200, 45000));
        cars.add(new Car("Audi", 180, 38000));
        cars.add(new Car("Honda", 155, 29000));
        Flux<Car> insert1 = carRepo.insert(Flux.fromStream(cars.stream()));
//        Flux.fromArray(cars.toArray(new Car[cars.size()]));
        insert1.subscribe();

        logger.info("Addded cars");

    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        insertSomeData();
    }
}
