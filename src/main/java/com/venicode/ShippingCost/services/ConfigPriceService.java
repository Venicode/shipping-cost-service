package com.venicode.ShippingCost.services;

import com.venicode.ShippingCost.domains.ConfigPrice;
import com.venicode.ShippingCost.dtos.ConfigPriceDto;
import com.venicode.ShippingCost.repositories.ConfigPriceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConfigPriceService {
    @Autowired
    private ConfigPriceRepository configPriceRepository;

    public ResponseEntity<ConfigPrice> createConfigPrice(ConfigPriceDto configPriceDto){
        ConfigPrice configPrice = new ConfigPrice();
        configPrice.setCepOrigin(configPriceDto.cepOrigin());
        configPrice.setCostPerKm(configPriceDto.costPerKm());
        this.configPriceRepository.save(configPrice);

        return new ResponseEntity<>(configPrice, HttpStatus.CREATED);
    }
    public ConfigPrice findConfigPriceById(Long id){
        return this.configPriceRepository.findConfigPriceById(id)
         .orElseThrow(()-> new EntityNotFoundException("Config Price not found."));
    }
    public void updateConfigPrice(Long id, ConfigPriceDto configPriceDto) {
        ConfigPrice configPrice = findConfigPriceById(id);
        configPrice.setCepOrigin(configPriceDto.cepOrigin());
        configPrice.setCostPerKm(configPriceDto.costPerKm());
        this.configPriceRepository.save(configPrice);
    }

}
