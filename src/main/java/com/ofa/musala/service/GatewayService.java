package com.ofa.musala.service;

import com.ofa.musala.model.Device;
import com.ofa.musala.model.Gateway;
import com.ofa.musala.payload.requests.AddGateWayRequest;
import com.ofa.musala.payload.responses.AddGateWayResponse;
import com.ofa.musala.repos.GatewayRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class GatewayService {

    @Autowired
    GatewayRepository gatewayRepository;

    public AddGateWayResponse addGateway (AddGateWayRequest addGateWayRequest)
    {

        ModelMapper modelMapper = new ModelMapper();
        Gateway gateway  = modelMapper.map(addGateWayRequest , Gateway.class);

        Set<Device> deviceSet = new HashSet<>();
        addGateWayRequest.getDevices().forEach(e->
        {
            Device tempDevice = modelMapper.map(e , Device.class);
            tempDevice.setGateway(gateway);
            deviceSet.add(tempDevice);
        });
        gateway.setDeviceSet(deviceSet);
       Gateway returnedGateway =  gatewayRepository.save(gateway);

       if( null != returnedGateway)
       {
           return new AddGateWayResponse("200", "succss add gateway" , returnedGateway);
       }
       else
       {
           return  new AddGateWayResponse("400" , "error in adding gatway");
       }
    }
}
