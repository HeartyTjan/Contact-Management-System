package org.example.service;

import org.example.dto.response.CallerInformation;
import reactor.core.publisher.Mono;

public interface PhoneNumberValidationService {
    Mono<CallerInformation> validatePhoneNumber(String phoneNumber);
}
