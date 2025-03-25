package org.example.controller;


import org.example.dto.response.CallerInformation;
import org.example.service.PhoneNumberValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/callerInfo")
public class PhoneValidationController {

    @Autowired
    private PhoneNumberValidationService numVerifyServices;

    @GetMapping("{number}")
    public Mono<CallerInformation> getCallerInfo(@PathVariable("number") String phoneNumber){
        return numVerifyServices.validatePhoneNumber(phoneNumber);
    }
}
