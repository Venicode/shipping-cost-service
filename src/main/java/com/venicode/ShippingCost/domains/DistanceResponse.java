package com.venicode.ShippingCost.domains;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DistanceResponse {
    private List<String> destination_addresses;
    private List<String> origin_addresses;
    private List<Row> rows;
    private String status;
}
