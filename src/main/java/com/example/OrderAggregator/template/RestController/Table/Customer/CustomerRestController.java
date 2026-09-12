package com.example.OrderAggregator.template.RestController.Table.Customer;

import com.example.OrderAggregator.Base.API.Response.CAPIResponse;
import com.example.OrderAggregator.Base.Class.CResponse;
import com.example.OrderAggregator.template.API.Request.Customer.CCreateCustomerRequest;
import com.example.OrderAggregator.template.Service.Table.Customer.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CustomerRestController {

    private final CustomerService customerService;

    @PostMapping("/customers")
    public CAPIResponse createCustomer(@Valid @RequestBody CCreateCustomerRequest request) {

        return customerService.createCustomer(request);
    }
}