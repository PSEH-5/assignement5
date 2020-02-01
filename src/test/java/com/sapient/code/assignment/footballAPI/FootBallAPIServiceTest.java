package com.sapient.code.assignment.footballAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.code.assignment.model.CountryDetails;
import com.sapient.code.assignment.model.CountryLeagueIdDetails;
import com.sapient.code.assignment.model.LeagueDetails;
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
        validateLeagueDetails(leagueDetails);
    }

    private static final String COUNTRY_ID = "41";
    private static final String LEAGUE_ID = "148";

    @Test
    public void testLeagueStanding() {
        List<LeagueDetails> leagueDetails
                = footBallAPIService.getLeagueStanding("148");

        Assertions.assertNotNull(leagueDetails);
        validateLeagueDetails(leagueDetails);
    }

    @Test
    void getAllCountry() {
        List<CountryDetails> countryDetails = footBallAPIService.getAllCountry();
        Assertions.assertNotNull(countryDetails);
        Assertions.assertNotEquals(0, countryDetails.size());
        for (CountryDetails countryDetail : countryDetails) {
            Assertions.assertNotNull(countryDetail.getCountry_name());
            Assertions.assertNotEquals(0, countryDetail.getCountry_id());
        }
    }

    @Test
    void getCountryLeagues() {
        List<CountryLeagueIdDetails> countryLeagueIdDetails
                = footBallAPIService.getCountryLeagues(COUNTRY_ID);
        Assertions.assertNotNull(countryLeagueIdDetails);
        for (CountryLeagueIdDetails countryLeagueIdDetail : countryLeagueIdDetails) {
            Assertions.assertNotNull(countryLeagueIdDetail.getLeague_id());
            Assertions.assertNotNull(countryLeagueIdDetail.getCountry_id());
            Assertions.assertNotNull(countryLeagueIdDetail.getCountry_name());
            Assertions.assertNotNull(countryLeagueIdDetail.getLeague_name());
        }
    }

    @Test
    void getLeagueDetails() {
        List<LeagueDetails> leagueDetailsList
                = footBallAPIService.getLeagueDetails(COUNTRY_ID);
        Assertions.assertNotNull(leagueDetailsList);
        Assertions.assertNotEquals(0, leagueDetailsList.size());
        validateLeagueDetails(leagueDetailsList);
    }

    @Test
    void getLeagueStanding() {
        List<LeagueDetails> leagueDetails
                = footBallAPIService.getLeagueStanding(LEAGUE_ID);
        Assertions.assertNotNull(leagueDetails);
        Assertions.assertNotEquals(0, leagueDetails.size());
        validateLeagueDetails(leagueDetails);
    }

    private void validateLeagueDetails(List<LeagueDetails> leagueDetailsList) {

        for (LeagueDetails leagueDetails : leagueDetailsList) {
            Assertions.assertNotNull(leagueDetails.getCountry_name());
            Assertions.assertNotNull(leagueDetails.getTeam_name());
            Assertions.assertNotNull(leagueDetails.getLeague_name());
            Assertions.assertNotEquals(0, leagueDetails.getLeague_id());
            Assertions.assertNotEquals(0, leagueDetails.getTeam_id());
            Assertions.assertNotEquals(0, leagueDetails.getOverall_league_position());
        }
    }
}
