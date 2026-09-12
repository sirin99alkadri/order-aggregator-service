package com.example.OrderAggregator.template.API.Request.Order;

import com.example.OrderAggregator.Base.API.Request.CAPIRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CCreateOrderRequest extends CAPIRequest {

    @NotNull
    private Long customerId;

    @NotNull
    private Long quantity;

    @NotNull
    @Positive(message = "Amount must be greater than zero")
    private Double price;

    @NotBlank
    private String productName;

}
