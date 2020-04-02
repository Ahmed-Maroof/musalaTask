package com.ofa.musala.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "gateway")
public class Gateway {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;


    @Column(name = "NAME")
    private String name;


    @Column(name = "IPV4")
    private String IPV4;

    @Column(name = "serial_number")
    private String serialNumber;

    @OneToMany(mappedBy = "gateway")
    private Set<Device> deviceSet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIPV4() {
        return IPV4;
    }

    public void setIPV4(String IPV4) {
        this.IPV4 = IPV4;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Set<Device> getDeviceSet() {
        return deviceSet;
    }

    public void setDeviceSet(Set<Device> deviceSet) {
        this.deviceSet = deviceSet;
    }
}
