package com.ant.ttf.domain.library.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.java.Log;

@RestController
@RequestMapping("/api/v1/library")
@Log
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class LibController {

}
