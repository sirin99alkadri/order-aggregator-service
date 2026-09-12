package com.example.OrderAggregator.template.Service.Table.Customer;

import com.example.OrderAggregator.Base.API.Response.CAPIResponse;
import com.example.OrderAggregator.template.API.Request.Customer.CCreateCustomerRequest;
import com.example.OrderAggregator.template.Client.OrderSystemClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final OrderSystemClient orderSystemClient;

    public CAPIResponse createCustomer(CCreateCustomerRequest request) {
        return orderSystemClient.createCustomer(request);
    }
}