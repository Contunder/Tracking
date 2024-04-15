package com.microservice.tracking.tracking.domain.mapper;

import com.microservice.tracking.tracking.domain.gateway.PurchaseDTO;
import com.microservice.tracking.tracking.domain.gateway.PurchaseListDTO;
import com.microservice.tracking.tracking.domain.gateway.TrackingPurchaseDTO;

import java.util.List;
import java.util.Optional;

public class TrackingPurchaseMapper {

    public TrackingPurchaseDTO mapToDto(Integer count, String eventType, String userEmail, PurchaseListDTO purchasesDTO) {
        return TrackingPurchaseDTO.builder()
                .viewCount(count)
                .eventType(eventType)
                .userEmail(userEmail)
                .purchasesDTO(purchasesDTO)
                .build();
    }
}
