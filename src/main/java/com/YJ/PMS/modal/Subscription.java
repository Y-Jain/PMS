package com.YJ.PMS.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private LocalDate subscriptionStartDate;
    public void setSubscriptionStartDate(LocalDate subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }
    private LocalDate getSubscriptionEndDate;
    public LocalDate getGetSubscriptionEndDate() {
        return getSubscriptionEndDate;
    }
    public void setGetSubscriptionEndDate(LocalDate getSubscriptionEndDate) {
        this.getSubscriptionEndDate = getSubscriptionEndDate;
    }

    private PlanType planType;
    public PlanType getPlanType() {
        return planType;
    }
    public void setPlanType(PlanType planType) {
        this.planType = planType;
    }
    //    private boolean isValid;
    private  boolean isValid;
    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }
    @OneToOne
    private User user;
    public void setUser(User user) {
        this.user = user;
    }

}
