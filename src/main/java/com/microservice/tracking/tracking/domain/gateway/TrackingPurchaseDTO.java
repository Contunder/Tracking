package com.microservice.tracking.tracking.domain.gateway;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TrackingPurchaseDTO {
    int viewCount;
    String eventType;
    PurchaseListDTO purchasesDTO;
}
