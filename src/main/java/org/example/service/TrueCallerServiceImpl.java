package org.example.service;

import org.example.dto.response.CallerInformation;
import reactor.core.publisher.Mono;

public class TrueCallerServiceImpl implements PhoneNumberValidationService{
    @Override
    public Mono<CallerInformation> validatePhoneNumber(String phoneNumber) {
        return null;
    }
}
