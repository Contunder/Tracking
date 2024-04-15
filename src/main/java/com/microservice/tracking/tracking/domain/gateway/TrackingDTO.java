package com.microservice.tracking.tracking.domain.gateway;

import lombok.Data;

@Data
public class TrackingDTO {

    private String email;
    private String createType;
    private int createId;

}
