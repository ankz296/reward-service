package com.revinate.rewards.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class RestaurantClient {

    private final RestTemplate restTemplate;

    public RestaurantClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * this method call restaurant external api and get not of reservations based on customerId
     * @param customerId
     * @return no of reservations
     */
    public int getReservations(String customerId) {

        // it will call rest call for restaurant API for get
        // String url = "https://restaurant.revinate.com/api/v1/reservations/" + customerId;
        // Integer reservations = restTemplate.getForObject(url, Integer.class);

        // run time it will give 1 to 5 value
        int mockedReservations = ThreadLocalRandom.current().nextInt(1, 6);

        System.out.println("Mock data for Restaurant Reservations: " + mockedReservations);
        return mockedReservations;

    }
}
