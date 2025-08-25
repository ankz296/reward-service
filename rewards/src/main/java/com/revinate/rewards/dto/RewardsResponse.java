package com.revinate.rewards.dto;

import com.revinate.rewards.enums.RewardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RewardsResponse {
    private String customerId;
    private Map<RewardType, Integer> points;
}
