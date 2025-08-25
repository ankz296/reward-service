package com.revinate.rewards.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class CasinoClient {

    private final RestTemplate restTemplate;

    public CasinoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * this method call casino external API and get not of dollar spend customer
     * @param customerId
     * @return amount spent by customer
     */
    public double getCasinoSpend(String customerId) {

        // it will call rest call for casion amount spend API for get
        // String url = "https://casino.revinate.com/api/va1/spend/" + customerId;
        // Double spend = restTemplate.getForObject(url, Double.class);

        // run time it will give spend between $50.0 and $200.0
        double mockedSpend = ThreadLocalRandom.current().nextDouble(50.0, 200.0);

        System.out.println("Mocked data for Casino Spend: $" + mockedSpend);
        return mockedSpend;
    }
}
