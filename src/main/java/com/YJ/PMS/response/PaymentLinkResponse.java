package com.YJ.PMS.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentLinkResponse {
    private String payment_link_url;
    public void setPayment_link_url(String payment_link_url) {
        this.payment_link_url = payment_link_url;
    }
    private String payment_link_id;
    public void setPayment_link_id(String payment_link_id) {
        this.payment_link_id = payment_link_id;
    }
}
