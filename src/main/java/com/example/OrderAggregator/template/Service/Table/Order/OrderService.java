package com.example.OrderAggregator.template.Service.Table.Order;

import com.example.OrderAggregator.Base.API.Response.CAPIResponse;
import com.example.OrderAggregator.template.API.Request.Order.CCreateOrderRequest;
import com.example.OrderAggregator.template.API.Response.CustomerOrder.CGetCustomerOrder;
import com.example.OrderAggregator.template.Client.OrderSystemClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderSystemClient orderSystemClient;

    public CAPIResponse createOrder(CCreateOrderRequest request) {
        return orderSystemClient.createOrder(request);
    }

    public CGetCustomerOrder getCustomerOrders(Long customerId) {
        return orderSystemClient.getCustomerOrders(customerId);
    }

    public CAPIResponse updateOrderStatus(Long orderId) {

        return orderSystemClient.updateOrderStatus(orderId);
    }
}