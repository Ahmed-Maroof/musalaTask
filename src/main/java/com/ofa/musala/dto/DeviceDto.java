package com.ofa.musala.dto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class DeviceDto {

    @NotBlank
    String vendor ;

    @NotBlank
    LocalDateTime dateCreated ;

    @NotBlank
    String status;

    public String getVendor() {

        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
