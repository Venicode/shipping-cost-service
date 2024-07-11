package com.venicode.ShippingCost.controllers;

import com.venicode.ShippingCost.dtos.ShippingDto;
import com.venicode.ShippingCost.services.ConfigPriceService;
import com.venicode.ShippingCost.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/shipping")
public class ShippingController {
    @Autowired
    private ShippingService shippingService;
    @GetMapping("{cep}&idConfigPrice={id}")
    public ResponseEntity<ShippingDto> getShippingPrice(@PathVariable String cep, @PathVariable Long id) throws Exception {
        return shippingService.returnShipping(id,cep);
    }
}
