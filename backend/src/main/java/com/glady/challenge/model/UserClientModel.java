package com.glady.challenge.model;

import lombok.Data;

import java.util.List;

@Data
public class UserClientModel {
    private int id;
    private String name;
    private List<MealDepositModel> mealDeposits;
    private List<GiftDepositModel> giftDeposits;

}
