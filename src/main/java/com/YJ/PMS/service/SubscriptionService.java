package com.YJ.PMS.service;

import com.YJ.PMS.modal.PlanType;
import com.YJ.PMS.modal.Subscription;
import com.YJ.PMS.modal.User;

import java.util.concurrent.Flow;
public interface SubscriptionService {
    Subscription createSubscription(User user);
    Subscription upgradeSubscription(Long userId, PlanType planType);
    Subscription getUsersSubscription(Long userId) throws Exception;

    boolean isValid(Subscription subscription);
}

