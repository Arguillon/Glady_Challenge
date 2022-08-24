package com.glady.challenge.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class MealDepositAdditionsDto {
    @NotNull
    private List<SingleMealDepositAdditionDto> mealAdditions = new ArrayList<>();

    @Data
    public static class SingleMealDepositAdditionDto {
        @NotNull
        @Positive
        private BigDecimal amount;

        @NotNull
        private String companyName;

        @NotNull
        private LocalDate receptionDate;
    }


}
