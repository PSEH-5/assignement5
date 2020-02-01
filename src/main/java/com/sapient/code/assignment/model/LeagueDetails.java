package com.sapient.code.assignment.model;

import lombok.Data;

@Data
public class LeagueDetails {
    private String country_name;
    private int league_id;
    private String league_name;
    private int team_id;
    private String team_name;
    private int overall_league_position;
    private int overall_league_payed;
    private int overall_league_W;
    private int overall_league_D;
    private int overall_league_L;
    private int overall_league_GF;
    private int overall_league_GA;
    private int overall_league_PTS;
    private int home_league_position;
    private int home_league_payed;
    private int home_league_W;
    private int home_league_D;
    private int home_league_L;
    private int home_league_GF;
    private int home_league_GA;
    private int home_league_PTS;
    private int away_league_position;
    private int away_league_payed;
    private int away_league_W;
    private int away_league_D;
    private int away_league_L;
    private int away_league_GF;
    private int away_league_GA;
    private int away_league_PTS;

}
