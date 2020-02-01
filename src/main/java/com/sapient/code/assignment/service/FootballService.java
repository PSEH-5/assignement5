package com.sapient.code.assignment.service;

import com.sapient.code.assignment.footballAPI.FootBallAPIService;
import com.sapient.code.assignment.model.CountryDetails;
import com.sapient.code.assignment.model.CountryLeagueIdDetails;
import com.sapient.code.assignment.model.LeagueDetails;
import com.sapient.code.assignment.model.Output;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Slf4j
public class FootballService {

    @Autowired
    private FootBallAPIService footBallAPIService;


    public List<Output> getLeagueDetails(String countryName, String teamName,
                                         String leagueName) {

        List<LeagueDetails> leagueDetails = filterLeagueDetailsByAny(countryName, teamName, leagueName);

        if (leagueDetails.size() > 0) {

            return formatOutput(leagueDetails);
        }
        return null;
    }

    private List<Output> formatOutput(List<LeagueDetails> leagueDetails) {

        Map<String, String> countryNameId = countryNameCountryId();

        List<Output> outputs = new LinkedList<>();
        for (LeagueDetails leagueDetail : leagueDetails) {

            int countryId = Integer.parseInt(countryNameId.get(leagueDetail.getCountry_name()));

            Output output = Output.builder().countryId(countryId).countryName(leagueDetail.getCountry_name())
                    .leagueId(leagueDetail.getLeague_id())
                    .leagueName(leagueDetail.getLeague_name())
                    .teamId(leagueDetail.getTeam_id())
                    .teamName(leagueDetail.getTeam_name())
                    .overAllPosition(leagueDetail.getOverall_league_position()).build();
            outputs.add(output);
        }
        return outputs;
    }

    private Map<String, String> countryNameCountryId() {
        Map<String, String> countryNameId = new HashMap<>();
        List<CountryDetails> countryDetails = footBallAPIService.getAllCountry();
        for (CountryDetails countryDetail : countryDetails) {
            countryNameId.put(countryDetail.getCountry_name(), countryDetail.getCountry_id());
        }
        return countryNameId;
    }


    public List<LeagueDetails> filterLeagueDetailsByAny(String countryName, String teamName, String leagueName) {

        List<LeagueDetails> leagueDetails = getAllLeagueDetails();

        if (leagueDetails != null && leagueName != null) {
            leagueDetails = leagueDetails.stream()
                    .filter(leagueDetail -> leagueDetail.getLeague_name().equals(leagueName))
                    .collect(Collectors.toList());
        }

        if (leagueDetails != null && countryName != null) {
            leagueDetails = leagueDetails.stream()
                    .filter(leagueDetail -> leagueDetail.getCountry_name().equals(countryName))
                    .collect(Collectors.toList());
        }
        if (leagueDetails != null && teamName != null) {
            leagueDetails =
                    leagueDetails.stream().filter(leagueDetail -> leagueDetail.getTeam_name().equals(teamName))
                            .collect(Collectors.toList());
        }
        return leagueDetails;
    }

    List<LeagueDetails> getAllLeagueDetails() {

        List<LeagueDetails> leagueDetails = new LinkedList<>();

        List<CountryDetails> countryDetails = footBallAPIService.getAllCountry();

        for (CountryDetails country : countryDetails) {

            String countryId = country.getCountry_id();
            List<CountryLeagueIdDetails> countryLeagueIdDetails = footBallAPIService.getCountryLeagues(countryId);
            for (CountryLeagueIdDetails countryLeagueIdDetail : countryLeagueIdDetails) {

                List<LeagueDetails> leagueDetailsForCountry
                        = footBallAPIService.getLeagueStanding(countryLeagueIdDetail.getLeague_id());
                leagueDetails.addAll(leagueDetailsForCountry);
            }
        }

        return leagueDetails;
    }
}
