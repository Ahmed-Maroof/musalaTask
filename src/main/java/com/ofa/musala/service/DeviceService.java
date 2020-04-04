package com.ofa.musala.service;

import com.ofa.musala.model.Device;
import com.ofa.musala.model.Gateway;
import com.ofa.musala.payload.requests.AddDeviceRequest;
import com.ofa.musala.payload.responses.GeneralResponse;
import com.ofa.musala.repos.DeviceRepository;
import com.ofa.musala.repos.GatewayRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    GatewayRepository gatewayRepository;

    @Autowired
    DeviceRepository deviceRepository;


    public GeneralResponse addDevice (AddDeviceRequest addDeviceRequest , Long gatewayId)
    {
//        check for this gateway

         Optional<Gateway> gateway =  gatewayRepository.findById(gatewayId.intValue());

         if(gateway.isPresent())
         {
             ModelMapper modelMapper = new ModelMapper();
             Device device = modelMapper.map(addDeviceRequest, Device.class);
             device.setGateway(gateway.get());


             Device savedDevice =  deviceRepository.save(device);

             return new GeneralResponse(200,"success add a device" , savedDevice);
         }else
         {
             return new GeneralResponse(404,"No gatway found with this Id " );

         }
    }

    public void deleteById(Long id) {

        deviceRepository.deleteById(id);
    }
}
