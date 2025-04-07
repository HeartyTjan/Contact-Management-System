package org.example.service;

import org.example.config.NumVerifyConfig;
import org.example.dto.response.CallerInformation;
import org.example.utility.SecuredDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class NumVerifyServicesImpl implements PhoneNumberValidationService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private NumVerifyConfig config;


    @Override
    public Mono<CallerInformation> validatePhoneNumber(String phoneNumber){
//        String hashedPhoneNumber = SecuredDetails.hashPhoneNumber(phoneNumber);

        return webClientBuilder.baseUrl("http://apilayer.net/api")
                                .build()
                                .get()
                                    .uri(uriBuilder -> uriBuilder
                                        .path("/validate")
                                        .queryParam("access_key", config.getAccessKey())
                                            .queryParam("number", phoneNumber)
                                            .build())
                                .retrieve()
                                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                                            _ -> Mono.error(new RuntimeException("External API error")))
                                .bodyToMono(new ParameterizedTypeReference<Map<String,Object>>() {})
                                    .map(response -> transformResponseToCallerInfo(response,phoneNumber));
    }

    private CallerInformation transformResponseToCallerInfo(Map<String, Object> response, String phoneNumber){
        boolean isValid = (Boolean) response.getOrDefault("valid",false);
        if(!isValid){
            return new CallerInformation(false,phoneNumber, "Unknown","Unknown", "Invalid");
        }

        String country = (String) response.getOrDefault("country_name", "Unknown");
        String location = (String) response.getOrDefault("location","Unknown");
        String carrier = (String) response.getOrDefault("carrier", "Unknown");
        return new CallerInformation(true,phoneNumber,country,location,carrier);
    }


}
