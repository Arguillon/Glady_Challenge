package com.glady.challenge.mapper;

import com.glady.challenge.data.entity.MealDeposit;
import com.glady.challenge.model.MealDepositModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-24T20:00:43+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4 (Amazon.com Inc.)"
)
@Component
public class MealDepositModelMapperImpl implements MealDepositModelMapper {

    @Override
    public MealDepositModel toDestination(MealDeposit mealDeposit) {
        if ( mealDeposit == null ) {
            return null;
        }

        MealDepositModel mealDepositModel = new MealDepositModel();

        if ( mealDeposit.getId() != null ) {
            mealDepositModel.setId( mealDeposit.getId() );
        }
        mealDepositModel.setAmount( mealDeposit.getAmount() );
        mealDepositModel.setReceptionDate( mealDeposit.getReceptionDate() );
        mealDepositModel.setExpirationDate( mealDeposit.getExpirationDate() );
        mealDepositModel.setExpired( mealDeposit.isExpired() );

        return mealDepositModel;
    }

    @Override
    public MealDeposit toSource(MealDepositModel mealDeposit) {
        if ( mealDeposit == null ) {
            return null;
        }

        MealDeposit mealDeposit1 = new MealDeposit();

        mealDeposit1.setId( mealDeposit.getId() );
        mealDeposit1.setAmount( mealDeposit.getAmount() );
        mealDeposit1.setReceptionDate( mealDeposit.getReceptionDate() );
        mealDeposit1.setExpirationDate( mealDeposit.getExpirationDate() );
        mealDeposit1.setExpired( mealDeposit.isExpired() );

        return mealDeposit1;
    }
}
