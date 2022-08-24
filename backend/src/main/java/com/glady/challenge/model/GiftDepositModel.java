package com.glady.challenge.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class GiftDepositModel {
    private int id;
    private BigDecimal amount;
    private LocalDate receptionDate;
    private LocalDate expirationDate;
    private String companyName;
    private boolean isExpired;
}
