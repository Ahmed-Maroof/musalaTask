package com.ofa.musala.service;

import com.ofa.musala.dto.DeviceDto;
import com.ofa.musala.model.Device;
import com.ofa.musala.model.Gateway;
import com.ofa.musala.payload.requests.AddGateWayRequest;
import com.ofa.musala.payload.responses.AddGateWayResponse;
import com.ofa.musala.repos.DeviceRepository;
import com.ofa.musala.repos.GatewayRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GatewayService {

    @Autowired
    GatewayRepository gatewayRepository;

    @Autowired
    DeviceRepository deviceRepository;

    public AddGateWayResponse addGateway(AddGateWayRequest addGateWayRequest) {

        ModelMapper modelMapper = new ModelMapper();
        Gateway gateway = modelMapper.map(addGateWayRequest, Gateway.class);

        Set<Device> deviceSet = new HashSet<>();

        for (DeviceDto deviceDto : addGateWayRequest.getDevices()) {

            Device tempDevice = modelMapper.map(deviceDto, Device.class);
            tempDevice.setGateway(gateway);
            deviceSet.add(tempDevice);
        }
        Gateway returnedGateway = gatewayRepository.save(gateway);

        if (null != returnedGateway) {
            deviceRepository.saveAll(deviceSet);
            returnedGateway.setDeviceSet(deviceSet);
            return new AddGateWayResponse("200", "succss add gateway", returnedGateway);
        } else {
            return new AddGateWayResponse("400", "error in adding gatway");
        }
    }

    public List<Gateway> findAllGateways ()
    {
        return gatewayRepository.findAll();
    }

    public Optional<Gateway> findById (Long id)
    {
        return gatewayRepository.findById(id.intValue());
    }
}
