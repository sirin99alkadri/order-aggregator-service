package com.example.OrderAggregator.Base.Class;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@ToString
public class CResponse {

    private boolean isSuccess;
    private String message = "successfully";
    private Object data;

    public CResponse()
    {
        isSuccess = true;
    }

}
