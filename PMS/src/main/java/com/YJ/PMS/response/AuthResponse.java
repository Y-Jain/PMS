package com.YJ.PMS.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse<message> {
    private String jwt;
    public <jwt> String setJwt(String jwt){
        return jwt;
    }
//    public void getJwt(String jwt) {
//        this.jwt = jwt;
//    }
    private String message;
    public String setMessage(String message) {
        return message;
    }

    }

