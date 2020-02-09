package com.sapient.code.assignment.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(value = "test")
@Slf4j
@Disabled
class FootBallControllerTest {

    @Autowired
    private FootBallController footBallController;

    @Test
    void given_when_neitherCountryName_norTeamName_norLeagueName_passed_shouldReturnErrorMsg() {

        String expectedError = "{\"error\":\" Please provide either countryName , teamName or leagueName\"}";
        ResponseEntity<String> responseEntity = footBallController.getStanding(null, null, null);
        String body = responseEntity.getBody();
        Assertions.assertEquals(expectedError, body);
    }

    @Test
    void given_when_onlyCountryNamePassed_shouldReturnDetails() {

        String expectedError = "{\"error\":\" Please provide either countryName , teamName or leagueName\"}";
        ResponseEntity<String> responseEntity = footBallController.getStanding(null, null, null);
        String body = responseEntity.getBody();
        Assertions.assertEquals(expectedError, body);
    }


    @Test
    void given_when_onlyCountryNameAndPassed_shouldReturnDetails() {

        String expectedData = "[{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2625,\"teamName\":\"West Brom\",\"overAllPosition\":1},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2653,\"teamName\":\"Leeds\",\"overAllPosition\":2},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2639,\"teamName\":\"Fulham\",\"overAllPosition\":3},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2634,\"teamName\":\"Nottingham\",\"overAllPosition\":4},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2644,\"teamName\":\"Brentford\",\"overAllPosition\":5},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2643,\"teamName\":\"Preston\",\"overAllPosition\":6},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2650,\"teamName\":\"Bristol City\",\"overAllPosition\":7},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2637,\"teamName\":\"Cardiff\",\"overAllPosition\":8},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2618,\"teamName\":\"Swansea\",\"overAllPosition\":9},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2638,\"teamName\":\"Millwall\",\"overAllPosition\":10},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2651,\"teamName\":\"Sheffield Wed\",\"overAllPosition\":11},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2680,\"teamName\":\"Blackburn\",\"overAllPosition\":12},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2642,\"teamName\":\"Derby\",\"overAllPosition\":13},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2633,\"teamName\":\"Hull\",\"overAllPosition\":14},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2631,\"teamName\":\"Birmingham\",\"overAllPosition\":15},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2647,\"teamName\":\"Reading\",\"overAllPosition\":16},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2645,\"teamName\":\"QPR\",\"overAllPosition\":17},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2648,\"teamName\":\"Middlesbrough\",\"overAllPosition\":18},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2622,\"teamName\":\"Huddersfield\",\"overAllPosition\":19},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2624,\"teamName\":\"Stoke\",\"overAllPosition\":20},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2663,\"teamName\":\"Charlton\",\"overAllPosition\":21},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2679,\"teamName\":\"Wigan\",\"overAllPosition\":22},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2652,\"teamName\":\"Barnsley\",\"overAllPosition\":23},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2695,\"teamName\":\"Luton\",\"overAllPosition\":24}]";
        ResponseEntity<String> responseEntity = footBallController.getStanding("England", null, null);
        String body = responseEntity.getBody();
        Assertions.assertEquals(expectedData, body);
    }

    @Test
    void given_whenCountryNameAndLeagueNamePassed_shouldReturnDetails() {
        String expectedData = "[{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2625,\"teamName\":\"West Brom\",\"overAllPosition\":1},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2653,\"teamName\":\"Leeds\",\"overAllPosition\":2},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2639,\"teamName\":\"Fulham\",\"overAllPosition\":3},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2634,\"teamName\":\"Nottingham\",\"overAllPosition\":4},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2644,\"teamName\":\"Brentford\",\"overAllPosition\":5},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2643,\"teamName\":\"Preston\",\"overAllPosition\":6},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2650,\"teamName\":\"Bristol City\",\"overAllPosition\":7},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2637,\"teamName\":\"Cardiff\",\"overAllPosition\":8},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2618,\"teamName\":\"Swansea\",\"overAllPosition\":9},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2638,\"teamName\":\"Millwall\",\"overAllPosition\":10},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2651,\"teamName\":\"Sheffield Wed\",\"overAllPosition\":11},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2680,\"teamName\":\"Blackburn\",\"overAllPosition\":12},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2642,\"teamName\":\"Derby\",\"overAllPosition\":13},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2633,\"teamName\":\"Hull\",\"overAllPosition\":14},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2631,\"teamName\":\"Birmingham\",\"overAllPosition\":15},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2647,\"teamName\":\"Reading\",\"overAllPosition\":16},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2645,\"teamName\":\"QPR\",\"overAllPosition\":17},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2648,\"teamName\":\"Middlesbrough\",\"overAllPosition\":18},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2622,\"teamName\":\"Huddersfield\",\"overAllPosition\":19},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2624,\"teamName\":\"Stoke\",\"overAllPosition\":20},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2663,\"teamName\":\"Charlton\",\"overAllPosition\":21},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2679,\"teamName\":\"Wigan\",\"overAllPosition\":22},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2652,\"teamName\":\"Barnsley\",\"overAllPosition\":23},{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2695,\"teamName\":\"Luton\",\"overAllPosition\":24}]";
        ResponseEntity<String> responseEntity = footBallController.getStanding("England", null, "Championship");
        String body = responseEntity.getBody();
        Assertions.assertEquals(expectedData, body);
    }

    @Test
    void given_whenCountryNameAndLeagueAndTeamNamePassed_shouldReturnDetails() {
        String expectedData = "[{\"countryId\":41,\"countryName\":\"England\",\"leagueName\":\"Championship\",\"leagueId\":149,\"teamId\":2634,\"teamName\":\"Nottingham\",\"overAllPosition\":4}]";
        ResponseEntity<String> responseEntity
                = footBallController.getStanding("England", "Nottingham", "Championship");
        String body = responseEntity.getBody();
        Assertions.assertEquals(expectedData, body);
    }

    @Test
    void given_whenInvalidCountryNameAndLeagueAndTeamNamePassed_shouldReturnNoDetails() {
        String expectedData = "{\"error\":\" Unable to find standings details.\"}";
        ResponseEntity<String> responseEntity
                = footBallController.getStanding("England1", "Nottingham1", "Championship1");
        String body = responseEntity.getBody();
        Assertions.assertEquals(expectedData, body);
    }

}