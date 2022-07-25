package ru.inrtu.backend.controller;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/schoolchild-page/api")
public class MainController {

    @GetMapping("/testMethod")
    public ResponseEntity<?> testController(){
        System.out.println("Hello from main controller");
        return ResponseEntity.ok("Hello from school-page app");
    }
}
