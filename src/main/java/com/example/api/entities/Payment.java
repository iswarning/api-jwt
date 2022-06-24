package com.example.api.entities;

import com.example.api.entities.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;
@Entity(name = "payments")
public class Payment extends Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotEmpty(message = "payment_progress is required")
    @Column(name = "payment_progress")
    private String paymentProgress;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "payment_date_95")
    private LocalDate paymentDate95;

    @Column(name = "payment_status")
    private boolean paymentStatus;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    @JsonBackReference
    private Contract contract;

}
