package com.venicode.ShippingCost.dtos;

import com.venicode.ShippingCost.domains.ConfigPrice;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ShippingDto(

        @NotNull
        double shippingCost,
        @NotNull
        ConfigPrice configPrice,
        @NotNull
        double durationMinutes,
        @NotNull
        double km

) {
}
