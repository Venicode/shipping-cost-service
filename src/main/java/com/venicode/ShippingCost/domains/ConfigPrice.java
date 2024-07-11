package com.venicode.ShippingCost.domains;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ConfigPrice")
@Table(name = "TB_CONFIG_PRICE")
@Getter
@Setter
@EqualsAndHashCode(of="id")
public class ConfigPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cepOrigin;
    private double costPerKm;
}
