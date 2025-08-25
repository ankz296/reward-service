package com.revinate.rewards.service;

import com.revinate.rewards.dto.RewardsResponse;
import com.revinate.rewards.enums.ActivityType;

public interface RewardsService {
    public RewardsResponse calculateRewardPoints(String customerId, ActivityType activityType);

}
