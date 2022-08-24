package com.glady.challenge.mapper;

import com.glady.challenge.data.entity.MealDeposit;
import com.glady.challenge.model.MealDepositModel;
import org.mapstruct.Mapper;

@Mapper
public interface MealDepositModelMapper {
    MealDepositModel toDestination(MealDeposit mealDeposit);

    MealDeposit toSource(MealDepositModel mealDeposit);

}
