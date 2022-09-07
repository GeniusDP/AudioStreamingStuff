package com.kpi.zaranik.template.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;

@RestController
@RequestMapping("/cookies")
public class CookiesTestController {

    @GetMapping("/get")
    public ResponseEntity<String> testCookies2(@CookieValue(value = "COOKIE") Cookie cookie) {
        return ResponseEntity.ok(cookie.getValue());
    }

}
