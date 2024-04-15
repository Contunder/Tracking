package com.microservice.tracking.tracking.domain.usecase;

import com.microservice.tracking.exception.AccountAPIException;
import com.microservice.tracking.tracking.domain.gateway.PurchaseListDTO;
import com.microservice.tracking.tracking.domain.gateway.TrackingPurchaseDTO;
import com.microservice.tracking.tracking.domain.mapper.JsonBodyHandler;
import com.microservice.tracking.tracking.domain.mapper.TrackingPurchaseMapper;
import com.microservice.tracking.tracking.domain.ports.TrackingPorts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.concurrent.ExecutionException;

@Component
public class ViewPurchaseTracking {

    private final TrackingPurchaseMapper trackingPurchaseMapper;
    private final TrackingPorts trackingPorts;
    private final HttpClient client;

    @Value("${purchase.get}")
    private String purchaseUrl;

    public ViewPurchaseTracking(TrackingPorts trackingPorts) {
        this.trackingPorts = trackingPorts;
        this.trackingPurchaseMapper = new TrackingPurchaseMapper();
        this.client = HttpClient.newHttpClient();
    }

    public TrackingPurchaseDTO execute(String email, String token) throws ExecutionException, InterruptedException {

        HttpRequest getUserDetails = HttpRequest.newBuilder(
                        URI.create(purchaseUrl)
                )
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        var purchaseResponseFuture = client.sendAsync(getUserDetails, new JsonBodyHandler<>(PurchaseListDTO.class));

        return trackingPurchaseMapper.mapToDto(
                trackingPorts.countTrackingByEmailAndAndCreateType(email, "Purchase").orElseThrow(
                        () -> new AccountAPIException(HttpStatus.NOT_FOUND, "User not found with email: " + email)
                ),
                "Purchase",
                email,
                purchaseResponseFuture.get().body().get()
        );
    }

}
