package com.revinate.rewards.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class HotelClient {

    private final RestTemplate restTemplate;

    public HotelClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * this method call hotel external API and get not of night stay by customerId
     * @param customerId
     * @return no of night stay
     */
    public int getNightsStayed(String customerId) {

        // it will call rest call for hotel night stay details API for get
        // String url = "https:/hotel.revinate.com/api/v1/nights/" + customerId;
        // Integer nights = restTemplate.getForObject(url, Integer.class);

        // run time it will give between 1 and 7
        int mockedNights = ThreadLocalRandom.current().nextInt(1, 8);

        System.out.println("Mock data for  Hotel Nights Stayed: " + mockedNights);
        return mockedNights;
    }
}

