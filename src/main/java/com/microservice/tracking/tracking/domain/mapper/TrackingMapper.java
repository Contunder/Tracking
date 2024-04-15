package com.microservice.tracking.tracking.domain.mapper;


import com.microservice.tracking.tracking.domain.entities.Tracking;
import com.microservice.tracking.tracking.domain.gateway.TrackingDTO;

public class TrackingMapper {

    public Tracking mapToModel(TrackingDTO trackingDTO) {
        return Tracking.builder()
                .email(trackingDTO.getEmail())
                .createType(trackingDTO.getCreateType())
                .createId(trackingDTO.getCreateId())
                .build();
    }

    public TrackingDTO mapToDto(Tracking tracking) {
        return TrackingDTO.builder()
                .email(tracking.getEmail())
                .createType(tracking.getCreateType())
                .createId(tracking.getCreateId())
                .build();
    }

}
