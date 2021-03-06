package com.ofa.musala.payload.requests;

import com.ofa.musala.dto.DeviceDto;
import com.ofa.musala.util.IPV4;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class AddGateWayRequest implements Serializable {

    @NotBlank
    @Size(max = 45 ,message = "size limit to 45 char")
    public String name;

    @NotBlank
    @Size(max = 45 ,message = "size limit to 45 char")
    public String serialNumber;

    @NotBlank
    @Size(max = 45 ,message = "size limit to 45 char")
    @IPV4
    public String IPV4;

    @Size(min=1, max=10 , message = "number of devices must between 1 : 10")
    public Set<DeviceDto> devices ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getIPV4() {
        return IPV4;
    }

    public void setIPV4(String IPV4) {
        this.IPV4 = IPV4;
    }

    public Set<DeviceDto> getDevices() {
        return devices;
    }

    public void setDevices(Set<DeviceDto> devices) {
        this.devices = devices;
    }

    public AddGateWayRequest(@NotBlank @Size(max = 45, message = "size limit to 45 char") String name, @NotBlank @Size(max = 45, message = "size limit to 45 char") String serialNumber, @NotBlank @Size(max = 45, message = "size limit to 45 char") String IPV4, Set<DeviceDto> devices) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.IPV4 = IPV4;
        this.devices = devices;
    }
}
