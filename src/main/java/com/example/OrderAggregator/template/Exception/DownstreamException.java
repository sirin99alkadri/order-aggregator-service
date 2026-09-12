package com.example.OrderAggregator.template.Exception;

public class DownstreamException extends RuntimeException {

    public DownstreamException(Throwable cause) {
        super(cause);
    }
}