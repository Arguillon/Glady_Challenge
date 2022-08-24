package com.glady.challenge.cucumber.steps;

import com.glady.challenge.data.entity.MealDeposit;
import com.glady.challenge.data.entity.UserClient;
import com.glady.challenge.data.repository.UserRepository;
import com.glady.challenge.dto.MealDepositAdditionsDto;
import com.glady.challenge.service.MealService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Data
@Transactional
public class MealStep {

    private final UserRepository userRepository;
    private final MealService mealService;

    @When("The user whose name is {string} receives multiple meal deposits")
    public void mealDeposition(String userName, DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        Optional<UserClient> oUser = userRepository.findByName(userName);
        Assertions.assertTrue(oUser.isPresent());

        MealDepositAdditionsDto mealDepositAdditionsDto = new MealDepositAdditionsDto();

        for (Map<String, String> row : rows) {
            MealDepositAdditionsDto.SingleMealDepositAdditionDto singleMealDepositAdditionDto = new MealDepositAdditionsDto.SingleMealDepositAdditionDto();
            singleMealDepositAdditionDto.setAmount(new BigDecimal(row.get("value")));
            singleMealDepositAdditionDto.setCompanyName(row.get("companyName"));
            singleMealDepositAdditionDto.setReceptionDate(LocalDate.parse(row.get("receptionDate")));
            mealDepositAdditionsDto.getMealAdditions().add(singleMealDepositAdditionDto);
        }
        
        mealService.addMealDeposits(oUser.get().getId(), mealDepositAdditionsDto);
    }

    @When("I can check that the user whose name is {string} has received multiple meal deposits")
    public void mealDepositionCheck(String userName, DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        Optional<UserClient> oUser = userRepository.findByName(userName);
        Assertions.assertTrue(oUser.isPresent());

        List<String> companyNames = new ArrayList<>();
        List<BigDecimal> amounts = new ArrayList<>();
        List<LocalDate> dates = new ArrayList<>();

        for (Map<String, String> row : rows) {
            amounts.add(new BigDecimal(row.get("value")));
            companyNames.add(row.get("companyName"));
            dates.add(LocalDate.parse(row.get("receptionDate")));
        }

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(
                        companyNames.containsAll(
                                oUser.get()
                                        .getMealDeposits()
                                        .stream()
                                        .map(MealDeposit::getCompanyName)
                                        .toList()))
                .isEqualTo(true);
        softly.assertThat(
                        dates.containsAll(
                                oUser.get()
                                        .getMealDeposits()
                                        .stream()
                                        .map(MealDeposit::getReceptionDate)
                                        .toList()))
                .isEqualTo(true);

        softly.assertThat(
                        amounts.containsAll(
                                oUser.get()
                                        .getMealDeposits()
                                        .stream()
                                        .map(MealDeposit::getAmount)
                                        .toList()))
                .isEqualTo(true);

        softly.assertAll();


    }

    @And("That the user whose name is {string} has {int} expired meal deposit")
    public void thatTheUserWhoseNameIsHasExpiredMealDeposit(String userName, int nbExpiredMealDeposit) {
        Optional<UserClient> oUser = userRepository.findByName(userName);
        Assertions.assertTrue(oUser.isPresent());

        Assertions.assertEquals(nbExpiredMealDeposit, oUser.get().getMealDeposits().stream().filter(MealDeposit::isExpired).count());
    }
}
