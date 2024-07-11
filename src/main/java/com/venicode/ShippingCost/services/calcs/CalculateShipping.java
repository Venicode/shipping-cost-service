package com.venicode.ShippingCost.services.calcs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculateShipping {
    private double pricePerKm;
    private double km;

    public double calculateShipping(){
        return pricePerKm*km;
    }
}
