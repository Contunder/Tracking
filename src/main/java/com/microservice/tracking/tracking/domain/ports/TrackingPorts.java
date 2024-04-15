package com.microservice.tracking.tracking.domain.ports;

import com.microservice.tracking.tracking.domain.entities.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrackingPorts extends JpaRepository<Tracking, Long> {

    Optional<Tracking> findByEmail(String email);
    Boolean existsByEmail(String email);

}
