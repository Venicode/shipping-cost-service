package com.venicode.ShippingCost.repositories;

import com.venicode.ShippingCost.domains.ConfigPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ConfigPriceRepository extends JpaRepository<ConfigPrice, Long> {
    Optional<ConfigPrice> findConfigPriceById(Long id);
}
