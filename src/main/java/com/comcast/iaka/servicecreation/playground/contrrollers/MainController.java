package com.comcast.iaka.servicecreation.playground.contrrollers;

import com.comcast.iaka.servicecreation.playground.models.Car;
import com.comcast.iaka.servicecreation.playground.repos.CarRepo;
import com.comcast.iaka.servicecreation.playground.services.MyService;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MainController {

    private final CarRepo carRepo;
    private final MyService myService;

    public MainController(CarRepo carRepo, MyService myService) {
        this.carRepo = carRepo;
        this.myService = myService;
    }

    @GetMapping
    public Mono<String> hello() {
        return Mono.just("Hello Works");
    }

    @GetMapping(path = "/ping")
    public Mono<String> ping() {
        return Mono.just("Pong");
    }

    @GetMapping(path = "/add/car/{name}")
    public Mono<Car> addCar(@PathVariable String name) {
        return carRepo.insert(new Car(name, ThreadLocalRandom.current().nextInt(), ThreadLocalRandom.current().nextDouble()));
    }

    @GetMapping(path = "/get/cars")
    public Flux<Car> addCar() {
        return carRepo.findAll();
    }

    @GetMapping(path = "/delete/car/{name}")
    public Mono<Void> deleteCar(@PathVariable String name) {
        Mono<Car> byId = carRepo.findById(name);
        Car car = byId.block();
        return carRepo.deleteById(car.getName());
    }

    @GetMapping(path = "/get/car/{name}")
    public Mono<Car> getCar(@PathVariable String name) {
        return carRepo.findById(name);

    }

    @GetMapping(path = "get/something")
    public Mono<String> getSomething() {
        return myService.fetchSomething();
    }
}
