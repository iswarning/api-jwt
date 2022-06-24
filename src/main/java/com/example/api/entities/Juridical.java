package com.example.api.entities;

import com.example.api.entities.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "juridical")
public class Juridical extends Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "contract_info")
    private String contractInfo;

    @Column(name = "status")
    private String contractStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "notarized_date")
    private LocalDate notarizedDate;

    @NotEmpty(message = "registration_procedures is required")
    @Column(name = "registration_procedures")
    private String registrationProcedures;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "delivery_book_date")
    private LocalDate deliveryBookDate;

    @Column(name = "liquidation")
    private boolean liquidation;

    @Column(name = "bill_profile")
    private String billProfile;

    @NotNull(message = "book_holder is required")
    @Column(name = "book_holder")
    private String bookHolder;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "delivery_land_date")
    private LocalDate deliveryLandDate;

    @Column(name = "commitment")
    private String commitment;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    @JsonBackReference
    private Contract contract;

    public boolean isLiquidation(){
        return liquidation;
    }

    public Juridical() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContractInfo() {
        return contractInfo;
    }

    public void setContractInfo(String contractInfo) {
        this.contractInfo = contractInfo;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public LocalDate getNotarizedDate() {
        return notarizedDate;
    }

    public void setNotarizedDate(LocalDate notarizedDate) {
        this.notarizedDate = notarizedDate;
    }

    public String getRegistrationProcedures() {
        return registrationProcedures;
    }

    public void setRegistrationProcedures(String registrationProcedures) {
        this.registrationProcedures = registrationProcedures;
    }

    public LocalDate getDeliveryBookDate() {
        return deliveryBookDate;
    }

    public void setDeliveryBookDate(LocalDate deliveryBookDate) {
        this.deliveryBookDate = deliveryBookDate;
    }

    public String getBillProfile() {
        return billProfile;
    }

    public void setBillProfile(String billProfile) {
        this.billProfile = billProfile;
    }

    public String getBookHolder() {
        return bookHolder;
    }

    public void setBookHolder(String bookHolder) {
        this.bookHolder = bookHolder;
    }

    public LocalDate getDeliveryLandDate() {
        return deliveryLandDate;
    }

    public void setDeliveryLandDate(LocalDate deliveryLandDate) {
        this.deliveryLandDate = deliveryLandDate;
    }

    public String getCommitment() {
        return commitment;
    }

    public void setCommitment(String commitment) {
        this.commitment = commitment;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}