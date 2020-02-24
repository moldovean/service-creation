package com.comcast.iaka.servicecreation.playground.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.core.publisher.Mono;

@Service
public class MyService {
    //http://tools17.dsea.comcast.net:16301/v1.0/uCPEs/ce-hnvrma3701w.ucpe.comcast.net

    public Mono<String> fetchSomething() {
        WebClient webClient = WebClient.builder()
                                   .baseUrl("http://tools17.dsea.comcast.net:16301")
                                   .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                   .build();

        RequestHeadersSpec<?> uri = webClient.get().uri("v1.0/uCPEs/ce-hnvrma3701w.ucpe.comcast.net");
        ResponseSpec retrieve = uri.retrieve();
        Mono<String> stringMono = retrieve.bodyToMono(String.class);
        return stringMono;
    }


}
