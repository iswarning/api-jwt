package com.example.api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "contracts")
public class Contract implements Serializable {

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotEmpty(message = "contractNo is required")
    @Column(name = "contract_no")
    private String contractNo;

    @NotNull(message = "area_signed can not null")
    @Column(name = "area_signed")
    private double areaSigned;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @JsonBackReference
    private Customer customer;

    @NotEmpty(message = "type is required")
    @Column(name = "type")
    private String type;

    @Column(name = "signed")
    private boolean signed;

    @Column(name = "signed_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate signedDate;

    @NotEmpty(message = "value is required")
    @Column(name = "value")
    private String value;

    @NotEmpty(message = "lot_number is required")
    @Column(name = "lot_number")
    private String lotNumber;

    @Column(name = "status")
    private String status;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "status_created_by")
    private String statusCreatedBy;

    @OneToOne(mappedBy = "contract", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private @NotNull @Valid Payment payment;

    @OneToOne(mappedBy = "contract", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private @NotNull @Valid Juridical juridical;

    public Contract() {
    }

    public boolean isSigned(){
        return signed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public double getAreaSigned() {
        return areaSigned;
    }

    public void setAreaSigned(double areaSigned) {
        this.areaSigned = areaSigned;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getSignedDate() {
        return signedDate;
    }

    public void setSignedDate(LocalDate signedDate) {
        this.signedDate = signedDate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getStatusCreatedBy() {
        return statusCreatedBy;
    }

    public void setStatusCreatedBy(String statusCreatedBy) {
        this.statusCreatedBy = statusCreatedBy;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Juridical getJuridical() {
        return juridical;
    }

    public void setJuridical(Juridical juridical) {
        this.juridical = juridical;
    }
}