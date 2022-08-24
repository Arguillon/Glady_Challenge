package com.glady.challenge.service;

import com.glady.challenge.data.entity.GiftDeposit;
import com.glady.challenge.data.entity.UserClient;
import com.glady.challenge.data.repository.GiftDepositRepository;
import com.glady.challenge.data.repository.UserRepository;
import com.glady.challenge.dto.GiftDepositAdditionsDto;
import com.glady.challenge.mapper.UserClientModelMapper;
import com.glady.challenge.model.UserClientModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class GiftService {


    private final UserRepository userRepository;
    private final UserService userService;
    private final GiftDepositRepository giftDepositRepository;
    private final UserClientModelMapper userClientModelMapper;

    @Value("${number.days.validity.gifts.deposit}")
    private int nbDaysGiftsValidity;


    public UserClientModel addGiftDeposits(Integer idUser, GiftDepositAdditionsDto giftDepositAdditionsDto) {

        UserClient userClient = userService.findByIdWithError(idUser);

        for (GiftDepositAdditionsDto.SingleGiftDepositAdditionDto giftDepositAddition : giftDepositAdditionsDto.getGiftAdditions()) {
            giftDepositCreation(userClient, giftDepositAddition);
        }
        userRepository.save(userClient);
        return userClientModelMapper.toDestination(userClient);
    }


    private void giftDepositCreation(UserClient userClient, GiftDepositAdditionsDto.SingleGiftDepositAdditionDto giftDepositAddition) {
        GiftDeposit giftDeposit = new GiftDeposit();
        giftDeposit.setAmount(giftDepositAddition.getAmount());
        giftDeposit.setCompanyName(giftDepositAddition.getCompanyName());
        giftDeposit.setReceptionDate(giftDepositAddition.getReceptionDate());
        giftDeposit.setExpirationDate(giftDepositAddition.getReceptionDate().plusDays(nbDaysGiftsValidity));
        giftDeposit.setExpired(LocalDate.now().isAfter(giftDeposit.getExpirationDate()));
        giftDeposit.setUserClient(userClient);
        giftDeposit = giftDepositRepository.save(giftDeposit);
        userClient.getGiftDeposits().add(giftDeposit);
    }
}
