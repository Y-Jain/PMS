package com.YJ.PMS.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {
    private String message;
    public String getMessage(String message) {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
