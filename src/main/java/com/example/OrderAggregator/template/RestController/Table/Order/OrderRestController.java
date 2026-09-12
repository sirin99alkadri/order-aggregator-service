package com.example.OrderAggregator.template.RestController.Table.Order;

import com.example.OrderAggregator.Base.API.Response.CAPIResponse;
import com.example.OrderAggregator.Base.Class.CResponse;
import com.example.OrderAggregator.template.API.Request.Order.CCreateOrderRequest;
import com.example.OrderAggregator.template.API.Response.CustomerOrder.CGetCustomerOrder;
import com.example.OrderAggregator.template.API.Response.DTO.Mapper.CustomerOrderMapper;
import com.example.OrderAggregator.template.Service.Table.Order.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderRestController {

    @Autowired
    OrderService orderService;

    @PostMapping("/orders")
    public CAPIResponse createOrder(@Valid @RequestBody CCreateOrderRequest request) {

        return orderService.createOrder(request);
    }

    @GetMapping("/customers/{customerId}/orders")
    CGetCustomerOrder getCustomerOrder(@PathVariable Long customerId)throws Exception {

        return orderService.getCustomerOrders(customerId);
    }

    @PutMapping("/orders/{orderId}/status")
    public CAPIResponse updateOrderStatus(@PathVariable Long orderId) {

        return orderService.updateOrderStatus(orderId);
    }
}
