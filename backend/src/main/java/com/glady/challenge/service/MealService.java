package com.glady.challenge.service;

import com.glady.challenge.data.entity.MealDeposit;
import com.glady.challenge.data.entity.UserClient;
import com.glady.challenge.data.repository.MealDepositRepository;
import com.glady.challenge.data.repository.UserRepository;
import com.glady.challenge.dto.MealDepositAdditionsDto;
import com.glady.challenge.mapper.UserClientModelMapper;
import com.glady.challenge.model.UserClientModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;

@Service
@RequiredArgsConstructor
@Slf4j
public class MealService {

    private final UserRepository userRepository;
    private final UserService userService;
    private final MealDepositRepository mealDepositRepository;
    private final UserClientModelMapper userClientModelMapper;


    public UserClientModel addMealDeposits(Integer idUser, MealDepositAdditionsDto mealDepositAdditionsDto) {

        UserClient userClient = userService.findByIdWithError(idUser);

        for (MealDepositAdditionsDto.SingleMealDepositAdditionDto mealAddition : mealDepositAdditionsDto.getMealAdditions()) {
            mealDepositCreation(userClient, mealAddition);
        }
        userRepository.save(userClient);
        return userClientModelMapper.toDestination(userClient);
    }


    private void mealDepositCreation(UserClient userClient, MealDepositAdditionsDto.SingleMealDepositAdditionDto mealAddition) {
        MealDeposit mealDeposit = new MealDeposit();
        mealDeposit.setAmount(mealAddition.getAmount());
        mealDeposit.setCompanyName(mealAddition.getCompanyName());
        mealDeposit.setReceptionDate(mealAddition.getReceptionDate());
        mealDeposit.setExpirationDate(getLastDayOfNextYearFebruary(mealAddition.getReceptionDate()));
        mealDeposit.setExpired(LocalDate.now().isAfter(mealDeposit.getExpirationDate()));
        mealDeposit.setUserClient(userClient);
        mealDeposit = mealDepositRepository.save(mealDeposit);
        userClient.getMealDeposits().add(mealDeposit);
    }

    private LocalDate getLastDayOfNextYearFebruary(LocalDate receptionDate) {
        LocalDate februaryNextYear = LocalDate.of(receptionDate.plusYears(1).getYear(), 1, 1);
        return YearMonth.from(februaryNextYear).atEndOfMonth();
    }
}
