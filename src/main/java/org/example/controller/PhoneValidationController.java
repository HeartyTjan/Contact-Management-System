package org.example.controller;


import org.example.dto.response.CallerInformation;
import org.example.service.PhoneNumberValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/callerInfo")
@CrossOrigin("*")
public class PhoneValidationController {

    @Autowired
    private PhoneNumberValidationService numVerifyServices;

    @GetMapping("{number}")
    public Mono<CallerInformation> getCallerInfo(@PathVariable("number") String phoneNumber){
        return numVerifyServices.validatePhoneNumber(phoneNumber);
    }
}
