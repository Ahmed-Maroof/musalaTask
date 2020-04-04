package com.ofa.musala.controller;

import com.ofa.musala.model.Gateway;
import com.ofa.musala.payload.requests.AddDeviceRequest;
import com.ofa.musala.payload.requests.AddGateWayRequest;
import com.ofa.musala.payload.responses.GeneralResponse;
import com.ofa.musala.service.DeviceService;
import com.ofa.musala.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/test")
public class WSController {

    @Autowired
    GatewayService gatewayService;

    @Autowired
    DeviceService deviceService;


    @PostMapping("/addGateway")
    public ResponseEntity<?> AddGateway(@Valid @RequestBody AddGateWayRequest addGateWayRequest) {
        return  ResponseEntity.ok(gatewayService.addGateway(addGateWayRequest)) ;

    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return  ResponseEntity.ok(gatewayService.findAllGateways()) ;

    }

    @GetMapping("/gateways/{id}")
    public ResponseEntity<?> getGatewayById(@PathVariable Long id) {
        Optional<Gateway> gateway = gatewayService.findById(id);
        if(gateway.isPresent())
        {
            return  ResponseEntity.ok(gateway) ;
        }else
        {
            return ResponseEntity.ok(new GeneralResponse(404,"no Gateways found with this id "));
        }

    }

    @PostMapping("/addDevice/{gatewayId}")
    public ResponseEntity<?> AddGateway(@Valid @RequestBody AddDeviceRequest addDeviceRequest, @PathVariable Long gatewayId) {
        return  ResponseEntity.ok(deviceService.addDevice(addDeviceRequest , gatewayId)) ;

    }



//    @DeleteMapping("/employees/{id}")
//    void deleteEmployee(@PathVariable Long id) {
//        repository.deleteById(id);
//    }
}
