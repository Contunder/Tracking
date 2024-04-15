package com.microservice.tracking.tracking.domain.gateway;

import lombok.Data;

import java.util.List;

@Data
public class PurchaseListDTO {
    List<PurchaseDTO> purchasesDTO;
}
