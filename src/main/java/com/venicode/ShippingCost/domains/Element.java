package com.venicode.ShippingCost.domains;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Element {
    private Distance distance;
    private Duration duration;
    private String status;
}
