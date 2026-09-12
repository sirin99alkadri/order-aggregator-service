package com.example.OrderAggregator.template.API.Response.CustomerOrder;

import com.example.OrderAggregator.Base.API.Response.CAPIResponse;
import com.example.OrderAggregator.template.API.Response.DTO.CustomerOrderDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CGetCustomerOrder extends CAPIResponse {

    private List<CustomerOrderDTO> customerOrder;
}
