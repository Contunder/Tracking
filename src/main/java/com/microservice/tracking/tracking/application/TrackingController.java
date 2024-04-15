package com.microservice.tracking.tracking.application;

import com.microservice.tracking.security.JwtAuthenticationFilter;
import com.microservice.tracking.security.JwtTokenProvider;
import com.microservice.tracking.tracking.domain.gateway.TrackingDTO;
import com.microservice.tracking.tracking.domain.usecase.AddTrackingEvent;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tracking")
public class TrackingController {

    private final AddTrackingEvent addTrackingEvent;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final JwtTokenProvider jwtTokenProvider;

    public TrackingController(AddTrackingEvent addTrackingEvent, JwtAuthenticationFilter jwtAuthenticationFilter, JwtTokenProvider jwtTokenProvider) {
        this.addTrackingEvent = addTrackingEvent;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/add")
    public ResponseEntity<TrackingDTO> createTracking(
            HttpServletRequest request,
            @Valid @RequestBody TrackingDTO trackingDTO
    ) {
        String token = jwtAuthenticationFilter.getTokenFromRequest(request);
        jwtTokenProvider.validateToken(token);
        String email = jwtTokenProvider.getUsername(token);

        return new ResponseEntity<>(addTrackingEvent.execute(trackingDTO, email), HttpStatus.CREATED);
    }

}
