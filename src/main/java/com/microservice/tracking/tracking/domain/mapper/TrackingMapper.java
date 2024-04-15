package com.microservice.tracking.tracking.domain.mapper;


import com.microservice.tracking.tracking.domain.entities.Tracking;
import com.microservice.tracking.tracking.domain.gateway.TrackingDTO;

public class TrackingMapper {

    public Tracking mapToModel(TrackingDTO trackingDTO, String email) {
        return Tracking.builder()
                .email(email)
                .createType(trackingDTO.getCreateType())
                .createId(trackingDTO.getCreateId())
                .build();
    }

}
