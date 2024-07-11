package com.venicode.ShippingCost.domains;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Row {
    private List<Element> elements;
}
