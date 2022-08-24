package com.glady.challenge.cucumber.steps;

import com.glady.challenge.data.entity.GiftDeposit;
import com.glady.challenge.data.entity.MealDeposit;
import com.glady.challenge.data.entity.UserClient;
import com.glady.challenge.data.repository.UserRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

@RequiredArgsConstructor
@Data
@Transactional
public class UserStep {

    private final UserRepository userRepository;

    @Given("The user whose name is {string} exists")
    public void userCreation(String userName) {
        UserClient userClient = new UserClient();
        userClient.setName(userName);
        userRepository.save(userClient);
    }

    @Then("I can check that the user whose name is {string} has {double} euros in gift deposits and {double} euros in meal deposits")
    public void balanceCheck(String userName, double giftAmount, double mealAmount) {
        Optional<UserClient> oUser = userRepository.findByName(userName);
        Assertions.assertTrue(oUser.isPresent());
        UserClient user = oUser.get();
        Assertions.assertEquals(0, new BigDecimal(giftAmount)
                .compareTo(user.getGiftDeposits().stream().map(GiftDeposit::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add)));
        Assertions.assertEquals(0, new BigDecimal(mealAmount)
                .compareTo(user.getMealDeposits().stream().map(MealDeposit::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add)));
    }
}
