package com.glady.challenge.cucumber.steps;

import com.glady.challenge.data.entity.GiftDeposit;
import com.glady.challenge.data.entity.UserClient;
import com.glady.challenge.data.repository.UserRepository;
import com.glady.challenge.dto.GiftDepositAdditionsDto;
import com.glady.challenge.service.GiftService;
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
public class GiftStep {

    private final UserRepository userRepository;
    private final GiftService giftService;

    @When("The user whose name is {string} receives multiple gift deposits")
    public void giftDeposition(String userName, DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        Optional<UserClient> oUser = userRepository.findByName(userName);
        Assertions.assertTrue(oUser.isPresent());

        GiftDepositAdditionsDto giftDepositAdditionsDto = new GiftDepositAdditionsDto();
        for (Map<String, String> row : rows) {
            GiftDepositAdditionsDto.SingleGiftDepositAdditionDto singleGiftDepositAdditionDto = new GiftDepositAdditionsDto.SingleGiftDepositAdditionDto();
            singleGiftDepositAdditionDto.setAmount(new BigDecimal(row.get("value")));
            singleGiftDepositAdditionDto.setCompanyName(row.get("companyName"));
            singleGiftDepositAdditionDto.setReceptionDate(LocalDate.parse(row.get("receptionDate")));
            giftDepositAdditionsDto.getGiftAdditions().add(singleGiftDepositAdditionDto);
        }
        giftService.addGiftDeposits(oUser.get().getId(), giftDepositAdditionsDto);


    }

    @When("I can check that the user whose name is {string} has received multiple gift deposits")
    public void giftDepositionCheck(String userName, DataTable table) {
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
                                        .getGiftDeposits()
                                        .stream()
                                        .map(GiftDeposit::getCompanyName)
                                        .toList()))
                .isEqualTo(true);
        softly.assertThat(
                        dates.containsAll(
                                oUser.get()
                                        .getGiftDeposits()
                                        .stream()
                                        .map(GiftDeposit::getReceptionDate)
                                        .toList()))
                .isEqualTo(true);

        softly.assertThat(
                        amounts.containsAll(
                                oUser.get()
                                        .getGiftDeposits()
                                        .stream()
                                        .map(GiftDeposit::getAmount)
                                        .toList()))
                .isEqualTo(true);

        softly.assertAll();


    }

    @And("That the user whose name is {string} has {int} expired gift deposit")
    public void thatTheUserWhoseNameIsHasExpiredGiftDeposit(String userName, int nbExpiredGiftDeposit) {
        Optional<UserClient> oUser = userRepository.findByName(userName);
        Assertions.assertTrue(oUser.isPresent());

        Assertions.assertEquals(nbExpiredGiftDeposit, oUser.get().getGiftDeposits().stream().filter(GiftDeposit::isExpired).count());
    }
}
