package com.ofa.musala.controller;

import com.ofa.musala.payload.requests.AddGateWayRequest;
import com.ofa.musala.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/test")
public class WSController {

    @Autowired
    GatewayService gatewayService;


    @PostMapping("/addgateway")
    public ResponseEntity<?> AddGateway(@Valid @RequestBody AddGateWayRequest addGateWayRequest) {
        return  ResponseEntity.ok(gatewayService.addGateway(addGateWayRequest)) ;

    }
}
