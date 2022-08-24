package com.glady.challenge.mapper;

import com.glady.challenge.data.entity.GiftDeposit;
import com.glady.challenge.data.entity.MealDeposit;
import com.glady.challenge.data.entity.UserClient;
import com.glady.challenge.model.GiftDepositModel;
import com.glady.challenge.model.MealDepositModel;
import com.glady.challenge.model.UserClientModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-24T20:00:43+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4 (Amazon.com Inc.)"
)
@Component
public class UserClientModelMapperImpl implements UserClientModelMapper {

    @Override
    public UserClientModel toDestination(UserClient userClient) {
        if ( userClient == null ) {
            return null;
        }

        UserClientModel userClientModel = new UserClientModel();

        if ( userClient.getId() != null ) {
            userClientModel.setId( userClient.getId() );
        }
        userClientModel.setName( userClient.getName() );
        userClientModel.setMealDeposits( mealDepositListToMealDepositModelList( userClient.getMealDeposits() ) );
        userClientModel.setGiftDeposits( giftDepositListToGiftDepositModelList( userClient.getGiftDeposits() ) );

        return userClientModel;
    }

    @Override
    public UserClient toSource(UserClientModel userClient) {
        if ( userClient == null ) {
            return null;
        }

        UserClient userClient1 = new UserClient();

        userClient1.setId( userClient.getId() );
        userClient1.setName( userClient.getName() );
        userClient1.setGiftDeposits( giftDepositModelListToGiftDepositList( userClient.getGiftDeposits() ) );
        userClient1.setMealDeposits( mealDepositModelListToMealDepositList( userClient.getMealDeposits() ) );

        return userClient1;
    }

    protected MealDepositModel mealDepositToMealDepositModel(MealDeposit mealDeposit) {
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

    protected List<MealDepositModel> mealDepositListToMealDepositModelList(List<MealDeposit> list) {
        if ( list == null ) {
            return null;
        }

        List<MealDepositModel> list1 = new ArrayList<MealDepositModel>( list.size() );
        for ( MealDeposit mealDeposit : list ) {
            list1.add( mealDepositToMealDepositModel( mealDeposit ) );
        }

        return list1;
    }

    protected GiftDepositModel giftDepositToGiftDepositModel(GiftDeposit giftDeposit) {
        if ( giftDeposit == null ) {
            return null;
        }

        GiftDepositModel giftDepositModel = new GiftDepositModel();

        if ( giftDeposit.getId() != null ) {
            giftDepositModel.setId( giftDeposit.getId() );
        }
        giftDepositModel.setAmount( giftDeposit.getAmount() );
        giftDepositModel.setReceptionDate( giftDeposit.getReceptionDate() );
        giftDepositModel.setExpirationDate( giftDeposit.getExpirationDate() );
        giftDepositModel.setCompanyName( giftDeposit.getCompanyName() );
        giftDepositModel.setExpired( giftDeposit.isExpired() );

        return giftDepositModel;
    }

    protected List<GiftDepositModel> giftDepositListToGiftDepositModelList(List<GiftDeposit> list) {
        if ( list == null ) {
            return null;
        }

        List<GiftDepositModel> list1 = new ArrayList<GiftDepositModel>( list.size() );
        for ( GiftDeposit giftDeposit : list ) {
            list1.add( giftDepositToGiftDepositModel( giftDeposit ) );
        }

        return list1;
    }

    protected GiftDeposit giftDepositModelToGiftDeposit(GiftDepositModel giftDepositModel) {
        if ( giftDepositModel == null ) {
            return null;
        }

        GiftDeposit giftDeposit = new GiftDeposit();

        giftDeposit.setId( giftDepositModel.getId() );
        giftDeposit.setCompanyName( giftDepositModel.getCompanyName() );
        giftDeposit.setAmount( giftDepositModel.getAmount() );
        giftDeposit.setReceptionDate( giftDepositModel.getReceptionDate() );
        giftDeposit.setExpirationDate( giftDepositModel.getExpirationDate() );
        giftDeposit.setExpired( giftDepositModel.isExpired() );

        return giftDeposit;
    }

    protected List<GiftDeposit> giftDepositModelListToGiftDepositList(List<GiftDepositModel> list) {
        if ( list == null ) {
            return null;
        }

        List<GiftDeposit> list1 = new ArrayList<GiftDeposit>( list.size() );
        for ( GiftDepositModel giftDepositModel : list ) {
            list1.add( giftDepositModelToGiftDeposit( giftDepositModel ) );
        }

        return list1;
    }

    protected MealDeposit mealDepositModelToMealDeposit(MealDepositModel mealDepositModel) {
        if ( mealDepositModel == null ) {
            return null;
        }

        MealDeposit mealDeposit = new MealDeposit();

        mealDeposit.setId( mealDepositModel.getId() );
        mealDeposit.setAmount( mealDepositModel.getAmount() );
        mealDeposit.setReceptionDate( mealDepositModel.getReceptionDate() );
        mealDeposit.setExpirationDate( mealDepositModel.getExpirationDate() );
        mealDeposit.setExpired( mealDepositModel.isExpired() );

        return mealDeposit;
    }

    protected List<MealDeposit> mealDepositModelListToMealDepositList(List<MealDepositModel> list) {
        if ( list == null ) {
            return null;
        }

        List<MealDeposit> list1 = new ArrayList<MealDeposit>( list.size() );
        for ( MealDepositModel mealDepositModel : list ) {
            list1.add( mealDepositModelToMealDeposit( mealDepositModel ) );
        }

        return list1;
    }
}
