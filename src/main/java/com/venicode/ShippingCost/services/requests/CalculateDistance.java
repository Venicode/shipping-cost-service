package com.venicode.ShippingCost.services.requests;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CalculateDistance {
    private String url="https://maps.googleapis.com/maps/api/distancematrix/json";

    @Value("${ShippingCost.security.token.secret}")
    private String secret;
    public HttpResponse<String> calculateDistance(String destination, String origin) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url+"?destinations="+destination +
                        "&language=pt-BR&mode=car"+
                        "&origins="+origin +
                        "&key="+secret))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        return HttpClient.newHttpClient().send(request,HttpResponse.BodyHandlers.ofString());
    }
}
