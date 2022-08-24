package com.glady.challenge.mapper;

import com.glady.challenge.data.entity.GiftDeposit;
import com.glady.challenge.model.GiftDepositModel;
import org.mapstruct.Mapper;

@Mapper
public interface GiftDepositModelMapper {
    GiftDepositModel toDestination(GiftDeposit giftDeposit);

    GiftDeposit toSource(GiftDepositModel giftDeposit);

}
