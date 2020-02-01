package com.sapient.code.assignment.model;

import lombok.Data;

@Data
public class CountryLeagueIdDetails {
    /*
    {
    "country_id": "41",
    "country_name": "England",
    "league_id": "149",
    "league_name": "Championship"
  }
     */

    private String country_id;
    private String country_name;
    private String league_id;
    private String league_name;
}
