package com.ofa.musala;

import com.ofa.musala.controller.WSController;
import com.ofa.musala.model.Device;
import com.ofa.musala.model.Gateway;
import com.ofa.musala.service.GatewayService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class WSControllerTest {

    @InjectMocks
    WSController wsController;

    @Mock
    GatewayService gatewayService;

    @Test
    public void testFindAll()
    {
//        // given
//        Employee employee1 = new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
//        Employee employee2 = new Employee(2, "Alex", "Gussin", "example@gmail.com");
//        Employees employees = new Employees();

        Gateway gateway1 = new Gateway();
        gateway1.setId(1);
        gateway1.setIPV4("192.168.1.1");
        gateway1.setName("gateway1");
        gateway1.setSerialNumber("123456");

        Device device1 = new Device();
        device1.setId( Long.valueOf(1) );
        device1.setDateCreated(LocalDateTime.now());
        device1.setVendor("test vendor");
        device1.setStatus("online");
        device1.setGateway(gateway1);

        Device device2 = new Device();
        device2.setId( Long.valueOf(2) );
        device2.setDateCreated(LocalDateTime.now());
        device2.setVendor("test2 vendor");
        device2.setStatus("online");
        device1.setGateway(gateway1);

        Set<Device> deviceSet = new HashSet<>();
        deviceSet.add(device1);
        deviceSet.add(device2);

        gateway1.setDeviceSet(deviceSet);

        List<Gateway> gatewayList = new ArrayList<>();
        gatewayList.add(gateway1);


        when(gatewayService.findAllGateways()).thenReturn(gatewayList);

        // when
        ResponseEntity responseEntity = wsController.findAll();

        // then
        assertThat(responseEntity.getStatusCode())
                .isEqualTo(HttpStatus.OK);;


    }
}
