package com.microservice.tracking.tracking.domain.gateway;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrackingDTO {

    private String email;
    private String createType;
    private long createId;

}
