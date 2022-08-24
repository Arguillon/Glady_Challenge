package com.glady.challenge.mapper;

import com.glady.challenge.data.entity.GiftDeposit;
import com.glady.challenge.model.GiftDepositModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-24T20:00:43+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4 (Amazon.com Inc.)"
)
@Component
public class GiftDepositModelMapperImpl implements GiftDepositModelMapper {

    @Override
    public GiftDepositModel toDestination(GiftDeposit giftDeposit) {
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

    @Override
    public GiftDeposit toSource(GiftDepositModel giftDeposit) {
        if ( giftDeposit == null ) {
            return null;
        }

        GiftDeposit giftDeposit1 = new GiftDeposit();

        giftDeposit1.setId( giftDeposit.getId() );
        giftDeposit1.setCompanyName( giftDeposit.getCompanyName() );
        giftDeposit1.setAmount( giftDeposit.getAmount() );
        giftDeposit1.setReceptionDate( giftDeposit.getReceptionDate() );
        giftDeposit1.setExpirationDate( giftDeposit.getExpirationDate() );
        giftDeposit1.setExpired( giftDeposit.isExpired() );

        return giftDeposit1;
    }
}
