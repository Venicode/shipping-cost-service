package com.venicode.ShippingCost.dtos;

public record ConfigPriceDto(
        String cepOrigin,
        double costPerKm
) {
}
