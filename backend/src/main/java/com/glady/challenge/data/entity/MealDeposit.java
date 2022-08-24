package com.glady.challenge.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "MEAL_DEPOSIT")
public class MealDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount = BigDecimal.ZERO;

    @Column(name = "reception_date", nullable = false)
    private LocalDate receptionDate;

    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;

    @Column(name = "is_expired", nullable = false)
    private boolean isExpired;

    @ManyToOne()
    @JoinColumn(name = "id_gift_client", nullable = false)
    private UserClient userClient;
}
