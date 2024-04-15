package com.microservice.tracking.tracking.domain.usecase;

import com.microservice.tracking.tracking.domain.gateway.TrackingDTO;
import com.microservice.tracking.tracking.domain.mapper.TrackingMapper;
import com.microservice.tracking.tracking.domain.ports.TrackingPorts;
import org.springframework.stereotype.Component;

@Component
public class AddTrackingEvent {

    private final TrackingMapper trackingMapper;
    private final TrackingPorts trackingPorts;

    public AddTrackingEvent(TrackingPorts trackingPorts) {
        this.trackingPorts = trackingPorts;
        this.trackingMapper = new TrackingMapper();
    }

    public TrackingDTO execute(TrackingDTO trackingDTO, String email) {

        return trackingMapper.mapToDto(
                trackingPorts.save(trackingMapper.mapToModel(trackingDTO, email))
        );
    }

}
