package com.revinate.rewards.controller;

import com.revinate.rewards.dto.ApiResponse;
import com.revinate.rewards.dto.RewardsResponse;
import com.revinate.rewards.enums.ActivityType;
import com.revinate.rewards.exception.InvalidRequestException;
import com.revinate.rewards.service.RewardsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class RewardsController {

    @Autowired
    private RewardsService rewardsService;

    /**
     * API calculate dynamic rewards based on current data for specific customers and specific activity type as well.
     * activity type is optional so in that case it will give reward points for all services
     *
     * @param customerId
     * @param activityType
     * @return
     */
    @Operation(summary = "Get reward points for a customer")
    @GetMapping("/{customerId}")
    public ResponseEntity<ApiResponse<RewardsResponse>> calculateRewardPoints(@Parameter(description = "Unique customer ID")
                                                                        @PathVariable("customerId") String customerId,
                                                                        @Parameter(description = "Filter by activity type", required = false)
                                                                        @RequestParam(value = "activityType", required = false) ActivityType activityType) {

        RewardsResponse rewardPoints = rewardsService.calculateRewardPoints(customerId, activityType);
        if (rewardPoints != null) {
            return ResponseEntity.ok(
                    new ApiResponse<>("SUCCESS", "Rewards calculated successfully", rewardPoints));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
