package com.venicode.ShippingCost.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.venicode.ShippingCost.domains.*;
import com.venicode.ShippingCost.dtos.ShippingDto;
import com.venicode.ShippingCost.services.calcs.CalculateShipping;
import com.venicode.ShippingCost.services.requests.CalculateDistance;
import com.venicode.ShippingCost.services.requests.RequestCEP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

@Service
public class ShippingService {
    RequestCEP requestCEP = new RequestCEP();
    CalculateShipping calculateShipping = new CalculateShipping();
    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    ConfigPriceService configPriceService;
    public ResponseEntity<ShippingDto> returnShipping(Long id, String cepDestination) throws Exception {
        double priceTotal = 0;
        double durationMinutes = 0;
        double km = 0;

        ConfigPrice configPrice = configPriceService.findConfigPriceById(id);
        calculateShipping.setPricePerKm(configPrice.getCostPerKm());
        String origin = returnLocationByCEP(configPrice.getCepOrigin());
        String destination = returnLocationByCEP(cepDestination);
        CalculateDistance calculateDistance = new CalculateDistance();
        HttpResponse<String> responseDistance= calculateDistance.calculateDistance(destination,origin);
        DistanceResponse distanceResponse= objectMapper.readValue(responseDistance.body(), DistanceResponse.class);

        List<Row> rowList = distanceResponse.getRows();
        for (Row row : rowList){
            for(Element element: row.getElements()){
                Distance distance = element.getDistance();
                Duration duration = element.getDuration();
                durationMinutes = (double) duration.getValue() /60;
                km = (double) distance.getValue() /1000;
                calculateShipping.setKm(km);
                priceTotal = calculateShipping.calculateShipping();
            }
        }
        ShippingDto shippingDto = new ShippingDto(priceTotal,configPrice,durationMinutes, km);
        return new ResponseEntity<>(shippingDto, HttpStatus.OK);
    }
    public String returnLocationByCEP(String cep) throws IOException, InterruptedException {
        HttpResponse<String> response = requestCEP.getAddressByCep(cep);
        Map mapCEP = objectMapper.readValue(response.body(), new TypeReference<Map>(){});
        return mapCEP.get("localidade").toString().replaceAll(" ","");
    }
}
