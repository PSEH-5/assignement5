package com.sapient.code.assignment.controller;

import com.sapient.code.assignment.model.Output;
import com.sapient.code.assignment.service.FootballService;
import com.sapient.code.assignment.util.ObjectMapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/v1/")
@Slf4j
public class FootBallController {
    @Autowired
    private FootballService footballService;

    @RequestMapping(value = "standing", method = RequestMethod.GET)
    public ResponseEntity<String> getStanding(
            @RequestParam(name = "countryName", required = false) String countryName,
            @RequestParam(name = "teamName", required = false) String teamName,
            @RequestParam(name = "leagueName", required = false) String leagueName) {

        if (countryName == null && teamName == null && leagueName == null) {
            return getError(" Please provide either countryName , teamName or leagueName");
        }
        try {
            List<Output> outputs = footballService.getLeagueDetails(countryName, teamName, leagueName);

            if (outputs != null && outputs.size() > 0) {
                String jsonString = ObjectMapperUtil.convertObjectToJson(outputs);

                return ResponseEntity.ok()
                        .header("content-type", "application/json")
                        .body(jsonString);

            }
            return getError(" Unable to find standings details.");
        } catch (Exception ex) {
            log.error(" error occurred while processing request {} ", ex.getMessage(), ex);

            return getError(" Unable to find standings details due to api failure");
        }
    }

    private ResponseEntity<String> getError(String errMsg) {
        Map<String, String> errInfo = new HashMap<>();
        errInfo.put("error", errMsg);
        String jsonErrorMsg = ObjectMapperUtil.convertObjectToJson(errInfo);
        return ResponseEntity.badRequest()
                .header("content-type", "application/json")
                .body(jsonErrorMsg);
    }

}
