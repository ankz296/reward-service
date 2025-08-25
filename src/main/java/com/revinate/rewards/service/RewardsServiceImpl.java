package com.revinate.rewards.service;

import com.revinate.rewards.client.CasinoClient;
import com.revinate.rewards.client.HotelClient;
import com.revinate.rewards.client.RestaurantClient;
import com.revinate.rewards.dto.RewardsResponse;
import com.revinate.rewards.enums.ActivityType;
import com.revinate.rewards.enums.RewardType;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.Map;

@Service
public class RewardsServiceImpl implements RewardsService {

    private final HotelClient hotelClient;
    private final RestaurantClient restaurantClient;
    private final CasinoClient casinoClient;

    public RewardsServiceImpl(HotelClient hotelClient, RestaurantClient restaurantClient, CasinoClient casinoClient) {
        this.hotelClient = hotelClient;
        this.restaurantClient = restaurantClient;
        this.casinoClient = casinoClient;
    }


    /**
     * this method will give response with calculation of reward points based on customer Id and activity type
     * if activity type is empty it will calculate logic for all type
     * @param customerId
     * @param activityType
     * @return
     */
    @Override
    public RewardsResponse calculateRewardPoints(String customerId, ActivityType activityType) {
        Map<RewardType, Integer> points = new EnumMap<>(RewardType.class);
        if (activityType == null) {
            int nights = hotelClient.getNightsStayed(customerId);
            int reservations = restaurantClient.getReservations(customerId);
            double casinoSpend = casinoClient.getCasinoSpend(customerId);

            int hotelPoints = nights * 10;
            int restaurantPoints = reservations * 5;
            int casinoPoints = (int) (casinoSpend / 10);
            int totalPoints = hotelPoints + restaurantPoints + casinoPoints;

            points.put(RewardType.HOTEL_POINTS, hotelPoints);
            points.put(RewardType.RESTAURANT_POINTS, restaurantPoints);
            points.put(RewardType.CASINO_POINTS, casinoPoints);
            points.put(RewardType.TOTAL_POINTS, totalPoints);
        } else {
            switch (activityType) {
                case HOTEL -> {
                    int nights = hotelClient.getNightsStayed(customerId);
                    points.put(RewardType.HOTEL_POINTS, nights * 10);
                }
                case RESTAURANT -> {
                    int reservations = restaurantClient.getReservations(customerId);
                    points.put(RewardType.RESTAURANT_POINTS, reservations * 5);
                }
                case CASINO -> {
                    double casinoSpend = casinoClient.getCasinoSpend(customerId);
                    points.put(RewardType.CASINO_POINTS, (int) (casinoSpend / 10));
                }
            }
        }
        return new RewardsResponse(customerId, points);
    }
}
