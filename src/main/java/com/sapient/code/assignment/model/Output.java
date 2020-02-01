package com.sapient.code.assignment.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Output {
    private int countryId;
    private String countryName;
    private String leagueName;
    private int leagueId;
    private int teamId;
    private String teamName;
    private int overAllPosition;
}

