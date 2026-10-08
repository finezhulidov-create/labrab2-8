package dev.zhulidov.labrab2_8.controller;


import dev.zhulidov.labrab2_8.model.*;
import dev.zhulidov.labrab2_8.service.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class MyController {

    private final MyService service;




    @PostMapping("/feedback")
    public ResponseEntity<Response> feedBack(@RequestBody @Valid Request request,
                                             BindingResult bindingResult){

        return ResponseEntity.ok(service.sendFeedBack(request,bindingResult));
    }



}
