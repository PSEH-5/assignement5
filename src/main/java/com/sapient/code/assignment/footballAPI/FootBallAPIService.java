package com.sapient.code.assignment.footballAPI;

import com.sapient.code.assignment.config.ApplicationEnv;
import com.sapient.code.assignment.model.CountryDetails;
import com.sapient.code.assignment.model.CountryLeagueIdDetails;
import com.sapient.code.assignment.model.LeagueDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class FootBallAPIService {

    @Autowired
    private ApplicationEnv applicationEnv;

    @Autowired
    private RestTemplate restTemplate;


    public List<CountryDetails> getAllCountry() {
        String url = applicationEnv.getApiEndPoint()
                + "/?action=get_countries&APIkey=" + applicationEnv.getApiKey();

        ResponseEntity<CountryDetails[]> response = restTemplate.getForEntity(url, CountryDetails[].class);

        return Arrays.asList(response.getBody());
    }


    public List<CountryLeagueIdDetails> getCountryLeagues(String countryId) {
        String url = applicationEnv.getApiEndPoint()
                + "/?action=get_leagues&country_id=" + countryId + "&"
                + "APIkey=" + applicationEnv.getApiKey();

        ResponseEntity<CountryLeagueIdDetails[]> response
                = restTemplate.getForEntity(url, CountryLeagueIdDetails[].class);

        CountryLeagueIdDetails[] countries = response.getBody();

        return Arrays.asList(countries);
    }


    public List<LeagueDetails> getLeagueDetails(String countryId) {

        LeagueDetails[] leagueDetails = connectAndGetLeagueDetails(countryId);

        return Arrays.asList(leagueDetails);
    }


    public List<LeagueDetails> getLeagueStanding(String leagueId) {

        LeagueDetails[] leagueDetails = getStandingWithLeagueId(leagueId);

        return Arrays.asList(leagueDetails);
    }

    private LeagueDetails[] getStandingWithLeagueId(String leagueId) {

        String url = applicationEnv.getApiEndPoint()
                + "/?action=get_standings&league_id=" + leagueId + "&"
                + "APIkey=" + applicationEnv.getApiKey();

        ResponseEntity<LeagueDetails[]> response = restTemplate.getForEntity(url, LeagueDetails[].class);

        return response.getBody();
    }


    private LeagueDetails[] connectAndGetLeagueDetails(String countryId) {

        String url = applicationEnv.getApiEndPoint()
                + "/?action=get_leagues&country_id=" + countryId + "&"
                + "APIkey=" + applicationEnv.getApiKey();

        ResponseEntity<LeagueDetails[]> response = restTemplate.getForEntity(url, LeagueDetails[].class);
        return response.getBody();
    }

}
