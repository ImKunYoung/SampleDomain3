package com.mycompany.myapp.web.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jhipster.web.util.HeaderUtil;

/**
 * packageName    : com.mycompany.myapp.web.rest
 * fileName       : WelcomeResource
 * author         : ImKunYoung
 * date           : 2023-02-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-02-15        ImKunYoung       최초 생성
 */
@RestController
@RequestMapping("/welcome")
public class WelcomeResource {

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final Environment env;

    public WelcomeResource(Environment env) {
        this.env = env;
    }

    @GetMapping
    public ResponseEntity<String> welcome() {
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createAlert(applicationName, "welcome.message", applicationName))
            .body(env.getProperty("welcome.message"));
    }
}
