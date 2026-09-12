package com.example.OrderAggregator.template.Client;

import com.example.OrderAggregator.Base.API.Response.CAPIResponse;
import com.example.OrderAggregator.template.API.Request.Customer.CCreateCustomerRequest;
import com.example.OrderAggregator.template.API.Request.Order.CCreateOrderRequest;
import com.example.OrderAggregator.template.API.Response.CustomerOrder.CGetCustomerOrder;
import com.example.OrderAggregator.template.Exception.DownstreamException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class OrderSystemClient {

    private final WebClient webClient;

    @Value("${system.service.url}")
    private String systemServiceUrl;

    public CAPIResponse createCustomer(CCreateCustomerRequest request) {

        return webClient.post()
                .uri(systemServiceUrl + "/internal/customers")
                .bodyValue(request)
                .retrieve()
                .onStatus(
                        HttpStatusCode::isError,
                        response -> response.createException()
                                .map(DownstreamException::new)
                )
                .bodyToMono(CAPIResponse.class)
                .block();
    }

    public CAPIResponse createOrder(CCreateOrderRequest request) {

        return webClient.post()
                .uri(systemServiceUrl + "/internal/orders")
                .bodyValue(request)
                .retrieve()
                .onStatus(
                        HttpStatusCode::isError,
                        response -> response.createException()
                                .map(DownstreamException::new)
                )
                .bodyToMono(CAPIResponse.class)
                .block();
    }

    public CGetCustomerOrder getCustomerOrders(Long customerId) {

        return webClient.get()
                .uri(systemServiceUrl + "/internal/customers/" + customerId + "/order")
                .retrieve()
                .onStatus(
                        HttpStatusCode::isError,
                        response -> response.createException()
                                .map(DownstreamException::new)
                )
                .bodyToMono(CGetCustomerOrder.class)
                .block();
    }

    public CAPIResponse updateOrderStatus(
            Long orderId) {

        return webClient.put()
                .uri(systemServiceUrl + "/internal/orders/" + orderId + "/status")
                .retrieve()
                .onStatus(
                        HttpStatusCode::isError,
                        response -> response.createException()
                                .map(DownstreamException::new)
                )
                .bodyToMono(CAPIResponse.class)
                .block();
    }
}