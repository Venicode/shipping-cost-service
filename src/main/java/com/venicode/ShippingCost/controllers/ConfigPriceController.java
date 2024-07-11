package com.venicode.ShippingCost.controllers;

import com.venicode.ShippingCost.domains.ConfigPrice;
import com.venicode.ShippingCost.dtos.ConfigPriceDto;
import com.venicode.ShippingCost.services.ConfigPriceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/configPrice")
public class ConfigPriceController {
    @Autowired
    ConfigPriceService configPriceService;

    @PostMapping
    public ResponseEntity<ConfigPrice> createConfigPrice(@RequestBody @Valid ConfigPriceDto configPriceDto){
        return this.configPriceService.createConfigPrice(configPriceDto);
    }
    @PutMapping("{id}")
    public ResponseEntity<ConfigPrice> updateConfigPrice(@RequestBody @Valid ConfigPriceDto configPriceDto, @PathVariable Long id) throws Exception {
       this.configPriceService.updateConfigPrice(id,configPriceDto);
        return ResponseEntity.noContent().build();
    }
}
