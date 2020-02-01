package com.sapient.code.assignment.api;

import com.sapient.code.assignment.config.ApplicationEnv;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(value = "test")
@Slf4j
class ApplicationEnvTest {

    @Autowired
    private ApplicationEnv applicationEnv;

    @Test
    public void testEndpointLoading() {
        String apiEndPoint = applicationEnv.getApiEndPoint();
        Assertions.assertNotNull(apiEndPoint);
        log.info(" {} ", apiEndPoint);
    }
}