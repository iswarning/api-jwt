package com.example.api.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Name is required")
    private String name;

    private int cmnd;

    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    private String household;

    private int phone;

    @OneToMany(mappedBy="customer",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Contract> contracts = new ArrayList<>();

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public Customer(Integer id, String name, int cmnd, String address, LocalDate birthday, String household, int phone, List<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.cmnd = cmnd;
        this.address = address;
        this.birthday = birthday;
        this.household = household;
        this.phone = phone;
        this.contracts = contracts;
    }

    public Customer() {
    }

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

    public int getCmnd() {
        return cmnd;
    }

    public void setCmnd(int cmnd) {
        this.cmnd = cmnd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getHousehold() {
        return household;
    }

    public void setHousehold(String household) {
        this.household = household;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
