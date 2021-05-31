package com.ssl_controller;

import com.ssl_service.SSLCommerz;
import com.ssl_utils.ParameterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ssl/")
public class SSL_Payment {
    @Autowired
    private ParameterBuilder parameterBuilder;
    @Autowired
    private SSLCommerz sslCommerz;

    public SSL_Payment() {
    }

    public SSL_Payment(ParameterBuilder parameterBuilder) {
        this.parameterBuilder = parameterBuilder;
    }

    @GetMapping
    public String getPaymentGatewayLink() throws Exception {
        String paymentGatewayUrl = sslCommerz.initiateTransaction(parameterBuilder.constructRequestParameters(),false);
        System.out.println(paymentGatewayUrl);
        return paymentGatewayUrl;
    }
}
