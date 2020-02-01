package com.sapient.code.assignment.footballAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.code.assignment.model.CountryDetails;
import com.sapient.code.assignment.model.CountryLeagueIdDetails;
import com.sapient.code.assignment.model.LeagueDetails;
import com.sapient.code.assignment.util.ObjectMapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles(value = "test")
@Slf4j
public class FootBallAPIServiceTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    @Autowired
    private FootBallAPIService footBallAPIService;

    @Test
    public void testGetLeagueDetails() {
        List<LeagueDetails> leagueDetails
                = footBallAPIService.getLeagueDetails("41");

        Assertions.assertNotNull(leagueDetails);

        leagueDetails.stream().forEach(leagueDetails1 -> {
            Assertions.assertNotNull(leagueDetails1.getLeague_id());
            try {
                log.info(" {} ", OBJECT_MAPPER.writeValueAsString(leagueDetails1));
            } catch (JsonProcessingException jsonProcess) {
                jsonProcess.printStackTrace();
            }

        });
    }

    private static final String COUNTRY_ID = "41";
    private static final String LEAGUE_ID = "148";

    @Test
    public void testLeagueStanding() {
        List<LeagueDetails> leagueDetails
                = footBallAPIService.getLeagueStanding("148");

        Assertions.assertNotNull(leagueDetails);
        log.info(" {} ", ObjectMapperUtil.convertObjectToJson(leagueDetails));
    }

    @Test
    void getAllCountry() {
        List<CountryDetails> countryDetails = footBallAPIService.getAllCountry();
        Assertions.assertNotNull(countryDetails);
        Assertions.assertNotEquals(0, countryDetails.size());
    }

    @Test
    void getCountryLeagues() {
        List<CountryLeagueIdDetails> countryLeagueIdDetails
                = footBallAPIService.getCountryLeagues(COUNTRY_ID);
        Assertions.assertNotNull(countryLeagueIdDetails);
    }

    @Test
    void getLeagueDetails() {
        List<LeagueDetails> leagueDetailsList
                = footBallAPIService.getLeagueDetails(COUNTRY_ID);
        Assertions.assertNotNull(leagueDetailsList);
        Assertions.assertNotEquals(0, leagueDetailsList.size());
    }

    @Test
    void getLeagueStanding() {
        List<LeagueDetails> leagueDetails
                = footBallAPIService.getLeagueStanding(LEAGUE_ID);
        Assertions.assertNotNull(leagueDetails);
        Assertions.assertNotEquals(0, leagueDetails.size());

    }
}
